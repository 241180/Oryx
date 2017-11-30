package com.oryx.core.option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 241180 on 07/03/2017.
 */
public interface IEnumUtils {
    public static final Map<String, List> options = new HashMap<>();

    public static List asOptionList(Class<?> enumClass) {
        List values = null;
        if (IEnumUtils.options.containsKey(enumClass.getCanonicalName())) {
            values = IEnumUtils.options.get(enumClass.getCanonicalName());
        } else {
            values = new ArrayList();
            Object[] objects = enumClass.getEnumConstants();
            for (Object obj : objects) {
                values.add(obj);
            }

            IEnumUtils.options.put(enumClass.getCanonicalName(), values);
        }
        return values;
    }
}
