package com.oryx.core.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 241180 on 31/01/2017.
 */
public interface IServiceMethodProvider {
    static final Map<String, Method> methodMap = new HashMap<>();

    static final String CRUD_OPERATION = "crud";
    static final String VIEW_OPERATION = "view";

    static Method CRUD_OPERATION_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + CRUD_OPERATION)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + CRUD_OPERATION);
        }

        try {
            Method method = clazz.getMethod(CRUD_OPERATION, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + CRUD_OPERATION, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    static Method VIEW_OPERATION_METHOD(Class clazz, Class clazzParam) {
        if (methodMap.containsKey(clazz.getCanonicalName() + "::" + VIEW_OPERATION)) {
            return methodMap.get(clazz.getCanonicalName() + "::" + VIEW_OPERATION);
        }

        try {
            Method method = clazz.getMethod(VIEW_OPERATION, clazzParam);
            methodMap.put(clazz.getCanonicalName() + "::" + VIEW_OPERATION, method);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
