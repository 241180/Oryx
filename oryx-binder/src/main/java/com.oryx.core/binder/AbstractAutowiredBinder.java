package com.oryx.core.binder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * Created by smbarki on 31/03/2017.
 */

public abstract class AbstractAutowiredBinder extends AbstractBinder {
    final static Logger logger = Logger.getLogger(AbstractAutowiredBinder.class);

    @Override
    public void configure() {
        configureAutowiredService(getKeyClassType());
    }

    public abstract Class<? extends IBoundableKey> getKeyClassType();

    public abstract Class<?> getObjectClassType(IBoundableObject boundable);

    public void configureAutowiredService(Class<? extends IBoundableKey> keyClassType) {
        for (Field authowiredField : getClass().getDeclaredFields()) {
            if (authowiredField.getAnnotation(Autowired.class) != null) {
                try {
                    boolean isAccessible = authowiredField.isAccessible();
                    authowiredField.setAccessible(true);
                    IBoundableObject boundable = (IBoundableObject) authowiredField.get(this);
                    if (boundable != null) {
                        IBinderHelper.bind(keyClassType
                                , getObjectClassType(boundable)
                                , boundable
                        );
                    } else {
                        logger.error("bind/reflect object null :" + authowiredField.getName());
                    }
                    authowiredField.setAccessible(isAccessible);
                } catch (IllegalAccessException e) {
                    logger.error("bind/IllegalAccessException: " + e.getCause().getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
