package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.FieldProcessParamExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.FieldProcessParamTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.FieldProcessParamService;
import com.oryx.remote.webservice.element._enum.FieldProcessParamServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlFieldProcessParam;
import com.oryx.remote.webservices.service.fieldprocessparamservice.CrudRequest;
import com.oryx.remote.webservices.service.fieldprocessparamservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.FIELDPROCESSPARAM)
@AssoTypeByTokenProvider(classType = FieldProcessParamTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = FieldProcessParamExchangeObjFactory.class)
public class FieldProcessParamServiceDelegate extends AbstractCrudService<XmlFieldProcessParam, FieldProcessParamService
        , CrudRequest, CrudResponse> {

    public FieldProcessParamServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public FieldProcessParamService getWebService() {
        return ((FieldProcessParamServices) getService()).getFieldProcessParamServiceSoap11();
    }
}
