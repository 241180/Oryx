package com.oryx.core.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 241180 on 31/01/2017.
 */
public interface IListMethodProvider {
    static final Map<String, Method> methodMap = new HashMap<>();

    static final String ADD_ALL = "addAll";
    static final String CLEAR = "clear";

    static Method ADD_ALL_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + ADD_ALL)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + ADD_ALL);
        }

        try {
            Method method = clazz.getMethod(ADD_ALL, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + ADD_ALL, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method REMOVE_ALL_METHOD(Class clazz) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + CLEAR)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + CLEAR);
        }

        try {
            Method method = clazz.getMethod(CLEAR);
            methodMap.put(clazz.getCanonicalName() + "::" + CLEAR, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
