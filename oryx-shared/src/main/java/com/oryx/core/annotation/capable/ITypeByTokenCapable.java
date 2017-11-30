package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.provider.ITypeByTokenProvider;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface ITypeByTokenCapable {
    final static Logger logger = Logger.getLogger(ITypeByTokenCapable.class);

    public static Class<? extends ITypeByTokenProvider> getClassType(Object current) {
        if (current != null) {
            AssoTypeByTokenProvider typeByTokenProvider = current.getClass().getAnnotation(AssoTypeByTokenProvider.class);
            if (typeByTokenProvider != null) {
                return typeByTokenProvider.classType();
            } else {
                logger.error("No Type By Token Provider associated for class " + current.getClass().getSimpleName());
            }
        }

        return null;
    }

    public static ITypeByTokenProvider getInstance(Object current) {
        Class<? extends ITypeByTokenProvider> classType = getClassType(current);
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
