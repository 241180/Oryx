package com.oryx.core.provider.typeByToken.view.bu.health;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;
import com.oryx.remote.webservices.service.patientviewservice.ViewRequest;
import com.oryx.remote.webservices.service.patientviewservice.ViewResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class PatientViewTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlPatientView.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlPatientView.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = ViewRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = ViewResponse.class;
}
