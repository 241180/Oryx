package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumStatus", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumStatus {
    @XmlEnumValue("Active")
    ACTIVE,
    @XmlEnumValue("Inactive")
    INACTIVE;
}