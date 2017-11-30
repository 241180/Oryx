package com.oryx.core.delegate.bu.stock;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.stock.StockPositionExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.stock.StockPositionTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.StockPositionService;
import com.oryx.remote.webservice.element._enum.StockPositionServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.stock.XmlStockPosition;
import com.oryx.remote.webservices.service.stockpositionservice.CrudRequest;
import com.oryx.remote.webservices.service.stockpositionservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.STOCKPOSITION)
@AssoTypeByTokenProvider(classType = StockPositionTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = StockPositionExchangeObjFactory.class)
public class StockPositionServiceDelegate extends AbstractCrudService<XmlStockPosition, StockPositionService
        , CrudRequest, CrudResponse> {

    public StockPositionServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public StockPositionService getWebService() {
        return ((StockPositionServices) getService()).getStockPositionServiceSoap11();
    }
}
