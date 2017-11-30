package com.oryx.remote.service.entry.endpoint.crud.system.ref;

import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.endpoint.ServiceEndpoint;
import com.oryx.core.model.provider.system.ref.ThirdPartyTypeByTokenProvider;
import com.oryx.remote.service.entry.endpoint.crud.namespace.TargetNameSpace;
import com.oryx.remote.service.entry.factory.exchangeObject.crud.system.ref.ThirdPartyExchangeObjFactory;
import com.oryx.remote.webservice.element.model.system.ref.XmlThirdParty;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import com.oryx.remote.webservices.service.thirdpartyservice.CrudRequest;
import com.oryx.remote.webservices.service.thirdpartyservice.CrudResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class ThirdPartyService.
 */
@Endpoint
@AssoExchangeObjectFactory(classType = ThirdPartyExchangeObjFactory.class)
@AssoTypeByTokenProvider(classType = ThirdPartyTypeByTokenProvider.class)
public class ThirdPartyServiceEndpoint extends ServiceEndpoint<XmlThirdParty, CrudRequest, CrudResponse, XmlOperationDescIn, XmlOperationDescOut> {

    final static Logger logger = Logger.getLogger(ThirdPartyServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.CRUD_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_THIRD_PARTY)
    public
    @ResponsePayload
    CrudResponse CrudOperation(@RequestPayload CrudRequest request) {
        return super.superCrudOperation(request);
    }
}