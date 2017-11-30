package com.oryx.remote.webservice.element._enum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlEnumObjectType.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XmlEnumObjectType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FIELDPROCESSPARAM"/>
 *     &lt;enumeration value="CODIFICATION"/>
 *     &lt;enumeration value="PRODUCTCATEGORY"/>
 *     &lt;enumeration value="RDV"/>
 *     &lt;enumeration value="PERSON"/>
 *     &lt;enumeration value="ANNEX"/>
 *     &lt;enumeration value="THIRDPARTY"/>
 *     &lt;enumeration value="MENU"/>
 *     &lt;enumeration value="BILLITEM"/>
 *     &lt;enumeration value="BILL"/>
 *     &lt;enumeration value="CART"/>
 *     &lt;enumeration value="USER"/>
 *     &lt;enumeration value="CONTACT"/>
 *     &lt;enumeration value="ROLEINFO"/>
 *     &lt;enumeration value="TASK"/>
 *     &lt;enumeration value="PATIENT"/>
 *     &lt;enumeration value="PARAMETER"/>
 *     &lt;enumeration value="CARTITEM"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *     &lt;enumeration value="TRANSLATION"/>
 *     &lt;enumeration value="ERRORMESSAGE"/>
 *     &lt;enumeration value="PRODUCT"/>
 *     &lt;enumeration value="COUNTRY"/>
 *     &lt;enumeration value="UID"/>
 *     &lt;enumeration value="USERVIEW"/>
 *     &lt;enumeration value="BRAND"/>
 *     &lt;enumeration value="UPGRADES"/>
 *     &lt;enumeration value="STOCKPOSITION"/>
 *     &lt;enumeration value="STATE"/>
 *     &lt;enumeration value="ACCOUNT"/>
 *     &lt;enumeration value="INSTANCE"/>
 *     &lt;enumeration value="PATIENTVIEW"/>
 *     &lt;enumeration value="ADRESS"/>
 *     &lt;enumeration value="HEALTHCHECK"/>
 *     &lt;enumeration value="PRODUCTLOT"/>
 *     &lt;enumeration value="SHOPPER"/>
 *     &lt;enumeration value="DOMAIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "XmlEnumObjectType", namespace = "http://enum.element.webservice.remote.oryx.com")
@XmlEnum
public enum XmlEnumObjectType {

    FIELDPROCESSPARAM,
    CODIFICATION,
    PRODUCTCATEGORY,
    RDV,
    PERSON,
    ANNEX,
    THIRDPARTY,
    MENU,
    BILLITEM,
    BILL,
    CART,
    USER,
    CONTACT,
    ROLEINFO,
    TASK,
    PATIENT,
    PARAMETER,
    CARTITEM,
    UNKNOWN,
    TRANSLATION,
    ERRORMESSAGE,
    PRODUCT,
    COUNTRY,
    UID,
    USERVIEW,
    BRAND,
    UPGRADES,
    STOCKPOSITION,
    STATE,
    ACCOUNT,
    INSTANCE,
    PATIENTVIEW,
    ADRESS,
    HEALTHCHECK,
    PRODUCTLOT,
    SHOPPER,
    DOMAIN;

    public static XmlEnumObjectType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
