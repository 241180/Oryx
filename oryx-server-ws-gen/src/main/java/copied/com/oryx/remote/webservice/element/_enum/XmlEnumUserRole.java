package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumUserRole.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumUserRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ROLE_USER"/>
 *     &lt;enumeration value="ROLE_ADMIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumUserRole", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumUserRole {

    ROLE_USER,
    ROLE_ADMIN;

    public static XmlEnumUserRole fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
