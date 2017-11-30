package com.oryx.core.javajin;

import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.key.JavaJinKeyWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 241180 on 08/02/2017.
 */
public class JinFieldBuilder extends AbstractJavaJinBuilder<JinFieldBuilder> {
    private List<Class> annotations = new ArrayList<>();
    private JinGenericType type;
    private String defaultValue = null;

    public JinFieldBuilder() {
        super();
    }

    public JinFieldBuilder(JinGenericType type, String name) {
        this.type = type;
        this.name = name;
    }

    public JinFieldBuilder(List<EnumJinModifier> modifiers, JinGenericType type, String name) {
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public JinFieldBuilder setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public JinGenericType getType() {
        return type;
    }

    public JinFieldBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public JinFieldBuilder addModifier(EnumJinModifier modifier) {
        modifiers.add(modifier);
        return this;
    }

    public JinFieldBuilder addAnnotation(Class annotation) {
        this.annotations.add(annotation);
        return this;
    }

    private void saveAnnotations(StringBuffer buffer, List<String> importPackages) {
        for (Class annotation : annotations) {
            buffer.append(JavaJinKeyWord.TAB)
                    .append(JavaJinKeyWord.ANT)
                    .append(annotation.getSimpleName())
                    .append(JavaJinKeyWord.EOL);

            importPackages.add(annotation.getPackage().getName());
        }
    }

    public void save(StringBuffer buffer, List<String> importPackages) {
        //ANNOTATIONS
        saveAnnotations(buffer, importPackages);

        if (this.type != null && this.type.getGenericType() != null) {
            if (this.type.getGenericType() instanceof Class) {
                importPackages.add(((Class) this.type.getGenericType()).getPackage().getName());
            } else if (this.type.getGenericType() instanceof String) {
                //importPackages.add((String) this.type.getGenericType());
            }
        }

        buffer.append(JavaJinKeyWord.TAB);

        saveTypeModifiers(buffer);

        if (this.type != null) {
            type.save(buffer, importPackages);
        }

        buffer.append(JavaJinKeyWord.SPACE).append(this.name);

        if (this.defaultValue != null)
            buffer.append(JavaJinKeyWord.SPACE)
                    .append(JavaJinKeyWord.EQ)
                    .append(JavaJinKeyWord.SPACE)
                    .append(this.defaultValue);

        if (this.type == null) {
            buffer.append(JavaJinKeyWord.SEP);
        } else
            buffer.append(JavaJinKeyWord.EOI);

        buffer.append(JavaJinKeyWord.EOL);
    }
}
