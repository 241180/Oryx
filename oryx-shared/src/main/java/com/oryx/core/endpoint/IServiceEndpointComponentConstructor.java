package com.oryx.core.endpoint;

import com.oryx.core.factory.IFactory;
import com.oryx.core.provider.ITypeByTokenProvider;

public interface IServiceEndpointComponentConstructor<Q, R, QD> {
    public ITypeByTokenProvider getTypeByTokenProvider();

    public IFactory getExchangeObjectFactory();
}