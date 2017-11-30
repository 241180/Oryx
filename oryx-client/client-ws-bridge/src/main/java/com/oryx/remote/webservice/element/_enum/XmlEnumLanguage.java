package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumLanguage.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumLanguage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ENG"/>
 *     &lt;enumeration value="ITA"/>
 *     &lt;enumeration value="ARA"/>
 *     &lt;enumeration value="SPA"/>
 *     &lt;enumeration value="FRA"/>
 *     &lt;enumeration value="DEU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumLanguage", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumLanguage {

    ENG,
    ITA,
    ARA,
    SPA,
    FRA,
    DEU;

    public static XmlEnumLanguage fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
