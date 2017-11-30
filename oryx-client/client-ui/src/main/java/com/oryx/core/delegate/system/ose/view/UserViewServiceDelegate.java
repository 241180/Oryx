package com.oryx.core.delegate.system.ose.view;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ref.UserViewExchangeObjFactory;
import com.oryx.core.provider.typeByToken.view.system.ose.UserViewTypeByTokenProvider;
import com.oryx.core.service.AbstractViewServiceMethods;
import com.oryx.remote.webservice.element._enum.UserViewService;
import com.oryx.remote.webservice.element._enum.UserViewServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;
import com.oryx.remote.webservices.service.userviewservice.ViewRequest;
import com.oryx.remote.webservices.service.userviewservice.ViewResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.USERVIEW)
@AssoTypeByTokenProvider(classType = UserViewTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = UserViewExchangeObjFactory.class)
public class UserViewServiceDelegate extends AbstractViewServiceMethods<XmlUserView, UserViewService
        , ViewRequest, ViewResponse> {

    public UserViewServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public UserViewService getWebService() {
        return ((UserViewServices) getService()).getUserViewServiceSoap11();
    }
}
