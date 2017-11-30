package com.oryx.core.interceptor;

/**
 * Created by smbarki on 05/10/2017.
 */
public interface IInterceptorHandler {
    public void beforeCall();

    public void afterCall();
}
