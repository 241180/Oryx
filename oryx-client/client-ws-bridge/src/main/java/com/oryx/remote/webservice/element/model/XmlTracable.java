package com.oryx.remote.webservice.element.model;

import com.oryx.remote.webservice.element.model.system.ose.XmlUpgrades;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour XmlTracable complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlTracable">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlDomainCapable">
 *       &lt;sequence>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlTracable", propOrder = {
        "createdBy",
        "creationDate",
        "updatedBy",
        "lastUpdateDate"
})
@XmlSeeAlso({
        XmlUpgrades.class,
        XmlCancelableAndTracable.class
})
public abstract class XmlTracable
        extends XmlDomainCapable {

    protected String createdBy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    protected String updatedBy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;

    /**
     * Obtient la valeur de la propriété createdBy.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Définit la valeur de la propriété createdBy.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Obtient la valeur de la propriété creationDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Définit la valeur de la propriété creationDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Obtient la valeur de la propriété updatedBy.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Définit la valeur de la propriété updatedBy.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUpdatedBy(String value) {
        this.updatedBy = value;
    }

    /**
     * Obtient la valeur de la propriété lastUpdateDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Définit la valeur de la propriété lastUpdateDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

}
