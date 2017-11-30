package com.oryx.core.provider;

import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 16/01/2017.
 */
@Component
public class TypeByTokenProvider extends AbstractTypeByTokenProvider {
    private static final Class<?> REQUEST_DESC_CLASS_TYPE = XmlOperationDescIn.class;
    private static final Class<?> RESPONSE_DESC_CLASS_TYPE = XmlOperationDescOut.class;
}
