package com.oryx.remote.service.entry.factory.exchangeObject.crud.system.msg;

import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.remote.webservices.service.translationservice.CrudRequest;
import com.oryx.remote.webservices.service.translationservice.CrudResponse;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 04/01/2017.
 */
@Component
public class TranslationExchangeObjFactory extends ExchangeObjectFactory {
    public Object create(Class<?> clazz) {
        if (clazz == CrudRequest.class) {
            return (Object) new CrudRequest();
        } else if (clazz == CrudResponse.class) {
            return (Object) new CrudResponse();
        } else
            return super.create(clazz);
    }
}
