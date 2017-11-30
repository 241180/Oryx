package com.oryx.core.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public interface IInterceptor<T> extends InvocationHandler {
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(IInterceptorHandler interceptorHandler, T t, Class<? super T> interfaceType) {
        Interceptor handler = new Interceptor(interceptorHandler, t);
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType}, handler
        );
    }
}
