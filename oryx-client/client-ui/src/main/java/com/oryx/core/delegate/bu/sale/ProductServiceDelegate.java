package com.oryx.core.delegate.bu.sale;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.sale.ProductExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.sale.ProductTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.ProductService;
import com.oryx.remote.webservice.element._enum.ProductServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProduct;
import com.oryx.remote.webservices.service.productservice.CrudRequest;
import com.oryx.remote.webservices.service.productservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.PRODUCT)
@AssoTypeByTokenProvider(classType = ProductTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = ProductExchangeObjFactory.class)
public class ProductServiceDelegate extends AbstractCrudService<XmlProduct, ProductService
        , CrudRequest, CrudResponse> {

    public ProductServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public ProductService getWebService() {
        return ((ProductServices) getService()).getProductServiceSoap11();
    }
}
