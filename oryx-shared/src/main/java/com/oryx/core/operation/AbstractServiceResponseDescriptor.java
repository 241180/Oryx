package com.oryx.core.operation;

import com.oryx.core.enums.EnumServiceOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractXmlServiceResponseDesc", namespace = "http://operation.element.webservice.remote.oryx.com")
public abstract class AbstractServiceResponseDescriptor {
    private EnumServiceOperation operation;
    private Integer errCode;
    private String msg;
}
