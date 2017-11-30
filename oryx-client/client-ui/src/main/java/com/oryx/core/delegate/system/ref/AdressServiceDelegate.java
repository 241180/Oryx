package com.oryx.core.delegate.system.ref;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.AdressExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ref.AdressTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.AdressService;
import com.oryx.remote.webservice.element._enum.AdressServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;
import com.oryx.remote.webservices.service.adressservice.CrudRequest;
import com.oryx.remote.webservices.service.adressservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.ADRESS)
@AssoTypeByTokenProvider(classType = AdressTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = AdressExchangeObjFactory.class)
public class AdressServiceDelegate extends AbstractCrudService<XmlAdress, AdressService
        , CrudRequest, CrudResponse> {

    public AdressServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public AdressService getWebService() {
        return ((AdressServices) getService()).getAdressServiceSoap11();
    }
}
