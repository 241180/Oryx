package com.oryx.core.javajin;

import com.oryx.core.javajin.key.JavaJinKeyWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 241180 on 10/02/2017.
 */
public class JinGenericType {
    private Object genericType;
    private List<Object> innerTypes = new ArrayList<>();

    public JinGenericType(Class genericType) {
        this.genericType = genericType;
    }

    public JinGenericType(String genericType) {
        this.genericType = genericType;
    }

    public Object getGenericType() {
        return genericType;
    }

    public void setGenericType(Class genericType) {
        this.genericType = genericType;
    }

    public JinGenericType addInnerTypes(Class innerType) {
        this.innerTypes.add(innerType);
        return this;
    }

    public JinGenericType addInnerTypes(String innerType) {
        this.innerTypes.add(innerType);
        return this;
    }

    public void save(StringBuffer buffer, List<String> importPackages) {
        if (genericType instanceof Class) {
            buffer.append(((Class) genericType).getSimpleName());
            importPackages.add(((Class) genericType).getPackage().getName());
        } else if (genericType instanceof String) {
            buffer.append(genericType);
        }

        if (innerTypes != null && innerTypes.size() > 0) {
            buffer.append(JavaJinKeyWord.INF);

            int count = 0;
            for (Object innerType : innerTypes) {
                if (count > 0)
                    buffer.append(JavaJinKeyWord.SEP)
                            .append(JavaJinKeyWord.SPACE);

                if (innerType instanceof Class) {
                    buffer.append(((Class) innerType).getSimpleName());
                    importPackages.add(((Class) innerType).getPackage().getName());
                } else if (innerType instanceof String) {
                    buffer.append(((String) innerType));
                }

                count++;
            }

            buffer.append(JavaJinKeyWord.SUP)
                    .append(JavaJinKeyWord.SPACE);
        }
    }
}
