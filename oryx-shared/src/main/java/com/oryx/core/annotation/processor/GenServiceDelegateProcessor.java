package com.oryx.core.annotation.processor;

import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.javajin.JinAnnotationBuilder;
import com.oryx.core.javajin.JinFieldBuilder;
import com.oryx.core.javajin.JinGenericType;
import com.oryx.core.javajin.JinTypeBuilder;
import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.enums.EnumJinType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@SupportedAnnotationTypes(GenServiceDelegateProcessor.AnnotationFqn)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenServiceDelegateProcessor extends AbstractProcessor {
    public final static String AnnotationFqn = "com.oryx.core.annotation.decl.GenServiceDelegate";
    final static Logger logger = Logger.getLogger(GenServiceDelegateProcessor.class);

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
        for (Element e : roundEnv.getElementsAnnotatedWith(GenServiceDelegate.class)) {
            if (e.getKind() != ElementKind.CLASS)
                continue;
            processTypeElement((TypeElement) e);
        }

        roundEnv.errorRaised();

        return true;
    }

    private void processTypeElement(TypeElement element) {
        String packageName = getPackageName(element).replace("model", "service");
        String entityClassName = getEnclosingTypeElement(element).getSimpleName().toString();
        String builderClassName = getEnclosingTypeElement(element).getSimpleName().toString() + "ServiceDelegate";

        String builderClassFqn = packageName + "." + builderClassName;

        GeneratorContext ctx = new GeneratorContext(element, getPackageName(element), packageName, entityClassName, builderClassName, builderClassFqn);
        StringBuilder sb = new StringBuilder();
        generateClassCode(ctx, sb);
        saveClass(ctx, sb);
    }

    private void generateClassCode(GeneratorContext ctx, StringBuilder sb) {
        JinTypeBuilder jinTypeBuilder = new JinTypeBuilder(ctx.packageName, EnumJinType.CLASS, ctx.builderClassName);

        JinAnnotationBuilder annotationBuilder = jinTypeBuilder.addAnnotation(Service.class);

        jinTypeBuilder.addmodifier(EnumJinModifier.PUBLIC)
                .addImportPackage(ctx.entityPackageName)
                .addImportPackage(ctx.packageName.replace("com.oryx.core.service", "com.oryx.remote.webservice.element.model")) //"com.oryx.remote.webservice.element.model")
                .addImportPackage("com.oryx.core.service")
                .addImportPackage("com.oryx.remote.webservices.service.personservice");

        JinGenericType extendsType = jinTypeBuilder.addExtendsTypes("AbstractCrudServiceDelegate");
        extendsType.addInnerTypes("Xml" + ctx.entityClassName)
                .addInnerTypes(ctx.entityClassName);

        //@Autowired private PersonRepository repository;
        jinTypeBuilder.addImportPackage(getPackageName(ctx.element).replace("model", "repository"));
        JinFieldBuilder jinFieldBuilderRepo = new JinFieldBuilder(new JinGenericType(ctx.entityClassName + "Repository"), "repository")
                .addModifier(EnumJinModifier.PRIVATE)
                .addAnnotation(Autowired.class);
        jinTypeBuilder.addField(jinFieldBuilderRepo);

        //@Autowired private PersonRQTokenClassType rQClassTypes;
        jinTypeBuilder.addImportPackage(getPackageName(ctx.element).replace("model", "model.provider"));
        JinFieldBuilder jinFieldBuilderRq = new JinFieldBuilder(new JinGenericType(ctx.entityClassName + "TypeByTokenProvider"), "rQClassTypes")
                .addModifier(EnumJinModifier.PRIVATE)
                .addAnnotation(Autowired.class);

        jinTypeBuilder.addField(jinFieldBuilderRq);

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
