package com.oryx.core.provider.typeByToken.model.system.ref;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlUid;
import com.oryx.remote.webservices.service.uidservice.CrudRequest;
import com.oryx.remote.webservices.service.uidservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class UidTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlUid.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlUid.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
