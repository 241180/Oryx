package com.oryx.core.provider.typeByToken.model.bu.sale;

import com.oryx.core.provider.TypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlShopper;
import com.oryx.remote.webservices.service.shopperservice.CrudRequest;
import com.oryx.remote.webservices.service.shopperservice.CrudResponse;

/**
 * Created by 241180 on 16/01/2017.
 */

public final class ShopperTypeByTokenProvider extends TypeByTokenProvider {
    private static final Class<?> ENTITY_CLASS_TYPE = XmlShopper.class;
    private static final Class<?> XML_ENTITY_CLASS_TYPE = XmlShopper.class;

    private static final Class<?> CRUD_REQUEST_CLASS_TYPE = CrudRequest.class;
    private static final Class<?> CRUD_RESPONSE_CLASS_TYPE = CrudResponse.class;
}
