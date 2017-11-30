package com.oryx.core.delegate.bu.sale;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.sale.CartExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.sale.CartTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.CartService;
import com.oryx.remote.webservice.element._enum.CartServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCart;
import com.oryx.remote.webservices.service.cartservice.CrudRequest;
import com.oryx.remote.webservices.service.cartservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.CART)
@AssoTypeByTokenProvider(classType = CartTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = CartExchangeObjFactory.class)
public class CartServiceDelegate extends AbstractCrudService<XmlCart, CartService
        , CrudRequest, CrudResponse> {

    public CartServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public CartService getWebService() {
        return ((CartServices) getService()).getCartServiceSoap11();
    }
}
