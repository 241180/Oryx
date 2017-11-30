package com.oryx.core.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 241180 on 31/01/2017.
 */
public interface ICrudResponseMethodProvider {
    static final Map<String, Method> methodMap = new HashMap<>();

    static final String GET_OBJECT = "getObject";
    static final String SET_RESPONSE = "setResponse";
    static final String GET_RESPONSE = "getResponse";

    static Method SET_RESPONSE_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + SET_RESPONSE)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + SET_RESPONSE);
        }

        try {
            Method method = clazz.getMethod(SET_RESPONSE, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + SET_RESPONSE, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method GET_RESPONSE_METHOD(Class clazz) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + GET_RESPONSE)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + GET_RESPONSE);
        }

        try {
            Method method = clazz.getMethod(GET_RESPONSE);
            methodMap.put(clazz.getCanonicalName() + "::" + GET_RESPONSE, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method GET_OBJECT_METHOD(Class clazz) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + GET_OBJECT)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + GET_OBJECT);
        }

        try {
            Method method = clazz.getMethod(GET_OBJECT);
            methodMap.put(clazz.getCanonicalName() + "::" + GET_OBJECT, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
