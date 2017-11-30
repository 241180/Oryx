package com.oryx.core.delegate.bu.health;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.health.PatientExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.health.PatientTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.PatientService;
import com.oryx.remote.webservice.element._enum.PatientServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.oryx.remote.webservices.service.patientservice.CrudRequest;
import com.oryx.remote.webservices.service.patientservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.PATIENT)
@AssoTypeByTokenProvider(classType = PatientTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = PatientExchangeObjFactory.class)
public class PatientServiceDelegate extends AbstractCrudService<XmlPatient, PatientService
        , CrudRequest, CrudResponse> {

    public PatientServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public PatientService getWebService() {
        return ((PatientServices) getService()).getPatientServiceSoap11();
    }
}
