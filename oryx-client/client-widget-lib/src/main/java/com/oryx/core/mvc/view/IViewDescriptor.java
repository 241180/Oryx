package com.oryx.core.mvc.view;

import com.oryx.core.bundle.IBundle;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Layout;

/**
 * Created by smbarki on 06/12/2017.
 */
public interface IViewDescriptor<E> {
    public void setController(IViewController<E> controller);
    public IViewController<E> getViewController();
    public void setViewController(IViewController<E> viewController);
    public Layout getLayout();
    public void setLayout(Layout layout);

    public void buildLayoutContent();

    public Class<? extends IBundle> getConstantBundle();
    public String getCustomLayout();
}
