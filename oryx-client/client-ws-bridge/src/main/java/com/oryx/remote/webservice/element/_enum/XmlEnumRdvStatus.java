package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumRdvStatus.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumRdvStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Canceled"/>
 *     &lt;enumeration value="Planned"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Delayed"/>
 *     &lt;enumeration value="Accepted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumRdvStatus", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumRdvStatus {

    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),
    @XmlEnumValue("Planned")
    PLANNED("Planned"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    @XmlEnumValue("Delayed")
    DELAYED("Delayed"),
    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted");
    private final String value;

    XmlEnumRdvStatus(String v) {
        value = v;
    }

    public static XmlEnumRdvStatus fromValue(String v) {
        for (XmlEnumRdvStatus c : XmlEnumRdvStatus.values()) {
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
