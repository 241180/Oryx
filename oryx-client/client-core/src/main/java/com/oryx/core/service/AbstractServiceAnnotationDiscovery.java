package com.oryx.core.service;

import com.oryx.core.annotation.capable.IAssoExchangeObjectFactoryCapable;
import com.oryx.core.annotation.capable.IRequestEntityCapable;
import com.oryx.core.annotation.capable.ITypeByTokenCapable;
import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.core.factory.IFactory;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import org.apache.log4j.Logger;

import javax.xml.ws.Service;

public abstract class AbstractServiceAnnotationDiscovery<E, S> implements ICrudServiceDelegate<E> {

    final static Logger logger = Logger.getLogger(AbstractServiceAnnotationDiscovery.class);

    private Service service;
    private IFactory factory;
    private ITypeByTokenProvider typeByTokenProvider;
    private XmlEnumObjectType xmlObjectType;


    public AbstractServiceAnnotationDiscovery(Service service) {
        this.service = service;
    }

    @Override
    public ITypeByTokenProvider getTypeByTokenProvider() {
        if (typeByTokenProvider != null)
            return typeByTokenProvider;

        typeByTokenProvider = ITypeByTokenCapable.getInstance(this);
        return typeByTokenProvider;
    }

    @Override
    public IFactory getExchangeObjectFactory() {
        if (this.factory != null)
            return this.factory;

        factory = (ExchangeObjectFactory) IAssoExchangeObjectFactoryCapable.getInstance(this);
        return factory;
    }

    @Override
    public XmlEnumObjectType getEnumObjectType() {
        if (xmlObjectType != null)
            return xmlObjectType;

        xmlObjectType = IRequestEntityCapable.getValue(this);
        return xmlObjectType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public abstract S getWebService();
}
