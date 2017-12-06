package com.oryx.core;

/**
 * Created by smbarki on 06/12/2017.
 */
public interface IViewDescriptor {
    public void setController(IViewController controller);

    public void buildContent();
}
