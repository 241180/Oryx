package com.oryx.core.mvc.view;

import com.oryx.core.annotation.capable.ICustomCapable;
import com.oryx.core.annotation.decl.Custom;
import com.oryx.core.bundle.IBundle;
import com.vaadin.ui.Layout;

/**
 * Created by smbarki on 06/12/2017.
 */
public interface IViewController<E> {
    public Class<? extends IBundle> getConstantBundle();
    public String getCustomLayout();
    public IViewDescriptor<E> getViewDescriptor();
    public IViewContext<E> getViewContext();
    public IViewModel<E> getViewModel();

    public Layout getLayout();
}
