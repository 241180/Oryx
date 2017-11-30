package com.oryx.remote.service.entry.factory.exchangeObject.view.system.ose;

import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.remote.webservices.service.userviewservice.ViewRequest;
import com.oryx.remote.webservices.service.userviewservice.ViewResponse;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 04/01/2017.
 */
@Component
public class UserViewExchangeObjFactory extends ExchangeObjectFactory {
    public Object create(Class<?> clazz) {
        if (clazz == ViewRequest.class) {
            return (Object) new ViewRequest();
        } else if (clazz == ViewResponse.class) {
            return (Object) new ViewResponse();
        } else
            return super.create(clazz);
    }
}
