package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumBillStatus.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumBillStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Canceled"/>
 *     &lt;enumeration value="Blocked"/>
 *     &lt;enumeration value="OutDated"/>
 *     &lt;enumeration value="Calculated"/>
 *     &lt;enumeration value="Issued"/>
 *     &lt;enumeration value="Paid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumBillStatus", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumBillStatus {

    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),
    @XmlEnumValue("Blocked")
    BLOCKED("Blocked"),
    @XmlEnumValue("OutDated")
    OUT_DATED("OutDated"),
    @XmlEnumValue("Calculated")
    CALCULATED("Calculated"),
    @XmlEnumValue("Issued")
    ISSUED("Issued"),
    @XmlEnumValue("Paid")
    PAID("Paid");
    private final String value;

    XmlEnumBillStatus(String v) {
        value = v;
    }

    public static XmlEnumBillStatus fromValue(String v) {
        for (XmlEnumBillStatus c : XmlEnumBillStatus.values()) {
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
