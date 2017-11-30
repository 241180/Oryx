package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumPermission", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumPermission {
    @XmlEnumValue("Full")
    FULL,
    @XmlEnumValue("Select")
    SELECT,
    @XmlEnumValue("Create")
    CREATE,
    @XmlEnumValue("Update")
    UPDATE,
    @XmlEnumValue("Delete")
    DELETE
}
