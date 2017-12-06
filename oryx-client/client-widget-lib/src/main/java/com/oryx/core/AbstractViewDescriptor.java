package com.oryx.core;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewDescriptor implements IViewDescriptor {
    private IViewController viewController;

    @Override
    public void setController(IViewController controller) {
        this.viewController = controller;
    }
}
