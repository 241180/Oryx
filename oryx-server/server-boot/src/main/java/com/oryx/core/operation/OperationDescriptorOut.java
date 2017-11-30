package com.oryx.core.operation;

import com.oryx.core.enums.EnumEntityModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlOperationDescOut", namespace = "http://operation.element.webservice.remote.oryx.com")
public class OperationDescriptorOut extends AbstractServiceResponseDescriptor {
    private EnumEntityModel objectType;
}
