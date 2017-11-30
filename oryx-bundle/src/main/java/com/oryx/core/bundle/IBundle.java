package com.oryx.core.bundle;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.annotation.decl.FieldStyle;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SAMI on 24/02/2017.
 */
public interface IBundle {
    final static Logger logger = Logger.getLogger(IBundle.class);
    final static String FORM_TITLE = "FORM_TITLE";
    final static int MAX_TEXT_LENGTH = 128;
    public static Map<String, String> defaultStringValueMap = new HashMap<>();
    public static Map<String, Boolean> readOnlyMap = new HashMap<>();
    public static Map<String, Boolean> mandatoryMap = new HashMap<>();
    public static Map<String, Integer> textLengthMap = new HashMap<>();

    public static String getDefaultStringValue(Class<? extends IBundle> bundle, String stringName) {
        if (defaultStringValueMap.containsKey(bundle.getSimpleName() + ":" + stringName)) {
            return defaultStringValueMap.get(bundle.getSimpleName() + ":" + stringName);
        }


        if (FORM_TITLE.equals(stringName)) {
            DefaultStringValue defaultStringValue = bundle.getAnnotation(DefaultStringValue.class);
            if (defaultStringValue != null) {
                defaultStringValueMap.put(bundle.getSimpleName() + ":" + stringName, defaultStringValue.value());
                return defaultStringValue.value();
            } else {
                logger.error(bundle.getSimpleName() + ": Group @DefaultStringValue annotations is missing for bundle");
            }
        }

        try {
            Method stringMethod = bundle.getMethod(stringName);
            if (stringMethod != null) {
                DefaultStringValue defaultStringValue = stringMethod.getAnnotation(DefaultStringValue.class);
                if (defaultStringValue != null) {
                    defaultStringValueMap.put(bundle.getSimpleName() + ":" + stringName, defaultStringValue.value());
                    return defaultStringValue.value();
                } else {
                    logger.error(bundle.getSimpleName() + ": @DefaultStringValue annotations is missing for \"" + stringName + "\"");
                }
            }
        } catch (NoSuchMethodException e) {
            logger.warn(bundle.getSimpleName() + ": no declared bundle method for \"" + stringName + "\" text");
            logger.info("\n\t@DefaultStringValue(\"" + stringName + "\") \n\tpublic String " + stringName + "();");
        }

        return stringName;
    }

    public static Boolean isReadOnly(Class<? extends IBundle> bundle, String stringName) {
        if (readOnlyMap.containsKey(bundle.getSimpleName() + ":" + stringName)) {
            return readOnlyMap.get(bundle.getSimpleName() + ":" + stringName);
        }

        try {
            Method stringMethod = bundle.getMethod(stringName);
            if (stringMethod != null) {
                FieldStyle fieldStyle = stringMethod.getAnnotation(FieldStyle.class);
                if (fieldStyle != null) {
                    readOnlyMap.put(bundle.getSimpleName() + ":" + stringName, fieldStyle.readOnly());
                    return true;
                } else {
                    readOnlyMap.put(bundle.getSimpleName() + ":" + stringName, false);
                    return false;
                }
            }
        } catch (NoSuchMethodException e) {
            logger.warn(bundle.getSimpleName() + ": no declared bundle method for \"" + stringName + "\" text");
            logger.info("\n\t@DefaultStringValue(\"" + stringName + "\") \n\tpublic String " + stringName + "();");
        }

        return false;
    }

    public static Boolean isMandatory(Class<? extends IBundle> bundle, String stringName) {
        if (mandatoryMap.containsKey(bundle.getSimpleName() + ":" + stringName)) {
            return mandatoryMap.get(bundle.getSimpleName() + ":" + stringName);
        }

        try {
            Method stringMethod = bundle.getMethod(stringName);
            if (stringMethod != null) {
                FieldStyle fieldStyle = stringMethod.getAnnotation(FieldStyle.class);
                if (fieldStyle != null) {
                    mandatoryMap.put(bundle.getSimpleName() + ":" + stringName, fieldStyle.mandatory());
                    return true;
                } else {
                    mandatoryMap.put(bundle.getSimpleName() + ":" + stringName, false);
                    return false;
                }
            }
        } catch (NoSuchMethodException e) {
            logger.warn(bundle.getSimpleName() + ": no declared bundle method for \"" + stringName + "\" text");
            logger.info("\n\t@DefaultStringValue(\"" + stringName + "\") \n\tpublic String " + stringName + "();");
        }

        return false;
    }

    public static Integer getLength(Class<? extends IBundle> bundle, String stringName) {
        if (textLengthMap.containsKey(bundle.getSimpleName() + ":" + stringName)) {
            return textLengthMap.get(bundle.getSimpleName() + ":" + stringName);
        }

        try {
            Method stringMethod = bundle.getMethod(stringName);
            if (stringMethod != null) {
                FieldStyle fieldStyle = stringMethod.getAnnotation(FieldStyle.class);
                if (fieldStyle != null) {
                    textLengthMap.put(bundle.getSimpleName() + ":" + stringName, fieldStyle.textLength());
                    return fieldStyle.textLength();
                } else {
                    textLengthMap.put(bundle.getSimpleName() + ":" + stringName, MAX_TEXT_LENGTH);
                    return MAX_TEXT_LENGTH;
                }
            }
        } catch (NoSuchMethodException e) {
            logger.warn(bundle.getSimpleName() + ": no declared bundle method for \"" + stringName + "\" text");
            logger.info("\n\t@DefaultStringValue(\"" + stringName + "\") \n\tpublic String " + stringName + "();");
        }

        return 128;
    }
}
