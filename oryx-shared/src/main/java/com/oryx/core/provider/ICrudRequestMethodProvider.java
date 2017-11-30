package com.oryx.core.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 241180 on 31/01/2017.
 */
public interface ICrudRequestMethodProvider {
    static final Map<String, Method> methodMap = new HashMap<>();

    static final String GET_OBJECT = "getObject";
    static final String SET_REQUEST = "setRequest";
    static final String GET_REQUEST = "getRequest";
    static final String SET_AUTH = "setAuth";
    static final String GET_AUTH = "getAuth";

    static Method SET_REQUEST_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + SET_REQUEST)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + SET_REQUEST);
        }

        try {
            Method method = clazz.getMethod(SET_REQUEST, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + SET_REQUEST, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method GET_REQUEST_METHOD(Class clazz) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + GET_REQUEST)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + GET_REQUEST);
        }

        try {
            Method method = clazz.getMethod(GET_REQUEST);
            methodMap.put(clazz.getCanonicalName() + "::" + GET_REQUEST, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method SET_AUTH_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + SET_AUTH)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + SET_AUTH);
        }

        try {
            Method method = clazz.getMethod(SET_AUTH, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + SET_AUTH, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method GET_AUTH_METHOD(Class clazz) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + GET_AUTH)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + GET_AUTH);
        }

        try {
            Method method = clazz.getMethod(GET_AUTH);
            methodMap.put(clazz.getCanonicalName() + "::" + GET_AUTH, method);
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
