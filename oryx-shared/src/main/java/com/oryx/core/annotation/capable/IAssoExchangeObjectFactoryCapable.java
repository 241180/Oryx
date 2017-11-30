package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.factory.IFactory;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface IAssoExchangeObjectFactoryCapable {
    final static Logger logger = Logger.getLogger(IAssoExchangeObjectFactoryCapable.class);

    public static Class<? extends IFactory> getClassType(Object current) {
        if (current != null) {
            AssoExchangeObjectFactory assoExchangeObjectFactory = current.getClass().getAnnotation(AssoExchangeObjectFactory.class);
            if (assoExchangeObjectFactory != null) {
                return assoExchangeObjectFactory.classType();
            } else {
                logger.error("No Entity associated for class " + current.getClass().getSimpleName());
            }
        }

        return null;
    }

    public static IFactory getInstance(Object current) {
        Class<? extends IFactory> classType = getClassType(current);
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
