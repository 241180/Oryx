package com.oryx.core;

/**
 * Created by smbarki on 06/12/2017.
 */
public interface IViewModel<E> {
    public void setController(IViewController<E> controller);
}