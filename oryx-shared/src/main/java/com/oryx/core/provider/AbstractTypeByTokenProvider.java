package com.oryx.core.provider;

import java.lang.reflect.Field;

/**
 * Created by 241180 on 16/01/2017.
 */
public abstract class AbstractTypeByTokenProvider implements ITypeByTokenProvider {

    public Class<?> getClassType(Target target) {

        try {
            Field field = null;
            Class<?> current = getClass();
            while ((current != null) && (field == null)) { // we don't want to process Object.class
                try {
                    field = current.getDeclaredField(target.getMeaning());
                } catch (NoSuchFieldException e) {
                    //e.printStackTrace();
                    //logger.warn(e.getClass().getSimpleName() + " : [" + target.name() + "]." + e.getMessage());
                }

                if (field != null) {
                    boolean accessibe = field.isAccessible();
                    field.setAccessible(true);
                    Class<?> classType = (Class<?>) field.get(null);
                    field.setAccessible(accessibe);
                    return classType;
                }

                current = current.getSuperclass();
            }
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
            //logger.warn(e.getClass().getSimpleName() + " : [" + target.name() + "]." + e.getMessage());
        }

        return null;
    }
}
