package com.oryx.core.factory.system.ose;

import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.remote.webservices.service.upgradesservice.CrudRequest;
import com.oryx.remote.webservices.service.upgradesservice.CrudResponse;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 01/03/2017.
 */

@Component
public class UpgradesExchangeObjFactory extends ExchangeObjectFactory {
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
