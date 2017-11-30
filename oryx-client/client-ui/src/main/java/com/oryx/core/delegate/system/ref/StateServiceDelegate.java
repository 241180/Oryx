package com.oryx.core.delegate.system.ref;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.StateExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ref.StateTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.StateService;
import com.oryx.remote.webservice.element._enum.StateServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ref.XmlState;
import com.oryx.remote.webservices.service.stateservice.CrudRequest;
import com.oryx.remote.webservices.service.stateservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.STATE)
@AssoTypeByTokenProvider(classType = StateTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = StateExchangeObjFactory.class)
public class StateServiceDelegate extends AbstractCrudService<XmlState, StateService
        , CrudRequest, CrudResponse> {

    public StateServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public StateService getWebService() {
        return ((StateServices) getService()).getStateServiceSoap11();
    }
}
