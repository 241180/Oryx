package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumServiceOperation.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumServiceOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FETCH_BY_CRITERIA"/>
 *     &lt;enumeration value="FETCH_BY_ID"/>
 *     &lt;enumeration value="FETCH_ALL"/>
 *     &lt;enumeration value="UPDATE"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="CREATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumServiceOperation", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumServiceOperation {

    FETCH_BY_CRITERIA,
    FETCH_BY_ID,
    FETCH_ALL,
    UPDATE,
    DELETE,
    CREATE;

    public static XmlEnumServiceOperation fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
