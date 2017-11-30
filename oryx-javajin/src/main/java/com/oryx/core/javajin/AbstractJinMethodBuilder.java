package com.oryx.core.javajin;

import com.oryx.core.javajin.key.JavaJinKeyWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 241180 on 10/02/2017.
 */
public abstract class AbstractJinMethodBuilder<E> extends AbstractJavaJinBuilder<E> {
    protected List<JinFieldBuilder> inputArgs = new ArrayList<>();

    public abstract AbstractJinMethodBuilder<E> addArguemnt(JinFieldBuilder arg);

    public abstract AbstractJinMethodBuilder<E> addArguemnts(List<JinFieldBuilder> args);

    protected void saveInputArgs(StringBuffer buffer, List<String> importPackages) {
        if (inputArgs != null && inputArgs.size() > 0) {
            boolean firstArg = true;
            for (JinFieldBuilder jinFieldBuilder : inputArgs) {
                if (!firstArg)
                    buffer.append(JavaJinKeyWord.SEP)
                            .append(JavaJinKeyWord.SPACE);

                if (jinFieldBuilder.getType().getGenericType() instanceof Class) {
                    buffer.append(((Class) jinFieldBuilder.getType().getGenericType()).getSimpleName())
                            .append(JavaJinKeyWord.SPACE)
                            .append(jinFieldBuilder.getName());

                    importPackages.add(((Class) jinFieldBuilder.getType().getGenericType()).getPackage().getName());
                } else if (jinFieldBuilder.getType().getGenericType() instanceof String) {
                    buffer.append(((String) jinFieldBuilder.getType().getGenericType()))
                            .append(JavaJinKeyWord.SPACE)
                            .append(jinFieldBuilder.getName());
                }
                firstArg = false;
            }
        }
    }
}
