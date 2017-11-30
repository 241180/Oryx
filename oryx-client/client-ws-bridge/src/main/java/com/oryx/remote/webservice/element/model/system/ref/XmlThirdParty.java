package com.oryx.remote.webservice.element.model.system.ref;

import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlThirdParty complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlThirdParty">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumLanguage" minOccurs="0"/>
 *         &lt;element name="defaultPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adressSet" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlAdress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adressIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contactSet" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlContact" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contactIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlThirdParty", propOrder = {
        "name",
        "reference",
        "descriptionTextArea",
        "language",
        "defaultPhoneNumber",
        "adressSet",
        "adressIds",
        "contactSet",
        "contactIds"
})
public class XmlThirdParty
        extends XmlCancelableAndTracable {

    protected String name;
    protected String reference;
    protected String descriptionTextArea;
    @XmlSchemaType(name = "string")
    protected XmlEnumLanguage language;
    protected String defaultPhoneNumber;
    @XmlElement(nillable = true)
    protected List<XmlAdress> adressSet;
    @XmlElement(nillable = true)
    protected List<String> adressIds;
    @XmlElement(nillable = true)
    protected List<XmlContact> contactSet;
    @XmlElement(nillable = true)
    protected List<String> contactIds;

    /**
     * Obtient la valeur de la propriété name.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
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
     * Obtient la valeur de la propriété language.
     *
     * @return possible object is
     * {@link XmlEnumLanguage }
     */
    public XmlEnumLanguage getLanguage() {
        return language;
    }

    /**
     * Définit la valeur de la propriété language.
     *
     * @param value allowed object is
     *              {@link XmlEnumLanguage }
     */
    public void setLanguage(XmlEnumLanguage value) {
        this.language = value;
    }

    /**
     * Obtient la valeur de la propriété defaultPhoneNumber.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDefaultPhoneNumber() {
        return defaultPhoneNumber;
    }

    /**
     * Définit la valeur de la propriété defaultPhoneNumber.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDefaultPhoneNumber(String value) {
        this.defaultPhoneNumber = value;
    }

    /**
     * Gets the value of the adressSet property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adressSet property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdressSet().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlAdress }
     */
    public List<XmlAdress> getAdressSet() {
        if (adressSet == null) {
            adressSet = new ArrayList<XmlAdress>();
        }
        return this.adressSet;
    }

    /**
     * Gets the value of the adressIds property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adressIds property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdressIds().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getAdressIds() {
        if (adressIds == null) {
            adressIds = new ArrayList<String>();
        }
        return this.adressIds;
    }

    /**
     * Gets the value of the contactSet property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactSet property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactSet().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlContact }
     */
    public List<XmlContact> getContactSet() {
        if (contactSet == null) {
            contactSet = new ArrayList<XmlContact>();
        }
        return this.contactSet;
    }

    /**
     * Gets the value of the contactIds property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactIds property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactIds().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getContactIds() {
        if (contactIds == null) {
            contactIds = new ArrayList<String>();
        }
        return this.contactIds;
    }

}
