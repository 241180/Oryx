package com.oryx.core.module;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.gui.ILayout;
import com.oryx.core.gui.ILayoutKey;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by SAMI on 13/03/2017.
 */
public abstract class AbstractLayoutModule extends AbstractModule implements ILayoutModule {
    final static Logger logger = Logger.getLogger(AbstractLayoutModule.class);

    @Override
    public void bindFormLayout(Class<?> entityClass, Class<? extends ILayout> layoutClass) {
        if (this.getApplicationModule() == null) {
            this.setApplicationModule(this);
        }

        try {
            ILayout layout = layoutClass.getDeclaredConstructor(IModule.class).newInstance(getApplicationModule());
            bind(ILayoutKey.class, entityClass, layout);

            String description = BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), entityClass.getSimpleName());
            register(ILayoutKey.class, description, entityClass);

            layout = layoutClass.getDeclaredConstructor(IModule.class).newInstance(getApplicationModule());
            bind(ILayoutForSelectionKey.class, entityClass, layout);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ILayout getLayout(Class<?> entityClass) {
        return (ILayout) getBoundObject(ILayoutKey.class, entityClass);
    }

    @Override
    public ILayout getLayoutForSelection(Class<?> entityClass) {
        return (ILayout) getBoundObject(ILayoutForSelectionKey.class, entityClass);
    }

    @Override
    public ILayout getLayoutByDescription(String description) {
        if (description != null && getBoundObjectDescriptionMap().get(ILayout.class) != null) {
            Class<?> entityClass = getBoundObjectDescriptionMap().get(ILayout.class).get(description);
            return entityClass != null ? getLayout(entityClass) : null;
        }

        return null;
    }
}