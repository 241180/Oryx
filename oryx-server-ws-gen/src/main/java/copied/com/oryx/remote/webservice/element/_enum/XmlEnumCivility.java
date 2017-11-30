package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumCivility.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumCivility">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Single"/>
 *     &lt;enumeration value="Married"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumCivility", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumCivility {

    @XmlEnumValue("Single")
    SINGLE("Single"),
    @XmlEnumValue("Married")
    MARRIED("Married");
    private final String value;

    XmlEnumCivility(String v) {
        value = v;
    }

    public static XmlEnumCivility fromValue(String v) {
        for (XmlEnumCivility c : XmlEnumCivility.values()) {
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
