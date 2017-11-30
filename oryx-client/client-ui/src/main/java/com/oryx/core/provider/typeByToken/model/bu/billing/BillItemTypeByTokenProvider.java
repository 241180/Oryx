package com.oryx.core.provider.typeByToken.model.bu.billing;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;
import com.oryx.remote.webservices.service.billitemservice.CrudRequest;
import com.oryx.remote.webservices.service.billitemservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class BillItemTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlBillItem.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlBillItem.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
