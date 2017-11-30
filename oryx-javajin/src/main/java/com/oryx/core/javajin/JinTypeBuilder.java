package com.oryx.core.javajin;

import com.oryx.core.javajin.enums.EnumJinAccessorType;
import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.enums.EnumJinType;
import com.oryx.core.javajin.key.JavaJinKeyWord;
import org.apache.commons.lang.WordUtils;

import java.util.*;

/**
 * Created by 241180 on 08/02/2017.
 */
public class JinTypeBuilder extends AbstractJavaJinBuilder<JinTypeBuilder> {
    private final List<String> importPackages = new ArrayList<>();
    private String packageName;
    private EnumJinType type;
    private List<JinGenericType> extendsTypes = new ArrayList<>();
    private List<JinGenericType> implementsTypes = new ArrayList<>();
    private List<JinAnnotationBuilder> annotations = new ArrayList<>();
    private List<JinMethodBuilder> methods = new ArrayList<>();
    private List<JinConstructorBuilder> constructors = new ArrayList<>();
    private List<JinFieldBuilder> fields = new ArrayList<>();
    private List<JinTypeBuilder> internalTypes = new ArrayList<>();

    //Constructors
    public JinTypeBuilder(String packageName, EnumJinType type, String name) {
        this.packageName = packageName;
        this.type = type;
        this.name = name;
    }

    public JinTypeBuilder(String packageName, EnumJinType type, String name, List<JinGenericType> extendsTypes, List<JinGenericType> implementsTypes) {
        this.packageName = packageName;
        this.type = type;
        this.name = name;
        this.extendsTypes = extendsTypes;
        this.implementsTypes = implementsTypes;
    }

    public JinTypeBuilder(List<EnumJinModifier> modifiers, String packageName, EnumJinType type, String name, List<JinGenericType> extendsTypes, List<JinGenericType> implementsTypes) {
        this.modifiers = modifiers;
        this.packageName = packageName;
        this.type = type;
        this.name = name;
        this.extendsTypes = extendsTypes;
        this.implementsTypes = implementsTypes;
    }

    public JinTypeBuilder setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public JinTypeBuilder setType(EnumJinType type) {
        this.type = type;
        return this;
    }

    public JinGenericType addExtendsTypes(Class extendsType) {
        JinGenericType jinGenericType = new JinGenericType(extendsType);
        this.extendsTypes.add(jinGenericType);
        return jinGenericType;
    }

    public JinGenericType addExtendsTypes(String extendsType) {
        JinGenericType jinGenericType = new JinGenericType(extendsType);
        this.extendsTypes.add(jinGenericType);
        return jinGenericType;
    }

    public JinGenericType addImplementsType(Class implementsType) {
        JinGenericType jinGenericType = new JinGenericType(implementsType);
        this.implementsTypes.add(jinGenericType);
        return jinGenericType;
    }

    public JinGenericType addImplementsType(String implementsType) {
        JinGenericType jinGenericType = new JinGenericType(implementsType);
        this.implementsTypes.add(jinGenericType);
        return jinGenericType;
    }


    public JinTypeBuilder addmodifier(EnumJinModifier jinModifier) {
        this.modifiers.add(jinModifier);
        return this;
    }

    public JinTypeBuilder addImportPackage(String packageName) {
        this.importPackages.add(packageName);
        return this;
    }

    public JinTypeBuilder addAnnotation(JinAnnotationBuilder annotation) {
        this.annotations.add(annotation);
        return this;
    }

    public JinAnnotationBuilder addAnnotation() {
        JinAnnotationBuilder annotation = new JinAnnotationBuilder();
        this.annotations.add(annotation);
        return annotation;
    }

    public JinAnnotationBuilder addAnnotation(Class annotationClass) {
        JinAnnotationBuilder annotation = new JinAnnotationBuilder(annotationClass);
        this.annotations.add(annotation);
        return annotation;
    }

    public JinTypeBuilder addMethod(JinMethodBuilder method) {
        this.methods.add(method);
        return this;
    }

    public JinTypeBuilder addConstructor(JinConstructorBuilder constructor) {
        this.constructors.add(constructor);
        return this;
    }

    public JinTypeBuilder addField(JinFieldBuilder field) {
        this.fields.add(field);
        return this;
    }

    public JinTypeBuilder addInternalType(JinTypeBuilder internalType) {
        this.internalTypes.add(internalType);
        return this;
    }


    public JinTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public JinTypeBuilder addModifier(EnumJinModifier modifier) {
        modifiers.add(modifier);
        return this;
    }

    private StringBuffer genGetterJavaCode(JinFieldBuilder jinFieldBuilder) {
        return new StringBuffer()
                .append(JavaJinKeyWord.TAB)
                .append(JavaJinKeyWord.TAB)
                .append(genReturnInstruction(jinFieldBuilder))
                .append(JavaJinKeyWord.EOL);
    }

    private StringBuffer genSetterJavaCode(JinFieldBuilder jinFieldBuilder) {
        return new StringBuffer()
                .append(JavaJinKeyWord.TAB)
                .append(JavaJinKeyWord.TAB)
                .append(genAffectationInstruction(jinFieldBuilder))
                .append(JavaJinKeyWord.EOL);
    }

    private void addGetAccessor(JinFieldBuilder jinFieldBuilder, EnumJinAccessorType jinAccessorType) {
        String accessorName = JavaJinKeyWord.GET + WordUtils.capitalize(jinFieldBuilder.getName());
        addMethod(Arrays.asList(EnumJinModifier.PUBLIC), jinFieldBuilder.getType(), accessorName, null)
                .getCode().append(genGetterJavaCode(jinFieldBuilder));
    }

    private void addSetAccessor(JinFieldBuilder jinFieldBuilder, EnumJinAccessorType jinAccessorType) {
        String accessorName = JavaJinKeyWord.SET + WordUtils.capitalize(jinFieldBuilder.getName());
        addMethod(Arrays.asList(EnumJinModifier.PUBLIC), new JinGenericType(void.class), accessorName, Arrays.asList(jinFieldBuilder))
                .getCode().append(genSetterJavaCode(jinFieldBuilder));

    }

    private void addAccessors(JinFieldBuilder jinFieldBuilder, EnumJinAccessorType jinAccessorType) {
        String accessorName = null;
        switch (jinAccessorType) {
            case SET:
                addSetAccessor(jinFieldBuilder, jinAccessorType);
                break;
            case GET:
                addGetAccessor(jinFieldBuilder, jinAccessorType);
                break;
            case SETGET:
                addSetAccessor(jinFieldBuilder, jinAccessorType);
                addGetAccessor(jinFieldBuilder, jinAccessorType);
                break;
        }
    }

    public JinFieldBuilder addField(List<EnumJinModifier> modifiers, JinGenericType type, String name, EnumJinAccessorType accessors) {
        if (modifiers == null) {
            modifiers = new ArrayList<>();
        }

        if (modifiers.size() == 0) {
            modifiers.add(EnumJinModifier.PUBLIC);
        }

        JinFieldBuilder jinFieldBuilder = new JinFieldBuilder(modifiers, type, name);
        this.fields.add(jinFieldBuilder);
        addAccessors(jinFieldBuilder, accessors);

        return jinFieldBuilder;
    }

    public JinConstructorBuilder addConstructor() {
        JinConstructorBuilder jinConstructorBuilder = new JinConstructorBuilder(this);
        this.constructors.add(jinConstructorBuilder);
        return jinConstructorBuilder;
    }

    public JinMethodBuilder addMethod() {
        JinMethodBuilder jinMethodBuilder = new JinMethodBuilder();
        this.methods.add(jinMethodBuilder);
        return jinMethodBuilder;
    }

    public JinMethodBuilder addMethod(List<EnumJinModifier> modifiers, JinGenericType returnType, String name, List<JinFieldBuilder> inputArgs) {
        if (modifiers == null) {
            modifiers = new ArrayList<>();
        }

        if (modifiers.size() == 0) {
            modifiers.add(EnumJinModifier.PUBLIC);
        }

        JinMethodBuilder jinMethodBuilder = new JinMethodBuilder(modifiers, returnType, name, inputArgs);
        this.methods.add(jinMethodBuilder);

        return jinMethodBuilder;
    }

    public void save(StringBuffer buffer) {
        StringBuffer internalBuffer = new StringBuffer();
        //ANNOTATIONS
        saveAnnotations(internalBuffer);

        //HEADER
        saveHeader(internalBuffer);

        //EXTENDS
        saveExtends(internalBuffer);

        //IMPLEMENTS
        saveImplements(internalBuffer);

        beginOfBlock(internalBuffer);

        //FIELDS
        saveFields(internalBuffer);

        //CONSTRUCTORS
        saveConstructors(internalBuffer);

        //METHODS
        saveMethods(internalBuffer);

        endOfBlock(internalBuffer);

        //PACKAGE NAME
        savePackgeName(buffer);

        //IMPORTS
        saveImports(buffer);

        buffer.append(JavaJinKeyWord.EOL)
                .append(internalBuffer);
    }

    private void saveKeyType(StringBuffer buffer) {
        switch (this.type) {
            case CLASS:
                buffer.append(JavaJinKeyWord.CLASS);
                break;
            case INTERFACE:
                buffer.append(JavaJinKeyWord.INTERFACE);
                break;
            case ENUM:
                buffer.append(JavaJinKeyWord.ENUM);
                break;
        }
    }

    private void saveTypeName(StringBuffer buffer) {
        buffer.append(JavaJinKeyWord.SPACE)
                .append(this.name)
                .append(JavaJinKeyWord.SPACE);
    }

    private void saveHeader(StringBuffer buffer) {
        saveTypeModifiers(buffer);
        saveKeyType(buffer);
        saveTypeName(buffer);
    }


    private void saveAnnotations(StringBuffer buffer) {
        for (JinAnnotationBuilder annotation : annotations) {
            annotation.save(buffer, importPackages);
        }
    }

    private void saveExtends(StringBuffer buffer) {
        if (extendsTypes.size() > 0) {
            buffer.append(JavaJinKeyWord.EXTENDS)
                    .append(JavaJinKeyWord.SPACE);

            int count = 0;
            for (JinGenericType extendsType : extendsTypes) {
                if (count > 0)
                    buffer.append(JavaJinKeyWord.SEP)
                            .append(JavaJinKeyWord.SPACE);

                extendsType.save(buffer, importPackages);
                count++;
            }
        }
    }

    private void saveImplements(StringBuffer buffer) {
        if (implementsTypes.size() > 0) {
            buffer.append(JavaJinKeyWord.IMPLEMENTS)
                    .append(JavaJinKeyWord.SPACE);

            int count = 0;
            for (JinGenericType implementsType : implementsTypes) {
                if (count > 0)
                    buffer.append(JavaJinKeyWord.SEP)
                            .append(JavaJinKeyWord.SPACE);

                implementsType.save(buffer, importPackages);
                count++;
            }
        }
    }

    private void savePackgeName(StringBuffer buffer) {
        buffer.append(JavaJinKeyWord.PACKAGE)
                .append(JavaJinKeyWord.SPACE)
                .append(packageName)
                .append(JavaJinKeyWord.EOI)
                .append(JavaJinKeyWord.EOL)
                .append(JavaJinKeyWord.EOL);
    }

    private void saveConstructors(StringBuffer buffer) {
        for (JinConstructorBuilder jinConstructorBuilder : constructors) {
            jinConstructorBuilder.save(buffer, importPackages);
        }
    }

    private void saveMethods(StringBuffer buffer) {
        for (JinMethodBuilder methodBuilder : methods) {
            if (this.type != EnumJinType.CLASS)
                methodBuilder.save(buffer, importPackages, true);
            else
                methodBuilder.save(buffer, importPackages, false);
        }
    }

    private void saveFields(StringBuffer buffer) {
        for (JinFieldBuilder jinFieldBuilder : fields) {
            jinFieldBuilder.save(buffer, importPackages);
        }

        if (this.type == EnumJinType.ENUM)
            buffer.append(JavaJinKeyWord.TAB)
                    .append(JavaJinKeyWord.UNKNOWN);
    }

    private void saveImports(StringBuffer buffer) {
        Set<String> nodeSet = new HashSet<>(importPackages);
        importPackages.clear();
        importPackages.addAll(nodeSet);

        for (String packageName : importPackages) {
            buffer.append(JavaJinKeyWord.IMPORT)
                    .append(JavaJinKeyWord.SPACE)
                    .append(packageName)
                    .append(".*")
                    .append(JavaJinKeyWord.EOI)
                    .append(JavaJinKeyWord.EOL);
        }
    }
}
