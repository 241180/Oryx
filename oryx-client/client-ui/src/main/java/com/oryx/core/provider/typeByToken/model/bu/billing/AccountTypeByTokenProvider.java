package com.oryx.core.provider.typeByToken.model.bu.billing;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;
import com.oryx.remote.webservices.service.accountservice.CrudRequest;
import com.oryx.remote.webservices.service.accountservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class AccountTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlAccount.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlAccount.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
