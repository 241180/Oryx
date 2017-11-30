package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.DomainExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.DomainTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.DomainService;
import com.oryx.remote.webservice.element._enum.DomainServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlDomain;
import com.oryx.remote.webservices.service.domainservice.CrudRequest;
import com.oryx.remote.webservices.service.domainservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.DOMAIN)
@AssoTypeByTokenProvider(classType = DomainTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = DomainExchangeObjFactory.class)
public class DomainServiceDelegate extends AbstractCrudService<XmlDomain, DomainService
        , CrudRequest, CrudResponse> {

    public DomainServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public DomainService getWebService() {
        return ((DomainServices) getService()).getDomainServiceSoap11();
    }
}
