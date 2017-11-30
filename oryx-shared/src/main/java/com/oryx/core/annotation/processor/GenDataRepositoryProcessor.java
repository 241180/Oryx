package com.oryx.core.annotation.processor;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.javajin.JinFieldBuilder;
import com.oryx.core.javajin.JinGenericType;
import com.oryx.core.javajin.JinMethodBuilder;
import com.oryx.core.javajin.JinTypeBuilder;
import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.enums.EnumJinType;
import com.oryx.core.repository.IEntityRepository;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

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

@SupportedAnnotationTypes(GenDataRepositoryProcessor.AnnotationFqn)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenDataRepositoryProcessor extends AbstractProcessor {
    public final static String AnnotationFqn = "com.oryx.core.annotation.decl.GenDataRepository";
    final static String FIND_BY = "findBy";
    final static Logger logger = Logger.getLogger(GenDataRepositoryProcessor.class);
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
        for (Element e : roundEnv.getElementsAnnotatedWith(GenDataRepository.class)) {
            if (e.getKind() != ElementKind.CLASS)
                continue;
            processTypeElement((TypeElement) e);
        }

        roundEnv.errorRaised();

        return true;
    }

    private void processTypeElement(TypeElement element) {
        String packageName = getPackageName(element).replace("model", "repository");
        String entityClassName = getEnclosingTypeElement(element).getSimpleName().toString();
        String builderClassName = getEnclosingTypeElement(element).getSimpleName().toString() + "Repository";

        String builderClassFqn = packageName + "." + builderClassName;

        GeneratorContext ctx = new GeneratorContext(element, getPackageName(element), packageName, entityClassName, builderClassName, builderClassFqn);
        StringBuilder sb = new StringBuilder();
        generateClassCode(ctx, sb);
        saveClass(ctx, sb);
    }

    private void generateClassCode(GeneratorContext ctx, StringBuilder sb) {
        JinTypeBuilder jinTypeBuilder = new JinTypeBuilder(ctx.packageName, EnumJinType.INTERFACE, ctx.builderClassName)
                .addmodifier(EnumJinModifier.PUBLIC)
                .addImportPackage(ctx.entityPackageName);

        Class superType = CrudRepository.class;

        GenDataRepository genDataRepositoryBuilderAnnotation = ctx.element.getAnnotation(GenDataRepository.class);
        String superTypeStr = genDataRepositoryBuilderAnnotation.extendType();
        logger.info("Annotation extendType : " + ctx.entityClassName + " - " + superTypeStr);

        try {
            superType = Class.forName(superTypeStr);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            logger.warn(e.getClass().getSimpleName() + " : [" + ctx.entityClassName + "]." + e.getMessage());
        }

        JinGenericType extendsType = jinTypeBuilder.addExtendsTypes(superType);
        extendsType.addInnerTypes(ctx.entityClassName)
                .addInnerTypes(Integer.class);

        extendsType = jinTypeBuilder.addExtendsTypes(IEntityRepository.class);
        extendsType.addInnerTypes(ctx.entityClassName);

        BasicConfigurator.configure();

        for (Element element : ctx.element.getEnclosedElements()) {

            if (element.getKind() == ElementKind.FIELD) {
                try {
                    JinMethodBuilder jinMethodBuilder = null;
                    if (element.asType().toString().equals("java.lang.String")) {
                        jinMethodBuilder = jinTypeBuilder.addMethod();

                        jinMethodBuilder.addModifier(EnumJinModifier.PUBLIC)
                                .setReturnType(new JinGenericType(Page.class)
                                        .addInnerTypes(ctx.entityClassName))
                                .setName(FIND_BY + WordUtils.capitalize(element.getSimpleName().toString()) + "Like")
                                .addArguemnt(new JinFieldBuilder(new JinGenericType(Pageable.class), "pageable"))
                                .addArguemnt(new JinFieldBuilder(new JinGenericType(Class.forName(element.asType().toString())), element.getSimpleName().toString()));
                    }

                    jinMethodBuilder = jinTypeBuilder.addMethod();
                    jinMethodBuilder.addModifier(EnumJinModifier.PUBLIC)
                            .setReturnType(new JinGenericType(Page.class)
                                    .addInnerTypes(ctx.entityClassName))
                            .setName(FIND_BY + WordUtils.capitalize(element.getSimpleName().toString()))
                            .addArguemnt(new JinFieldBuilder(new JinGenericType(Pageable.class), "pageable"))
                            .addArguemnt(new JinFieldBuilder(new JinGenericType(Class.forName(element.asType().toString())), element.getSimpleName().toString()));

                } catch (ClassNotFoundException e) {
                    //e.printStackTrace();
                    logger.warn(e.getClass().getSimpleName() + " : [" + ctx.entityClassName + "]." + e.getMessage());
                }
            }

        }

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
