package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.AssoEntity;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface IAssoEntityCapable {
    final static Logger logger = Logger.getLogger(IAssoEntityCapable.class);

    public static Class<?> getClassType(Object current) {
        if (current != null) {
            AssoEntity assoEntity = current.getClass().getAnnotation(AssoEntity.class);
            if (assoEntity != null) {
                return assoEntity.classType();
            } else {
                logger.error("No Entity associated for class " + current.getClass().getSimpleName());
            }
        }

        return null;
    }

    public static Object getInstance(Object current) {
        Class<?> classType = getClassType(current);
        if (classType != null) {
            try {
                return classType.newInstance();
            } catch (InstantiationException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }
}
