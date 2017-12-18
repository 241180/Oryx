package com.oryx.core.mvc.view;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.annotation.capable.ICustomCapable;
import com.oryx.core.bundle.IBundle;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Layout;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewDescriptor<E> implements IViewDescriptor<E> {
    private IViewController<E> viewController;
    private Layout layout;

    private Class<? extends IBundle> constantBundle;
    private String customLayout;

    @Override
    public void setController(IViewController<E> controller) {
        this.viewController = controller;
    }

    @Override
    public IViewController<E> getViewController() {
        return viewController;
    }

    @Override
    public void setViewController(IViewController<E> viewController) {
        this.viewController = viewController;
    }

    @Override
    public Layout getLayout() {
        if(layout != null){
            return layout;
        } else {
            if(getCustomLayout() != null){
                setLayout(new CustomLayout());
            }
        }
    }

    @Override
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Class<? extends IBundle> getConstantBundle() {
        if (this.constantBundle != null) {
            this.constantBundle = IBundleCapable.getBundleInterface(this);
        }

        return this.constantBundle;
    }

    public String getCustomLayout() {
        if (this.customLayout != null) {
            this.customLayout = ICustomCapable.getHtmlFileName(this);
        }

        return this.customLayout;
    }
}
