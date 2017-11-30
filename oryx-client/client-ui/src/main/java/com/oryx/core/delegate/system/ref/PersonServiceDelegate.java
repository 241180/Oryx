package com.oryx.core.delegate.system.ref;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.PersonExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ref.PersonTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.PersonService;
import com.oryx.remote.webservice.element._enum.PersonServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;
import com.oryx.remote.webservices.service.personservice.CrudRequest;
import com.oryx.remote.webservices.service.personservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.PERSON)
@AssoTypeByTokenProvider(classType = PersonTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = PersonExchangeObjFactory.class)
public class PersonServiceDelegate extends AbstractCrudService<XmlPerson, PersonService
        , CrudRequest, CrudResponse> {

    public PersonServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public PersonService getWebService() {
        return ((PersonServices) getService()).getPersonServiceSoap11();
    }
}
