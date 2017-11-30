package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.CodificationExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.CodificationTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.CodificationService;
import com.oryx.remote.webservice.element._enum.CodificationServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlCodification;
import com.oryx.remote.webservices.service.codificationservice.CrudRequest;
import com.oryx.remote.webservices.service.codificationservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.CODIFICATION)
@AssoTypeByTokenProvider(classType = CodificationTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = CodificationExchangeObjFactory.class)
public class CodificationServiceDelegate extends AbstractCrudService<XmlCodification, CodificationService
        , CrudRequest, CrudResponse> {

    public CodificationServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public CodificationService getWebService() {
        return ((CodificationServices) getService()).getCodificationServiceSoap11();
    }
}
