package com.oryx.core.factory;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by 241180 on 10/01/2017.
 */
public abstract class AbstractFactory implements IFactory {
    public abstract Object create(Class<?> clazz);

    @Override
    public Object create(Class<?> clazz, Object object) throws IllegalAccessException, InvocationTargetException {
        Object result = this.create(clazz);
        BeanUtils.copyProperties(result, object);
        return result;
    }
}
