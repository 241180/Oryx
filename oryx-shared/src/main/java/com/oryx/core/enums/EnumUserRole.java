package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumUserRole", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumUserRole {
    @XmlEnumValue("Administrator")
    ROLE_ADMIN, //
    @XmlEnumValue("User")
    ROLE_USER //
}
