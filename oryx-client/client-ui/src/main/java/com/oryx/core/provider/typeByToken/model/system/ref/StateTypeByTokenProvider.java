package com.oryx.core.provider.typeByToken.model.system.ref;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlState;
import com.oryx.remote.webservices.service.stateservice.CrudRequest;
import com.oryx.remote.webservices.service.stateservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class StateTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlState.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlState.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
