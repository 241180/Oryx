package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumPermission.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumPermission">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Update"/>
 *     &lt;enumeration value="Create"/>
 *     &lt;enumeration value="Select"/>
 *     &lt;enumeration value="Delete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumPermission", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumPermission {

    @XmlEnumValue("Update")
    UPDATE("Update"),
    @XmlEnumValue("Create")
    CREATE("Create"),
    @XmlEnumValue("Select")
    SELECT("Select"),
    @XmlEnumValue("Delete")
    DELETE("Delete");
    private final String value;

    XmlEnumPermission(String v) {
        value = v;
    }

    public static XmlEnumPermission fromValue(String v) {
        for (XmlEnumPermission c : XmlEnumPermission.values()) {
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
