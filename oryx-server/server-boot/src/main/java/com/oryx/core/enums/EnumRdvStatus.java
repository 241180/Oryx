package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumRdvStatus", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumRdvStatus {
    @XmlEnumValue("Planned")
    PLANNED,
    @XmlEnumValue("Accepted")
    ACCEPTED,
    @XmlEnumValue("Completed")
    COMPLETED,
    @XmlEnumValue("Rejected")
    REJECTED,
    @XmlEnumValue("Delayed")
    DELAYED,
    @XmlEnumValue("Canceled")
    CANCELED;
}