package com.oryx.remote.service.entry.factory.exchangeObject.crud.system.ref;

import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.remote.webservices.service.domainservice.CrudRequest;
import com.oryx.remote.webservices.service.domainservice.CrudResponse;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 04/01/2017.
 */
@Component
public class DomainExchangeObjFactory extends ExchangeObjectFactory {
    public Object create(Class<?> clazz) {
        if (clazz == CrudRequest.class) {
            return (Object) new CrudRequest();
        } else if (clazz == CrudResponse.class) {
            return (Object) new CrudResponse();
        } else
            return super.create(clazz);
    }
}
