package com.oryx.remote.service.entry.endpoint.crud.system.ref;

import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.endpoint.ServiceEndpoint;
import com.oryx.core.model.provider.system.ref.AdressTypeByTokenProvider;
import com.oryx.remote.service.entry.endpoint.crud.namespace.TargetNameSpace;
import com.oryx.remote.service.entry.factory.exchangeObject.crud.system.ref.AdressExchangeObjFactory;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import com.oryx.remote.webservices.service.adressservice.CrudRequest;
import com.oryx.remote.webservices.service.adressservice.CrudResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class AdressService.
 */
@Endpoint
@AssoExchangeObjectFactory(classType = AdressExchangeObjFactory.class)
@AssoTypeByTokenProvider(classType = AdressTypeByTokenProvider.class)
public class AdressServiceEndpoint extends ServiceEndpoint<XmlAdress, CrudRequest, CrudResponse, XmlOperationDescIn, XmlOperationDescOut> {

    final static Logger logger = Logger.getLogger(AdressServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.CRUD_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_ADRESS)
    public
    @ResponsePayload
    CrudResponse CrudOperation(@RequestPayload CrudRequest request) {
        return super.superCrudOperation(request);
    }
}