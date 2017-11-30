package com.oryx.core.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by 241180 on 10/01/2017.
 */
public interface IFactory {
    public Object create(Class<?> clazz);

    public Object create(Class<?> clazz, Object object) throws IllegalAccessException, InvocationTargetException;
}
