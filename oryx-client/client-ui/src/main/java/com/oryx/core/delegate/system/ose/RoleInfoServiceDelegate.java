package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.RoleInfoExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.RoleInfoTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.RoleInfoService;
import com.oryx.remote.webservice.element._enum.RoleInfoServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlRoleInfo;
import com.oryx.remote.webservices.service.roleinfoservice.CrudRequest;
import com.oryx.remote.webservices.service.roleinfoservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.ROLEINFO)
@AssoTypeByTokenProvider(classType = RoleInfoTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = RoleInfoExchangeObjFactory.class)
public class RoleInfoServiceDelegate extends AbstractCrudService<XmlRoleInfo, RoleInfoService
        , CrudRequest, CrudResponse> {

    public RoleInfoServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public RoleInfoService getWebService() {
        return ((RoleInfoServices) getService()).getRoleInfoServiceSoap11();
    }
}
