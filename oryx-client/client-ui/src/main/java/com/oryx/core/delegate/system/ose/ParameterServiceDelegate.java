package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.ParameterExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.ParameterTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.ParameterService;
import com.oryx.remote.webservice.element._enum.ParameterServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlParameter;
import com.oryx.remote.webservices.service.parameterservice.CrudRequest;
import com.oryx.remote.webservices.service.parameterservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.PARAMETER)
@AssoTypeByTokenProvider(classType = ParameterTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = ParameterExchangeObjFactory.class)
public class ParameterServiceDelegate extends AbstractCrudService<XmlParameter, ParameterService
        , CrudRequest, CrudResponse> {

    public ParameterServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public ParameterService getWebService() {
        return ((ParameterServices) getService()).getParameterServiceSoap11();
    }
}
