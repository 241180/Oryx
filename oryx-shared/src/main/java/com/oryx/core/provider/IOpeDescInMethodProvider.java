package com.oryx.core.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 241180 on 31/01/2017.
 */
public interface IOpeDescInMethodProvider {
    static final Map<String, Method> methodMap = new HashMap<>();

    static final String SET_MSG = "setMsg";
    static final String GET_MSG = "getMsg";

    static Method SET_RESP_MSG_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + SET_MSG)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + SET_MSG);
        }

        try {
            Method method = clazz.getMethod(SET_MSG, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + SET_MSG, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method GET_RESP_MSG_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + GET_MSG)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + GET_MSG);
        }

        try {
            Method method = clazz.getMethod(GET_MSG, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + GET_MSG, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
