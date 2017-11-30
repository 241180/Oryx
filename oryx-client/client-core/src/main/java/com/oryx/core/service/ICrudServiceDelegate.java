package com.oryx.core.service;

import com.oryx.core.delegate.IDelegate;
import com.oryx.core.factory.IFactory;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;

import javax.xml.ws.Service;
import java.util.List;

/**
 * Created by smbarki on 02/05/2017.
 */
public interface ICrudServiceDelegate<B> extends IDelegate {
    public ITypeByTokenProvider getTypeByTokenProvider();

    public IFactory getExchangeObjectFactory();

    public XmlEnumObjectType getEnumObjectType();

    public Service getService();

    public void setService(Service service);

    public List<B> getResponseBeans();

    public List<B> getRequestBeans();

    public String getResponseMessage();

    public Integer getResponseErrCode();

    public void create(B bean);

    public void create(List<B> beans);

    public void update(B bean);

    public void delete(B bean);

    public void delete(List<B> beans);

    public List<B> findAll();

    public List<B> findByCriteria(B bean);
}
