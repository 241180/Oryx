package com.oryx.core.delegate.bu.stock;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.stock.ProductLotExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.stock.ProductLotTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.ProductLotService;
import com.oryx.remote.webservice.element._enum.ProductLotServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;
import com.oryx.remote.webservices.service.productlotservice.CrudRequest;
import com.oryx.remote.webservices.service.productlotservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.PRODUCTLOT)
@AssoTypeByTokenProvider(classType = ProductLotTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = ProductLotExchangeObjFactory.class)
public class ProductLotServiceDelegate extends AbstractCrudService<XmlProductLot, ProductLotService
        , CrudRequest, CrudResponse> {

    public ProductLotServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public ProductLotService getWebService() {
        return ((ProductLotServices) getService()).getProductLotServiceSoap11();
    }
}
