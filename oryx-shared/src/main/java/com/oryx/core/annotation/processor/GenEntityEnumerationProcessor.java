package com.oryx.core.annotation.processor;

import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.javajin.JinAnnotationBuilder;
import com.oryx.core.javajin.JinFieldBuilder;
import com.oryx.core.javajin.JinGenericType;
import com.oryx.core.javajin.JinTypeBuilder;
import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.enums.EnumJinType;
import org.apache.log4j.Logger;

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
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes(GenEntityEnumerationProcessor.AnnotationFqn)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenEntityEnumerationProcessor extends AbstractProcessor {
    public final static String AnnotationFqn = "com.oryx.core.annotation.decl.GenEntityEnumeration";
    final static Logger logger = Logger.getLogger(GenEntityEnumerationProcessor.class);
    public static JinTypeBuilder jinTypeBuilder = null;
    ;
    public static GeneratorContext ctx = null;
    public static StringBuilder sb = new StringBuilder();

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
        int count = 0;
        for (Element e : roundEnv.getElementsAnnotatedWith(GenEntityEnumeration.class)) {
            if (e.getKind() != ElementKind.CLASS)
                continue;
            processTypeElement((TypeElement) e);
            count++;
        }

        if (count > 0) {
            StringBuffer buffer = new StringBuffer();
            jinTypeBuilder.save(buffer);
            sb.append(buffer);

            saveClass(ctx, sb);
        }

        roundEnv.errorRaised();

        return true;
    }

    private void processTypeElement(TypeElement element) {
        if (!getPackageName(element).contains("model") && !getPackageName(element).contains("view")) {
            logger.error("package name must contain model or wiew provider");
        } else {
            int index = getPackageName(element).indexOf("model");
            if (getPackageName(element).indexOf("model") < 0) {
                index = getPackageName(element).indexOf("view");
            }

            String packageName = getPackageName(element).substring(0, index);
            packageName = packageName + "enums";
            String entityClassName = getEnclosingTypeElement(element).getSimpleName().toString();
            String builderClassName = "EnumEntityModel";

            String builderClassFqn = packageName + "." + builderClassName;

            ctx = new GeneratorContext(element, getPackageName(element), packageName, entityClassName, builderClassName, builderClassFqn);

            generateClassCode(ctx, sb);
        }
    }

    private void generateClassCode(GeneratorContext ctx, StringBuilder sb) {
        if (jinTypeBuilder == null) {
            jinTypeBuilder = new JinTypeBuilder(ctx.packageName, EnumJinType.ENUM, ctx.builderClassName);

            JinAnnotationBuilder annotationBuilder1 = jinTypeBuilder.addAnnotation(XmlAccessorType.class);
            annotationBuilder1.addAttribute(new JinFieldBuilder(new JinGenericType("XmlAccessType.FIELD"), ""));

            JinAnnotationBuilder annotationBuilder2 = jinTypeBuilder.addAnnotation(XmlEnum.class);

            JinAnnotationBuilder annotationBuilder3 = jinTypeBuilder.addAnnotation(XmlType.class);
            JinFieldBuilder fieldBuilder1 = annotationBuilder3.addAttribute();
            fieldBuilder1.setName("name")
                    .setDefaultValue("\"XmlEnumObjectType\"");
            JinFieldBuilder fieldBuilder2 = annotationBuilder3.addAttribute();
            fieldBuilder2.setName("namespace")
                    .setDefaultValue("\"http://enum.element.webservice.remote.oryx.com\"");

            jinTypeBuilder.addmodifier(EnumJinModifier.PUBLIC)
                    .addImportPackage(ctx.entityPackageName)
                    .addImportPackage(ctx.packageName.replace("com.oryx.core.service", "com.oryx.remote.webservice.element.model")) //"com.oryx.remote.webservice.element.model")
                    .addImportPackage("com.oryx.remote.webservices.service.personservice");
        }


        JinFieldBuilder jinFieldBuilderRepo = new JinFieldBuilder(null, ctx.entityClassName.toUpperCase());
        jinTypeBuilder.addField(jinFieldBuilderRepo);
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
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
