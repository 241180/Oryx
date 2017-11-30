package com.oryx.core.factory;

import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 04/01/2017.
 */

@Component
public abstract class ExchangeObjectFactory extends AbstractFactory {
    @Override
    public Object create(Class<?> clazz) {
        if (clazz == XmlOperationDescIn.class) {
            return (Object) new XmlOperationDescIn();
        } else if (clazz == XmlOperationDescOut.class) {
            return (Object) new XmlOperationDescOut();
        } else
            return null;
    }
}
