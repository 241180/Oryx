package com.oryx.core.module;

import com.oryx.core.gui.ILayout;

/**
 * Created by SAMI on 25/03/2017.
 */
public interface ILayoutModule extends IModule {
    public void bindFormLayout(Class<?> entityClass, Class<? extends ILayout> layoutClass);

    public ILayout getLayout(Class<?> entityClass);

    public ILayout getLayoutForSelection(Class<?> entityClass);

    public ILayout getLayoutByDescription(String description);
}