package com.oryx.core.interceptor;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class Interceptor<T> implements IInterceptor<T> {

    final static Logger logger = Logger.getLogger(Interceptor.class);
    private T t;

    private IInterceptorHandler interceptorHandler;

    public Interceptor(IInterceptorHandler interceptorHandler, T t) {
        this.interceptorHandler = interceptorHandler;
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("Begin method call : " + method.getName());
        if (interceptorHandler != null)
            interceptorHandler.beforeCall();
        Object result = method.invoke(t, args);
        if (interceptorHandler != null)
            interceptorHandler.afterCall();
        logger.info("End method call : " + method.getName());
        return result;
    }
}
