package com.oryx.core.endpoint;

import com.oryx.core.annotation.capable.IAssoExchangeObjectFactoryCapable;
import com.oryx.core.annotation.capable.ITypeByTokenCapable;
import com.oryx.core.factory.IFactory;
import com.oryx.core.provider.ITypeByTokenProvider;
import org.apache.log4j.Logger;

public abstract class ServiceEndpointComponentConstructor<Q, R, QD> implements IServiceEndpointComponentConstructor {

    final static Logger logger = Logger.getLogger(ServiceEndpointComponentConstructor.class);

    private ITypeByTokenProvider iTypeByTokenProvider;
    private IFactory iExchangeObjectFactory;

    @Override
    public ITypeByTokenProvider getTypeByTokenProvider() {
        if (iTypeByTokenProvider != null)
            return iTypeByTokenProvider;

        iTypeByTokenProvider = ITypeByTokenCapable.getInstance(this);
        return iTypeByTokenProvider;
    }

    @Override
    public IFactory getExchangeObjectFactory() {
        if (iExchangeObjectFactory != null)
            return iExchangeObjectFactory;

        iExchangeObjectFactory = IAssoExchangeObjectFactoryCapable.getInstance(this);
        return iExchangeObjectFactory;
    }
}