package com.oryx.remote.service.entry.endpoint.crud.system.ose;

import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.endpoint.ServiceEndpoint;
import com.oryx.core.model.provider.system.ose.UserTypeByTokenProvider;
import com.oryx.remote.service.entry.endpoint.crud.namespace.TargetNameSpace;
import com.oryx.remote.service.entry.factory.exchangeObject.crud.system.ose.UserExchangeObjFactory;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import com.oryx.remote.webservices.service.userservice.CrudRequest;
import com.oryx.remote.webservices.service.userservice.CrudResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class UserService.
 */

@Endpoint
@AssoExchangeObjectFactory(classType = UserExchangeObjFactory.class)
@AssoTypeByTokenProvider(classType = UserTypeByTokenProvider.class)
public class UserServiceEndpoint extends ServiceEndpoint<XmlUser, CrudRequest, CrudResponse, XmlOperationDescIn, XmlOperationDescOut> {

    final static Logger logger = Logger.getLogger(UserServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.CRUD_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_USER)
    public
    @ResponsePayload
    CrudResponse CrudOperation(@RequestPayload CrudRequest request) {
        return super.superCrudOperation(request);
    }
}