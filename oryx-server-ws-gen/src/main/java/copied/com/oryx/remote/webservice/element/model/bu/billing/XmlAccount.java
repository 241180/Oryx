package com.oryx.remote.webservice.element.model.bu.billing;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlAccount complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlAccount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="accountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deactivationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ammount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlAccount", propOrder = {
        "accountCode",
        "activationDate",
        "deactivationDate",
        "ammount"
})
public class XmlAccount
        extends XmlCancelableAndTracable {

    protected String accountCode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activationDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deactivationDate;
    protected Double ammount;

    /**
     * Obtient la valeur de la propriété accountCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * Définit la valeur de la propriété accountCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountCode(String value) {
        this.accountCode = value;
    }

    /**
     * Obtient la valeur de la propriété activationDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getActivationDate() {
        return activationDate;
    }

    /**
     * Définit la valeur de la propriété activationDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setActivationDate(XMLGregorianCalendar value) {
        this.activationDate = value;
    }

    /**
     * Obtient la valeur de la propriété deactivationDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDeactivationDate() {
        return deactivationDate;
    }

    /**
     * Définit la valeur de la propriété deactivationDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDeactivationDate(XMLGregorianCalendar value) {
        this.deactivationDate = value;
    }

    /**
     * Obtient la valeur de la propriété ammount.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getAmmount() {
        return ammount;
    }

    /**
     * Définit la valeur de la propriété ammount.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setAmmount(Double value) {
        this.ammount = value;
    }

}
