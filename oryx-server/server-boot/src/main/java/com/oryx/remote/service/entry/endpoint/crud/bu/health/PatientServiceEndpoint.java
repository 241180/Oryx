package com.oryx.remote.service.entry.endpoint.crud.bu.health;

import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.endpoint.ServiceEndpoint;
import com.oryx.core.model.provider.bu.health.PatientTypeByTokenProvider;
import com.oryx.remote.service.entry.endpoint.crud.namespace.TargetNameSpace;
import com.oryx.remote.service.entry.factory.exchangeObject.crud.bu.health.PatientExchangeObjFactory;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import com.oryx.remote.webservices.service.patientservice.CrudRequest;
import com.oryx.remote.webservices.service.patientservice.CrudResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class PatientService.
 */
@Endpoint
@AssoExchangeObjectFactory(classType = PatientExchangeObjFactory.class)
@AssoTypeByTokenProvider(classType = PatientTypeByTokenProvider.class)
public class PatientServiceEndpoint extends ServiceEndpoint<XmlPatient, CrudRequest, CrudResponse, XmlOperationDescIn, XmlOperationDescOut> {

    final static Logger logger = Logger.getLogger(PatientServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.CRUD_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_PATIENT)
    public
    @ResponsePayload
    CrudResponse CrudOperation(@RequestPayload CrudRequest request) {
        return super.superCrudOperation(request);
    }
}