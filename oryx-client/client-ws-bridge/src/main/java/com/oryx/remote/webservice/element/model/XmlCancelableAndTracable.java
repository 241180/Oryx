package com.oryx.remote.webservice.element.model;

import com.oryx.remote.webservice.element.model.system.ose.*;
import com.oryx.remote.webservice.element.model.system.ref.*;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour XmlCancelableAndTracable complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlCancelableAndTracable">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlTracable">
 *       &lt;sequence>
 *         &lt;element name="checkCancel" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canceledBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancelDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlCancelableAndTracable", propOrder = {
        "checkCancel",
        "canceledBy",
        "cancelDate"
})
@XmlSeeAlso({
        XmlPerson.class,
        XmlUid.class,
        XmlAdress.class,
        XmlContact.class,
        XmlState.class,
        XmlThirdParty.class,
        XmlCountry.class,
        XmlUser.class,
        XmlTask.class,
        XmlCodification.class,
        XmlRoleInfo.class,
        XmlDomain.class,
        XmlAnnex.class,
        XmlMenu.class,
        XmlFieldProcessParam.class,
        XmlParameter.class
})
public abstract class XmlCancelableAndTracable
        extends XmlTracable {

    protected Boolean checkCancel;
    protected String canceledBy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancelDate;

    /**
     * Obtient la valeur de la propriété checkCancel.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isCheckCancel() {
        return checkCancel;
    }

    /**
     * Définit la valeur de la propriété checkCancel.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setCheckCancel(Boolean value) {
        this.checkCancel = value;
    }

    /**
     * Obtient la valeur de la propriété canceledBy.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCanceledBy() {
        return canceledBy;
    }

    /**
     * Définit la valeur de la propriété canceledBy.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCanceledBy(String value) {
        this.canceledBy = value;
    }

    /**
     * Obtient la valeur de la propriété cancelDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCancelDate() {
        return cancelDate;
    }

    /**
     * Définit la valeur de la propriété cancelDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCancelDate(XMLGregorianCalendar value) {
        this.cancelDate = value;
    }

}
