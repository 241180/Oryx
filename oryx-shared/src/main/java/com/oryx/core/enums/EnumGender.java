package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumGender", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumGender {
    @XmlEnumValue("Male")
    MALE,
    @XmlEnumValue("Female")
    FEMALE
}
