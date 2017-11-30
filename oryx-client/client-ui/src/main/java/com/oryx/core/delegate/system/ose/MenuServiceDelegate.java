package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.MenuExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.MenuTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.MenuService;
import com.oryx.remote.webservice.element._enum.MenuServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlMenu;
import com.oryx.remote.webservices.service.menuservice.CrudRequest;
import com.oryx.remote.webservices.service.menuservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.MENU)
@AssoTypeByTokenProvider(classType = MenuTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = MenuExchangeObjFactory.class)
public class MenuServiceDelegate extends AbstractCrudService<XmlMenu, MenuService
        , CrudRequest, CrudResponse> {

    public MenuServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public MenuService getWebService() {
        return ((MenuServices) getService()).getMenuServiceSoap11();
    }
}
