package com.oryx.core;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewContext<E> implements IViewContext<E> {
    private IViewController<E> viewController;

    @Override
    public void setController(IViewController<E> controller) {
        this.viewController = controller;
    }
}
