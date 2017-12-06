package com.oryx.core;

import com.oryx.core.bundle.IBundle;

/**
 * Created by smbarki on 06/12/2017.
 */
public interface IViewController {
    public Class<? extends IBundle> getConstantBundle();
    public IViewDescriptor getViewDescriptor();
    public IViewContext getViewContext();
    public IViewModel getViewModel();
}
