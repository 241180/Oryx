package com.oryx.remote.webservice.element.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlDomainCapable complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlDomainCapable">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlIdentifiable">
 *       &lt;sequence>
 *         &lt;element name="domainScope" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlDomainCapable", propOrder = {
        "domainScope"
})
@XmlSeeAlso({
        XmlTracable.class
})
public abstract class XmlDomainCapable
        extends XmlIdentifiable {

    protected String domainScope;

    /**
     * Obtient la valeur de la propriété domainScope.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDomainScope() {
        return domainScope;
    }

    /**
     * Définit la valeur de la propriété domainScope.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDomainScope(String value) {
        this.domainScope = value;
    }

}
