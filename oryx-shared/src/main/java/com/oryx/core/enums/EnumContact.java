package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumContact", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumContact {
    @XmlEnumValue("Mobile")
    MPHONE,
    @XmlEnumValue("Phone")
    FPHONE,
    @XmlEnumValue("Fax")
    FAX,
    @XmlEnumValue("Email")
    EMAIL,
    @XmlEnumValue("Web")
    WEB
}
