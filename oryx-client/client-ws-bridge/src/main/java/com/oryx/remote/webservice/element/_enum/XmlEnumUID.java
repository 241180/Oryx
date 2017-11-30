package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumUID.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumUID">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PSPT"/>
 *     &lt;enumeration value="NIDC"/>
 *     &lt;enumeration value="SECU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumUID", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumUID {

    PSPT,
    NIDC,
    SECU;

    public static XmlEnumUID fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
