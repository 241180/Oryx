package com.oryx.core.delegate.system.ref;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.ThirdPartyExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ref.ThirdPartyTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.ThirdPartyService;
import com.oryx.remote.webservice.element._enum.ThirdPartyServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ref.XmlThirdParty;
import com.oryx.remote.webservices.service.thirdpartyservice.CrudRequest;
import com.oryx.remote.webservices.service.thirdpartyservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.THIRDPARTY)
@AssoTypeByTokenProvider(classType = ThirdPartyTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = ThirdPartyExchangeObjFactory.class)
public class ThirdPartyServiceDelegate extends AbstractCrudService<XmlThirdParty, ThirdPartyService
        , CrudRequest, CrudResponse> {

    public ThirdPartyServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public ThirdPartyService getWebService() {
        return ((ThirdPartyServices) getService()).getThirdPartyServiceSoap11();
    }
}
