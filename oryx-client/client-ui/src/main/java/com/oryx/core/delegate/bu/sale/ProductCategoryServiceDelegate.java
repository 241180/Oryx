package com.oryx.core.delegate.bu.sale;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.sale.ProductCategoryExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.sale.ProductCategoryTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.ProductCategoryService;
import com.oryx.remote.webservice.element._enum.ProductCategoryServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProductCategory;
import com.oryx.remote.webservices.service.productcategoryservice.CrudRequest;
import com.oryx.remote.webservices.service.productcategoryservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.PRODUCTCATEGORY)
@AssoTypeByTokenProvider(classType = ProductCategoryTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = ProductCategoryExchangeObjFactory.class)
public class ProductCategoryServiceDelegate extends AbstractCrudService<XmlProductCategory, ProductCategoryService
        , CrudRequest, CrudResponse> {

    public ProductCategoryServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public ProductCategoryService getWebService() {
        return ((ProductCategoryServices) getService()).getProductCategoryServiceSoap11();
    }
}
