package com.oryx.core.delegate.bu.health;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.health.RdvExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.health.RdvTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.RdvService;
import com.oryx.remote.webservice.element._enum.RdvServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;
import com.oryx.remote.webservices.service.rdvservice.CrudRequest;
import com.oryx.remote.webservices.service.rdvservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.RDV)
@AssoTypeByTokenProvider(classType = RdvTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = RdvExchangeObjFactory.class)
public class RdvServiceDelegate extends AbstractCrudService<XmlRdv, RdvService
        , CrudRequest, CrudResponse> {

    public RdvServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public RdvService getWebService() {
        return ((RdvServices) getService()).getRdvServiceSoap11();
    }
}
