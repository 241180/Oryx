package com.oryx.core.delegate.system.ref;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.ContactExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ref.ContactTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.ContactService;
import com.oryx.remote.webservice.element._enum.ContactServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ref.XmlContact;
import com.oryx.remote.webservices.service.contactservice.CrudRequest;
import com.oryx.remote.webservices.service.contactservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.CONTACT)
@AssoTypeByTokenProvider(classType = ContactTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = ContactExchangeObjFactory.class)
public class ContactServiceDelegate extends AbstractCrudService<XmlContact, ContactService
        , CrudRequest, CrudResponse> {

    public ContactServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public ContactService getWebService() {
        return ((ContactServices) getService()).getContactServiceSoap11();
    }
}
