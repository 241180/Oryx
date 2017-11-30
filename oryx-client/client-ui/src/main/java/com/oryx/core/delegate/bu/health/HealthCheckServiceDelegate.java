package com.oryx.core.delegate.bu.health;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.health.HealthCheckExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.health.HealthCheckTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.HealthCheckService;
import com.oryx.remote.webservice.element._enum.HealthCheckServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;
import com.oryx.remote.webservices.service.healthcheckservice.CrudRequest;
import com.oryx.remote.webservices.service.healthcheckservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.HEALTHCHECK)
@AssoTypeByTokenProvider(classType = HealthCheckTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = HealthCheckExchangeObjFactory.class)
public class HealthCheckServiceDelegate extends AbstractCrudService<XmlHealthCheck, HealthCheckService
        , CrudRequest, CrudResponse> {

    public HealthCheckServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public HealthCheckService getWebService() {
        return ((HealthCheckServices) getService()).getHealthCheckServiceSoap11();
    }
}
