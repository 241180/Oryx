package com.oryx.core.delegate.bu.health;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.health.PatientViewExchangeObjFactory;
import com.oryx.core.provider.typeByToken.view.bu.health.PatientViewTypeByTokenProvider;
import com.oryx.core.service.AbstractViewServiceMethods;
import com.oryx.remote.webservice.element._enum.PatientViewService;
import com.oryx.remote.webservice.element._enum.PatientViewServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;
import com.oryx.remote.webservices.service.patientviewservice.ViewRequest;
import com.oryx.remote.webservices.service.patientviewservice.ViewResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.PATIENTVIEW)
@AssoTypeByTokenProvider(classType = PatientViewTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = PatientViewExchangeObjFactory.class)
public class PatientViewServiceDelegate extends AbstractViewServiceMethods<XmlPatientView, PatientViewService
        , ViewRequest, ViewResponse> {

    public PatientViewServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public PatientViewService getWebService() {
        return ((PatientViewServices) getService()).getPatientViewServiceSoap11();
    }
}
