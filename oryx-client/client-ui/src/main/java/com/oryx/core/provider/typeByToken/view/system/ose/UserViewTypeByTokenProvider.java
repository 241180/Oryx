package com.oryx.core.provider.typeByToken.view.system.ose;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;
import com.oryx.remote.webservices.service.userviewservice.ViewRequest;
import com.oryx.remote.webservices.service.userviewservice.ViewResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class UserViewTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlUserView.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlUserView.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = ViewRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = ViewResponse.class;
}
