package com.oryx.remote.webservice.element.model.system.ref;

import com.oryx.remote.webservice.element._enum.XmlEnumContact;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlContact complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlContact">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="contactType" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumContact" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlContact", propOrder = {
        "contactType",
        "value"
})
public class XmlContact
        extends XmlCancelableAndTracable {

    @XmlSchemaType(name = "string")
    protected XmlEnumContact contactType;
    protected String value;

    /**
     * Obtient la valeur de la propriété contactType.
     *
     * @return possible object is
     * {@link XmlEnumContact }
     */
    public XmlEnumContact getContactType() {
        return contactType;
    }

    /**
     * Définit la valeur de la propriété contactType.
     *
     * @param value allowed object is
     *              {@link XmlEnumContact }
     */
    public void setContactType(XmlEnumContact value) {
        this.contactType = value;
    }

    /**
     * Obtient la valeur de la propriété value.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Définit la valeur de la propriété value.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

}
