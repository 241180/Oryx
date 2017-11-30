package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumBillStatus", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumBillStatus {
    @XmlEnumValue("Calculated")
    CALCULATED,
    @XmlEnumValue("Issued")
    ISSUED,
    @XmlEnumValue("Paid")
    PAID,
    @XmlEnumValue("Blocked")
    BLOCKED,
    @XmlEnumValue("Canceled")
    CANCELED,
    @XmlEnumValue("OutDated")
    OUTDATED;
}