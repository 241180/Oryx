package com.oryx.core.javajin;

import com.oryx.core.javajin.key.JavaJinKeyWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 241180 on 08/02/2017.
 */
public class JinAnnotationBuilder extends AbstractJavaJinBuilder<JinAnnotationBuilder> {
    private Class annotationClass;
    private List<JinFieldBuilder> attributes = new ArrayList<>();

    public JinAnnotationBuilder() {
        super();
    }

    public JinAnnotationBuilder(Class annotationClass) {
        this.annotationClass = annotationClass;
    }

    public JinAnnotationBuilder addAttribute(JinFieldBuilder attribute) {
        this.attributes.add(attribute);
        return this;
    }

    public JinFieldBuilder addAttribute() {
        JinFieldBuilder attribute = new JinFieldBuilder();
        this.attributes.add(attribute);
        return attribute;
    }

    public void save(StringBuffer buffer, List<String> importPackages) {
        buffer.append(JavaJinKeyWord.ANT)
                .append(annotationClass.getSimpleName());

        if (this.attributes != null && this.attributes.size() > 0) {
            buffer.append(JavaJinKeyWord.BOA);

            boolean firsAttribute = true;
            for (JinFieldBuilder attribute : this.attributes) {
                if (!firsAttribute)
                    buffer.append(JavaJinKeyWord.SEP)
                            .append(JavaJinKeyWord.SPACE);

                firsAttribute = false;
                if (attribute.getType() != null && attribute.getType().getGenericType() != null) {
                    if (attribute.getType().getGenericType() instanceof Class) {
                        buffer.append(((Class) attribute.getType().getGenericType()).getSimpleName());
                        importPackages.add(((Class) attribute.getType().getGenericType()).getPackage().getName());
                    } else if (attribute.getType().getGenericType() instanceof String)
                        buffer.append(((String) attribute.getType().getGenericType()));
                } else
                    buffer.append(attribute.getName());

                if (attribute.getDefaultValue() != null) {
                    buffer.append(JavaJinKeyWord.SPACE)
                            .append(JavaJinKeyWord.EQ)
                            .append(JavaJinKeyWord.SPACE)
                            .append(attribute.getDefaultValue());
                }

                buffer.append(JavaJinKeyWord.SPACE);
            }

            buffer.append(JavaJinKeyWord.EOA);
        }

        buffer.append(JavaJinKeyWord.EOL);

        importPackages.add(annotationClass.getPackage().getName());
    }
}
