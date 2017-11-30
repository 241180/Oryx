package com.oryx.core.annotation.processor;

import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.javajin.JinAnnotationBuilder;
import com.oryx.core.javajin.JinFieldBuilder;
import com.oryx.core.javajin.JinGenericType;
import com.oryx.core.javajin.JinTypeBuilder;
import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.enums.EnumJinType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes(GenTypeByTokenProviderProcessor.AnnotationFqn)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenTypeByTokenProviderProcessor extends AbstractProcessor {
    public final static String AnnotationFqn = "com.oryx.core.annotation.decl.GenTypeByTokenProvider";
    final static String FIND_BY = "findBy";
    final static Logger logger = Logger.getLogger(GenTypeByTokenProviderProcessor.class);
    private final static String tab = "    ";

    private static String getPackageName(Element element) {
        while (element != null && !(element instanceof PackageElement))
            element = element.getEnclosingElement();
        if (element == null)
            return null;
        return ((PackageElement) element).getQualifiedName().toString();
    }

    private static TypeElement getEnclosingTypeElement(Element element) {
        while (element != null && !(element instanceof TypeElement))
            element = element.getEnclosingElement();
        if (element == null)
            return null;
        return (TypeElement) element;
    }

    private static String capitalize(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element e : roundEnv.getElementsAnnotatedWith(GenTypeByTokenProvider.class)) {
            if (e.getKind() != ElementKind.CLASS)
                continue;
            processTypeElement((TypeElement) e);
        }

        roundEnv.errorRaised();

        return true;
    }

    private void processTypeElement(TypeElement element) {
        String packageName = getPackageName(element);
        if (getPackageName(element).contains("model")) {
            packageName = getPackageName(element).replace("model", "model.provider");
        } else if (getPackageName(element).contains("view")) {
            packageName = getPackageName(element).replace("view", "view.provider");
        }
        String entityClassName = getEnclosingTypeElement(element).getSimpleName().toString();
        String builderClassName = getEnclosingTypeElement(element).getSimpleName().toString() + "TypeByTokenProvider";

        String builderClassFqn = packageName + "." + builderClassName;

        GeneratorContext ctx = new GeneratorContext(element, getPackageName(element), packageName, entityClassName, builderClassName, builderClassFqn);
        StringBuilder sb = new StringBuilder();
        generateClassCode(ctx, sb);
        saveClass(ctx, sb);
    }

    private void generateClassCode(GeneratorContext ctx, StringBuilder sb) {
        JinTypeBuilder jinTypeBuilder = new JinTypeBuilder(ctx.packageName, EnumJinType.CLASS, ctx.entityClassName + "TypeByTokenProvider");
        JinAnnotationBuilder annotationBuilder = jinTypeBuilder.addAnnotation(Component.class);


        String xmlEntityPackage = ctx.packageName;
        if (ctx.packageName.contains("model")) {
            xmlEntityPackage = ctx.packageName.replace("com.oryx.core.model.provider", "com.oryx.remote.webservice.element.model");
        } else if (ctx.packageName.contains("view")) {
            xmlEntityPackage = ctx.packageName.replace("com.oryx.core.view.provider", "com.oryx.remote.webservice.element.view");
        }

        jinTypeBuilder.addmodifier(EnumJinModifier.PUBLIC)
                .addImportPackage(ctx.entityPackageName)
                .addImportPackage(xmlEntityPackage) //"com.oryx.remote.webservice.element.model")
                .addImportPackage("com.oryx.remote.webservice.element.view")
                .addImportPackage("com.oryx.remote.webservices.service." + ctx.entityClassName.toLowerCase() + "service");


        GenTypeByTokenProvider dataRepoBuilderAnnotation = ctx.element.getAnnotation(GenTypeByTokenProvider.class);
        String extendsTypeStr = dataRepoBuilderAnnotation.extendType();
        logger.info("Annottion extendType : " + ctx.entityClassName + " - " + extendsTypeStr);

        jinTypeBuilder.addExtendsTypes(extendsTypeStr);

        JinFieldBuilder jinFieldBuilder = new JinFieldBuilder(new JinGenericType(Class.class), "ENTITY_CLASS_TYPE")
                .addModifier(EnumJinModifier.PRIVATE)
                .addModifier(EnumJinModifier.STATIC)
                .addModifier(EnumJinModifier.FINAL)
                .setDefaultValue(ctx.entityClassName + ".class");

        jinTypeBuilder.addField(jinFieldBuilder);

        jinFieldBuilder = new JinFieldBuilder(new JinGenericType(Class.class), "XML_ENTITY_CLASS_TYPE")
                .addModifier(EnumJinModifier.PRIVATE)
                .addModifier(EnumJinModifier.STATIC)
                .addModifier(EnumJinModifier.FINAL)
                .setDefaultValue("Xml" + ctx.entityClassName + ".class");

        jinTypeBuilder.addField(jinFieldBuilder);

        String requestDefaultValue = "CrudRequest.class";
        if (ctx.entityClassName.endsWith("View")) {
            requestDefaultValue = "ViewRequest.class";
        }

        //private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
        jinFieldBuilder = new JinFieldBuilder(new JinGenericType(Class.class), "CRUD_REQUEST_CLASS_TYPE")
                .addModifier(EnumJinModifier.PRIVATE)
                .addModifier(EnumJinModifier.STATIC)
                .addModifier(EnumJinModifier.FINAL)
                .setDefaultValue(requestDefaultValue);

        jinTypeBuilder.addField(jinFieldBuilder);

        String responseDefaultValue = "CrudResponse.class";
        if (ctx.entityClassName.endsWith("View")) {
            responseDefaultValue = "ViewResponse.class";
        }

        //private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
        jinFieldBuilder = new JinFieldBuilder(new JinGenericType(Class.class), "CRUD_RESPONSE_CLASS_TYPE")
                .addModifier(EnumJinModifier.PRIVATE)
                .addModifier(EnumJinModifier.STATIC)
                .addModifier(EnumJinModifier.FINAL)
                .setDefaultValue(responseDefaultValue);

        jinTypeBuilder.addField(jinFieldBuilder);

        StringBuffer buffer = new StringBuffer();
        jinTypeBuilder.save(buffer);

        sb.append(buffer);
    }

    private void saveClass(GeneratorContext ctx, StringBuilder sb) {
        try {
            JavaFileObject jfo = processingEnv.getFiler().createSourceFile(ctx.builderClassFqn, ctx.element);

            OutputStream os = jfo.openOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.print(sb.toString());
            pw.close();
            os.close();

            processingEnv.getMessager().printMessage(Kind.NOTE, "Builder generated for this constructor: " + ctx.builderClassFqn, ctx.element);
        } catch (IOException e) {
            e.printStackTrace();
            processingEnv.getMessager().printMessage(Kind.ERROR, "Error generating builder, a builder may already exist (" + ctx.builderClassFqn + ") !" + e, ctx.element);
        }
    }

    private static class GeneratorContext {
        final TypeElement element;
        final String packageName;
        final String entityPackageName;
        final String builderClassName;
        String entityClassName;
        String builderClassFqn;

        public GeneratorContext(TypeElement element, String entityPackageName, String packageName, String entityClassName, String builderClassName, String builderClassFqn) {
            this.element = element;
            this.packageName = packageName;
            this.builderClassName = builderClassName;
            this.entityClassName = entityClassName;
            this.builderClassFqn = builderClassFqn;
            this.entityPackageName = entityPackageName;
        }
    }
}
