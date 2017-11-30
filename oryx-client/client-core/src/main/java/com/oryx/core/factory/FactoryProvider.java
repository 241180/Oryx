package com.oryx.core.factory;

import com.oryx.core.provider.IProvider;

/**
 * Created by smbarki on 01/08/2017.
 */
public interface FactoryProvider extends IProvider {
    public static IFactory entityFactory = new EntityFactory();

    public static Object create(Class<?> clazz) {
        return entityFactory.create(clazz);
    }
}
