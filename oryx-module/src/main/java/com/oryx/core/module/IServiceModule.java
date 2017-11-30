package com.oryx.core.module;

import com.oryx.core.delegate.IDelegate;

import javax.xml.ws.Service;

/**
 * Created by SAMI on 25/03/2017.
 */
public interface IServiceModule extends IModule {
    public void bindService(Class<?> entityClass, Class<? extends IDelegate> delgateClass, Class<? extends Service> serviceClass);

    public IDelegate getService(Class<?> entityClass);
}