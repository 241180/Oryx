package com.oryx.core.layout.helper;

import org.apache.log4j.Logger;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.List;

/**
 * Created by smbarki on 18/09/2017.
 */
public interface IFormLayoutHelper {
    final static Logger logger = Logger.getLogger(IFormLayoutHelper.class);

    public static boolean isBoundableField(java.lang.reflect.Field field) {
        if (field.getType() == String.class
                || field.getType() == Date.class
                || field.getType() == XMLGregorianCalendar.class
                || field.getType() == Integer.class
                || field.getType() == Double.class
                || field.getType() == Boolean.class
                || field.getType() == List.class
                || (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum())) {
            return true;
        }

        return false;
    }
}
