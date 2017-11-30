package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.UserExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.UserTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.UserService;
import com.oryx.remote.webservice.element._enum.UserServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.oryx.remote.webservices.service.userservice.CrudRequest;
import com.oryx.remote.webservices.service.userservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.USER)
@AssoTypeByTokenProvider(classType = UserTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = UserExchangeObjFactory.class)
public class UserServiceDelegate extends AbstractCrudService<XmlUser, UserService
        , CrudRequest, CrudResponse> {

    public UserServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public UserService getWebService() {
        return ((UserServices) getService()).getUserServiceSoap11();
    }
}
