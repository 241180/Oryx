package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumErrorCode", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumErrorCode {
    @XmlEnumValue("ObjectNotfound")
    OBJECT_NOT_FOUND,
    @XmlEnumValue("ObjectDuplicated")
    OBJECT_DUPLICATED,
    @XmlEnumValue("UniqueConstraintViolated")
    UNIQUE_CONSTRAINT_VIOLATED
}
