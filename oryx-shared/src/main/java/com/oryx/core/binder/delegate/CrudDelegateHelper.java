package com.oryx.core.binder.delegate;

import com.oryx.core.binder.IBinderHelper;
import com.oryx.core.delegate.ICrudDelegate;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

/**
 * Created by smbarki on 31/03/2017.
 */
public class CrudDelegateHelper implements IBinderHelper {
    final static Logger logger = Logger.getLogger(CrudDelegateHelper.class);

    public static List findByCriteria(Object entity) throws InvocationTargetException, IllegalAccessException {
        if (entity != null) {
            return ((ICrudDelegate) IDelegateBinder.getByClassType(entity.getClass())).findByCriteria(entity);
        }

        logger.error("find By Criteria : null entity provided");
        return null;
    }

    public static List findAll(Class<?> classType) throws InvocationTargetException, IllegalAccessException {
        if (classType != null) {
            return ((ICrudDelegate) IDelegateBinder.getByClassType(classType)).findAll();
        }

        logger.error("find All: null entity provided");
        return null;
    }

    public static Object create(Object entity) throws Exception {
        if (entity != null) {
            return ((ICrudDelegate) IDelegateBinder.getByClassType(entity.getClass())).create(entity);
        }
        logger.error("Create entity: null entity provided");
        return null;
    }

    public static Object update(Object entity) throws IllegalAccessException {
        if (entity != null) {
            try {
                return ((ICrudDelegate) IDelegateBinder.getByClassType(entity.getClass())).update(entity);
            } catch (InvocationTargetException e) {
                logger.error(e.getCause().getMessage());
                e.printStackTrace();
            }
            return null;
        }
        logger.error("Update entity: null entity provided");
        return null;
    }

    public static Object delete(Class<?> classType, UUID id) throws InvocationTargetException, IllegalAccessException {
        if (classType != null && id != null) {
            return ((ICrudDelegate) IDelegateBinder.getByClassType(classType)).delete(id);
        }
        logger.error("Delete entity: null entity provided");
        return null;
    }
}
