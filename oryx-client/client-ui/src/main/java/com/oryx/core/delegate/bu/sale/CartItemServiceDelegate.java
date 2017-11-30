package com.oryx.core.delegate.bu.sale;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.sale.CartItemExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.sale.CartItemTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.CartItemService;
import com.oryx.remote.webservice.element._enum.CartItemServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCartItem;
import com.oryx.remote.webservices.service.cartitemservice.CrudRequest;
import com.oryx.remote.webservices.service.cartitemservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.CARTITEM)
@AssoTypeByTokenProvider(classType = CartItemTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = CartItemExchangeObjFactory.class)
public class CartItemServiceDelegate extends AbstractCrudService<XmlCartItem, CartItemService
        , CrudRequest, CrudResponse> {

    public CartItemServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public CartItemService getWebService() {
        return ((CartItemServices) getService()).getCartItemServiceSoap11();
    }
}
