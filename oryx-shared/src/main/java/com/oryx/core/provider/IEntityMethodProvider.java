package com.oryx.core.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 241180 on 31/01/2017.
 */
public interface IEntityMethodProvider {
    static final Map<String, Method> methodMap = new HashMap<>();
    static final String GET_ID = "getId";
    static final String PARSE = "parse";
    static final String UNPARSE = "unparse";

    static Method GET_ID_METHOD(Class clazz) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + GET_ID)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + GET_ID);
        }

        try {
            Method method = clazz.getMethod(GET_ID);
            methodMap.put(clazz.getCanonicalName() + "::" + GET_ID, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method PARSE_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + PARSE)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + PARSE);
        }

        try {
            Method method = clazz.getMethod(PARSE, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + PARSE, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method UNPARSE_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + UNPARSE)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + UNPARSE);
        }

        try {
            Method method = clazz.getMethod(UNPARSE, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + UNPARSE, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
