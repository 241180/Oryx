package com.oryx.remote.webservice.element.model.system.ose;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlDomain complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlDomain">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlDomain", propOrder = {
        "domainCode",
        "descriptionTextArea",
        "reference"
})
public class XmlDomain
        extends XmlCancelableAndTracable {

    protected String domainCode;
    protected String descriptionTextArea;
    protected String reference;

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

    /**
     * Obtient la valeur de la propriété descriptionTextArea.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescriptionTextArea() {
        return descriptionTextArea;
    }

    /**
     * Définit la valeur de la propriété descriptionTextArea.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescriptionTextArea(String value) {
        this.descriptionTextArea = value;
    }

    /**
     * Obtient la valeur de la propriété reference.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReference() {
        return reference;
    }

    /**
     * Définit la valeur de la propriété reference.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReference(String value) {
        this.reference = value;
    }

}
