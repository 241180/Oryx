package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumContact.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumContact">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Phone"/>
 *     &lt;enumeration value="Mobile"/>
 *     &lt;enumeration value="Fax"/>
 *     &lt;enumeration value="Web"/>
 *     &lt;enumeration value="Email"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumContact", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumContact {

    @XmlEnumValue("Phone")
    PHONE("Phone"),
    @XmlEnumValue("Mobile")
    MOBILE("Mobile"),
    @XmlEnumValue("Fax")
    FAX("Fax"),
    @XmlEnumValue("Web")
    WEB("Web"),
    @XmlEnumValue("Email")
    EMAIL("Email");
    private final String value;

    XmlEnumContact(String v) {
        value = v;
    }

    public static XmlEnumContact fromValue(String v) {
        for (XmlEnumContact c : XmlEnumContact.values()) {
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
