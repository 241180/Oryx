package com.oryx.core.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 241180 on 31/01/2017.
 */
public interface IEntityRepositoryMethodProvider {
    static final Map<String, Method> methodMap = new HashMap<>();

    static final String SAVE = "save";
    static final String DELETE = "delete";

    static Method SAVE_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + SAVE)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + SAVE);
        }

        try {
            Method method = clazz.getMethod(SAVE, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + SAVE, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method DELETE_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + DELETE)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + DELETE);
        }

        try {
            Method method = clazz.getMethod(DELETE, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + DELETE, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
