package com.oryx.core.provider.typeByToken.model.system.ref;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;
import com.oryx.remote.webservices.service.adressservice.CrudRequest;
import com.oryx.remote.webservices.service.adressservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class AdressTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlAdress.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlAdress.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
