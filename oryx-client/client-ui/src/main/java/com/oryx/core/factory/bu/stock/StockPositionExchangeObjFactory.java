package com.oryx.core.factory.bu.stock;

import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.remote.webservices.service.stockpositionservice.CrudRequest;
import com.oryx.remote.webservices.service.stockpositionservice.CrudResponse;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 01/03/2017.
 */

@Component
public class StockPositionExchangeObjFactory extends ExchangeObjectFactory {
    @Override
    public Object create(Class<?> clazz) {
        if (clazz == CrudRequest.class) {
            return (Object) new CrudRequest();
        } else if (clazz == CrudResponse.class) {
            return (Object) new CrudResponse();
        } else
            return super.create(clazz);
    }
}
