package com.oryx.core.enums;

import javax.xml.bind.annotation.*;

/**
 * Created by SAMI on 25/02/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlEnumLanguage", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum EnumLanguage {
    @XmlEnumValue("FRA")
    FRA,
    @XmlEnumValue("ENG")
    ENG,
    @XmlEnumValue("ITA")
    ITA,
    @XmlEnumValue("SPA")
    SPA,
    @XmlEnumValue("ARA")
    ARA,
    @XmlEnumValue("DEU")
    DEU //...
}
