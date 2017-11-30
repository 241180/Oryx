package com.oryx.remote.service.entry.factory.exchangeObject.crud.system.ref;

import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.remote.webservices.service.stateservice.CrudRequest;
import com.oryx.remote.webservices.service.stateservice.CrudResponse;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 04/01/2017.
 */
@Component
public class StateExchangeObjFactory extends ExchangeObjectFactory {
    public Object create(Class<?> clazz) {
        if (clazz == CrudRequest.class) {
            return (Object) new CrudRequest();
        } else if (clazz == CrudResponse.class) {
            return (Object) new CrudResponse();
        } else
            return super.create(clazz);
    }
}
