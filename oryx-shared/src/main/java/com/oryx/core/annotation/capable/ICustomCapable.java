package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.Custom;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface ICustomCapable {
    final static Logger logger = Logger.getLogger(ICustomCapable.class);

    public static String getHtmlFileName(Object current) {
        if (current != null) {
            Custom custom = current.getClass().getAnnotation(Custom.class);
            if (custom != null)
                return custom.html();
            else {
                logger.error("No Custom layout associated for class " + current.getClass().getSimpleName());
                return null;
            }
        }

        return null;
    }
}
