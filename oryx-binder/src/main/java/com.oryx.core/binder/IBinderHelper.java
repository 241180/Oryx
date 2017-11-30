package com.oryx.core.binder;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smbarki on 02/08/2017.
 */
public interface IBinderHelper {
    final static Logger logger = Logger.getLogger(IBinderHelper.class);
    public static Map<Class<? extends IBoundableKey>, Map<Class<?>, IBoundableObject>> objectMap = new HashMap<>();

    public static void bind(Class<? extends IBoundableKey> keyClassType, Class<?> objectClassType, IBoundableObject object) {
        if (keyClassType != null && objectClassType != null && object != null) {
            Map<Class<?>, IBoundableObject> keyMap = objectMap.get(keyClassType);
            if (keyMap == null) {
                keyMap = new HashMap<>();
                objectMap.put(keyClassType, keyMap);
            }

            keyMap.put(objectClassType, object);
            logger.info("Boundable " + object.getClass().getSimpleName() + " is bound for " + objectClassType.getSimpleName() + " object with " + keyClassType.getSimpleName() + " key.");
        } else {
            logger.error("Null key or Null class type or null Object provided.");
        }
    }

    public static IBoundableObject getObject(Class<? extends IBoundableKey> keyClassType, Class<?> objectClassType) {
        if (keyClassType != null && objectClassType != null) {
            Map<Class<?>, IBoundableObject> keyMap = objectMap.get(keyClassType);
            if (keyMap != null) {
                return (IBoundableObject) keyMap.get(objectClassType);
            }
        } else {
            logger.error("Null key or Null class type provided.");
        }

        return null;
    }
}
