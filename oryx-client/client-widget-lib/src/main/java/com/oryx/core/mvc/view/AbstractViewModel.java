package com.oryx.core.mvc.view;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewModel<E> implements IViewModel<E> {
    private IViewController<E> viewController;

    @Override
    public void setController(IViewController<E> controller) {
        this.viewController = controller;
    }
}
