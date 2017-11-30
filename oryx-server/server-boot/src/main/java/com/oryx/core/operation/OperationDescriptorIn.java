package com.oryx.core.operation;

import com.oryx.core.enums.EnumEntityModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlOperationDescIn", namespace = "http://operation.element.webservice.remote.oryx.com")
public class OperationDescriptorIn extends AbstractServiceRequestDescriptor {
    private EnumEntityModel objectType;
}
