package com.oryx.core.delegate.system.ref;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.CountryExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ref.CountryTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.CountryService;
import com.oryx.remote.webservice.element._enum.CountryServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ref.XmlCountry;
import com.oryx.remote.webservices.service.countryservice.CrudRequest;
import com.oryx.remote.webservices.service.countryservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.COUNTRY)
@AssoTypeByTokenProvider(classType = CountryTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = CountryExchangeObjFactory.class)
public class CountryServiceDelegate extends AbstractCrudService<XmlCountry, CountryService
        , CrudRequest, CrudResponse> {

    public CountryServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public CountryService getWebService() {
        return ((CountryServices) getService()).getCountryServiceSoap11();
    }
}
