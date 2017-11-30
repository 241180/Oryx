package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumCivility", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumCivility {
    @XmlEnumValue("Married")
    MARRIED,
    @XmlEnumValue("Single")
    SINGLE
}
