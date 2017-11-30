package com.oryx.core.provider.typeByToken.model.system.ref;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlContact;
import com.oryx.remote.webservices.service.contactservice.CrudRequest;
import com.oryx.remote.webservices.service.contactservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class ContactTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlContact.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlContact.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
