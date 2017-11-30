package com.oryx.core.provider.typeByToken.model.system.ose;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlCodification;
import com.oryx.remote.webservices.service.codificationservice.CrudRequest;
import com.oryx.remote.webservices.service.codificationservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class CodificationTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlCodification.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlCodification.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
