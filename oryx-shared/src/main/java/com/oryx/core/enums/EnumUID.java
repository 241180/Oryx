package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumUID", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumUID {
    @XmlEnumValue("NationalIdentificationCard")
    NIDC,
    @XmlEnumValue("Passport")
    PSPT,
    @XmlEnumValue("CnssNumber")
    CNSS,
    @XmlEnumValue("CnrpsNumber")
    CNRPS,
    @XmlEnumValue("Other")
    OTHER
}
