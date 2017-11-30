package com.oryx.remote.service.entry.endpoint.crud.bu.sale;

import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.endpoint.ServiceEndpoint;
import com.oryx.core.model.provider.bu.sale.ProductCategoryTypeByTokenProvider;
import com.oryx.remote.service.entry.endpoint.crud.namespace.TargetNameSpace;
import com.oryx.remote.service.entry.factory.exchangeObject.crud.bu.sale.ProductCategoryExchangeObjFactory;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProductCategory;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import com.oryx.remote.webservices.service.productcategoryservice.CrudRequest;
import com.oryx.remote.webservices.service.productcategoryservice.CrudResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class ProductCategoryService.
 */
@Endpoint
@AssoExchangeObjectFactory(classType = ProductCategoryExchangeObjFactory.class)
@AssoTypeByTokenProvider(classType = ProductCategoryTypeByTokenProvider.class)
public class ProductCategoryServiceEndpoint extends ServiceEndpoint<XmlProductCategory, CrudRequest, CrudResponse, XmlOperationDescIn, XmlOperationDescOut> {

    final static Logger logger = Logger.getLogger(ProductCategoryServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.CRUD_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_PRODUCT_CATEGORY)
    public
    @ResponsePayload
    CrudResponse CrudOperation(@RequestPayload CrudRequest request) {
        return super.superCrudOperation(request);
    }
}