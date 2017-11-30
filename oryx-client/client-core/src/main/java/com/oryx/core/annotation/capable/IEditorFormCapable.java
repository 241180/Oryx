package com.oryx.core.annotation.capable;

import com.oryx.core.annotation.decl.AssoEditorForm;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.IEditorLayout;
import com.oryx.core.module.IModule;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface IEditorFormCapable {
    final static Logger logger = Logger.getLogger(IEditorFormCapable.class);

    public static Class<? extends IEditorLayout> getClassType(Object current) {
        if (current != null) {
            AssoEditorForm assoEditorForm = current.getClass().getAnnotation(AssoEditorForm.class);
            if (assoEditorForm != null) {
                return assoEditorForm.classType();
            } else {
                logger.error("No editor form associated for class " + current.getClass().getSimpleName());
            }
        }

        return null;
    }

    public static IEditorLayout getInstance(Object current) {
        Class<?> classType = getClassType(current);
        if (classType != null) {
            try {
                return (IEditorLayout) classType.newInstance();
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

    public static IEditorLayout getInstance(Object current, IDelegate service, IModule module) {
        Class<?> classType = getClassType(current);
        if (classType != null) {
            try {
                return (IEditorLayout) classType.getConstructor(IDelegate.class, IModule.class).newInstance(service, module);
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
