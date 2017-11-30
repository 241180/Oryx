package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumCartStatus.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumCartStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Calculated"/>
 *     &lt;enumeration value="Issued"/>
 *     &lt;enumeration value="Paid"/>
 *     &lt;enumeration value="Blocked"/>
 *     &lt;enumeration value="OutDated"/>
 *     &lt;enumeration value="Canceled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumCartStatus", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumCartStatus {

    @XmlEnumValue("Calculated")
    CALCULATED("Calculated"),
    @XmlEnumValue("Issued")
    ISSUED("Issued"),
    @XmlEnumValue("Paid")
    PAID("Paid"),
    @XmlEnumValue("Blocked")
    BLOCKED("Blocked"),
    @XmlEnumValue("OutDated")
    OUT_DATED("OutDated"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled");
    private final String value;

    XmlEnumCartStatus(String v) {
        value = v;
    }

    public static XmlEnumCartStatus fromValue(String v) {
        for (XmlEnumCartStatus c : XmlEnumCartStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

}
