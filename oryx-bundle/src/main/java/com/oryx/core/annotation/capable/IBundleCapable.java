package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.IBundle;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface IBundleCapable {
    final static Logger logger = Logger.getLogger(IBundleCapable.class);

    public static Class<? extends IBundle> getBundleInterface(Object current) {
        if (current != null) {
            Bundle bundleAnnotation = current.getClass().getAnnotation(Bundle.class);
            if (bundleAnnotation != null) {
                return bundleAnnotation.classType();
            } else {
                logger.error("No bundle associated for class type " + current.getClass().getSimpleName());
            }
        }

        return null;
    }
}
