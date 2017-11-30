package com.oryx.core.delegate.bu.billing;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.billing.InstanceExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.billing.InstanceTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.InstanceService;
import com.oryx.remote.webservice.element._enum.InstanceServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;
import com.oryx.remote.webservices.service.instanceservice.CrudRequest;
import com.oryx.remote.webservices.service.instanceservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.INSTANCE)
@AssoTypeByTokenProvider(classType = InstanceTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = InstanceExchangeObjFactory.class)
public class InstanceServiceDelegate extends AbstractCrudService<XmlInstance, InstanceService
        , CrudRequest, CrudResponse> {

    public InstanceServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public InstanceService getWebService() {
        return ((InstanceServices) getService()).getInstanceServiceSoap11();
    }
}
