package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumUserStatus", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumUserStatus {
    @XmlEnumValue("Active")
    ACTIVE,
    @XmlEnumValue("Inactive")
    INACTIVE;
}