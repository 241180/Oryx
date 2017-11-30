package com.oryx.core.delegate.system.msg;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.msg.ErrorMessageExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.msg.ErrorMessageTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.ErrorMessageService;
import com.oryx.remote.webservice.element._enum.ErrorMessageServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;
import com.oryx.remote.webservices.service.errormessageservice.CrudRequest;
import com.oryx.remote.webservices.service.errormessageservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.ERRORMESSAGE)
@AssoTypeByTokenProvider(classType = ErrorMessageTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = ErrorMessageExchangeObjFactory.class)
public class ErrorMessageServiceDelegate extends AbstractCrudService<XmlErrorMessage, ErrorMessageService
        , CrudRequest, CrudResponse> {

    public ErrorMessageServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public ErrorMessageService getWebService() {
        return ((ErrorMessageServices) getService()).getErrorMessageServiceSoap11();
    }
}
