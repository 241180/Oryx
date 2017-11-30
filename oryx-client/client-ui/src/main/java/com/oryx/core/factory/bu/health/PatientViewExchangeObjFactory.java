package com.oryx.core.factory.bu.health;

import com.oryx.core.factory.ExchangeObjectFactory;
import com.oryx.remote.webservices.service.patientviewservice.ViewRequest;
import com.oryx.remote.webservices.service.patientviewservice.ViewResponse;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 01/03/2017.
 */

@Component
public class PatientViewExchangeObjFactory extends ExchangeObjectFactory {
    @Override
    public Object create(Class<?> clazz) {
        if (clazz == ViewRequest.class) {
            return (Object) new ViewRequest();
        } else if (clazz == ViewResponse.class) {
            return (Object) new ViewResponse();
        } else
            return super.create(clazz);
    }
}
