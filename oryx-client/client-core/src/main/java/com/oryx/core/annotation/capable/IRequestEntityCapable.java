package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface IRequestEntityCapable {
    final static Logger logger = Logger.getLogger(IRequestEntityCapable.class);

    public static XmlEnumObjectType getValue(Object current) {
        if (current != null) {
            AssoEntityEnum moduleAnnotation = current.getClass().getAnnotation(AssoEntityEnum.class);
            if (moduleAnnotation != null) {
                return moduleAnnotation.value();
            } else {
                logger.error("No module associated for class " + current.getClass().getSimpleName());
            }
        }

        return null;
    }
}
