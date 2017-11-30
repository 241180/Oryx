package com.oryx.remote.service.entry.endpoint.crud.bu.health;

import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.endpoint.ServiceEndpoint;
import com.oryx.core.model.provider.bu.health.HealthCheckTypeByTokenProvider;
import com.oryx.remote.service.entry.endpoint.crud.namespace.TargetNameSpace;
import com.oryx.remote.service.entry.factory.exchangeObject.crud.bu.health.HealthCheckExchangeObjFactory;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import com.oryx.remote.webservices.service.healthcheckservice.CrudRequest;
import com.oryx.remote.webservices.service.healthcheckservice.CrudResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class HealthCheckService.
 */
@Endpoint
@AssoExchangeObjectFactory(classType = HealthCheckExchangeObjFactory.class)
@AssoTypeByTokenProvider(classType = HealthCheckTypeByTokenProvider.class)
public class HealthCheckServiceEndpoint extends ServiceEndpoint<XmlHealthCheck, CrudRequest, CrudResponse, XmlOperationDescIn, XmlOperationDescOut> {

    final static Logger logger = Logger.getLogger(HealthCheckServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.CRUD_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_HEALTH_CHECK)
    public
    @ResponsePayload
    CrudResponse CrudOperation(@RequestPayload CrudRequest request) {
        return super.superCrudOperation(request);
    }
}