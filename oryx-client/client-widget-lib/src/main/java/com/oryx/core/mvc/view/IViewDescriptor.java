package com.oryx.core.mvc.view;

/**
 * Created by smbarki on 06/12/2017.
 */
public interface IViewDescriptor<E> {
    public void setController(IViewController<E> controller);

    public void buildContent();
}
