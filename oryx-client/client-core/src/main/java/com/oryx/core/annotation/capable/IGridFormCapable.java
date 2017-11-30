package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.component.IBeanGridView;
import com.oryx.core.layout.grid.IGridLayout;
import com.oryx.core.module.IModule;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface IGridFormCapable {
    final static Logger logger = Logger.getLogger(IGridFormCapable.class);

    public static Class<? extends IGridLayout> getClassType(Object current) {
        if (current != null) {
            AssoGridForm assoGridForm = current.getClass().getAnnotation(AssoGridForm.class);
            if (assoGridForm != null) {
                return assoGridForm.classType();
            } else {
                logger.error("No grid form associated for class " + current.getClass().getSimpleName());
            }
        }

        return null;
    }

    public static IBeanGridView getInstance(Object current) {
        Class<?> classType = getClassType(current);
        if (classType != null) {
            try {
                return (IBeanGridView) classType.newInstance();
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

    public static IGridLayout getInstance(Object current, IDelegate service, IModule module) {
        Class<?> classType = getClassType(current);
        if (classType != null) {
            try {
                return (IGridLayout) classType.getConstructor(IDelegate.class, IModule.class).newInstance(service, module);
            } catch (InstantiationException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
