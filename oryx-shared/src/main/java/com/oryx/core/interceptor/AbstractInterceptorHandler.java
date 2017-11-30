package com.oryx.core.interceptor;

/**
 * Created by smbarki on 05/10/2017.
 */
public abstract class AbstractInterceptorHandler implements IInterceptorHandler {
    public abstract void beforeCall();

    public abstract void afterCall();
}
