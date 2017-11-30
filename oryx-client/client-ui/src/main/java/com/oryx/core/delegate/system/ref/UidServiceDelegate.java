package com.oryx.core.delegate.system.ref;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.UidExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ref.UidTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.UidService;
import com.oryx.remote.webservice.element._enum.UidServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ref.XmlUid;
import com.oryx.remote.webservices.service.uidservice.CrudRequest;
import com.oryx.remote.webservices.service.uidservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.UID)
@AssoTypeByTokenProvider(classType = UidTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = UidExchangeObjFactory.class)
public class UidServiceDelegate extends AbstractCrudService<XmlUid, UidService
        , CrudRequest, CrudResponse> {

    public UidServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public UidService getWebService() {
        return ((UidServices) getService()).getUidServiceSoap11();
    }
}
