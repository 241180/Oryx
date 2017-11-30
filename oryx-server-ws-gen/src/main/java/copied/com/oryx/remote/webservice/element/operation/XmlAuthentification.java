package com.oryx.remote.webservice.element.operation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlAuthentification complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlAuthentification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accesskey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlAuthentification", propOrder = {
        "accesskey",
        "domainCode"
})
public class XmlAuthentification {

    protected String accesskey;
    protected String domainCode;

    /**
     * Obtient la valeur de la propriété accesskey.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccesskey() {
        return accesskey;
    }

    /**
     * Définit la valeur de la propriété accesskey.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccesskey(String value) {
        this.accesskey = value;
    }

    /**
     * Obtient la valeur de la propriété domainCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Définit la valeur de la propriété domainCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDomainCode(String value) {
        this.domainCode = value;
    }

}
