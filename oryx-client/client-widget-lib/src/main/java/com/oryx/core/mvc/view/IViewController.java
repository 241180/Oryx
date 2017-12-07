package com.oryx.core.mvc.view;

import com.oryx.core.bundle.IBundle;

/**
 * Created by smbarki on 06/12/2017.
 */
public interface IViewController<E> {
    public Class<? extends IBundle> getConstantBundle();
    public IViewDescriptor<E> getViewDescriptor();
    public IViewContext<E> getViewContext();
    public IViewModel<E> getViewModel();
}
