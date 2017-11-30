package com.oryx.remote.webservice.element.model.system.ref;

import com.oryx.remote.webservice.element._enum.XmlEnumCivility;
import com.oryx.remote.webservice.element._enum.XmlEnumGender;
import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlPerson complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlPerson">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="defaultUid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="civility" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumCivility" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumGender" minOccurs="0"/>
 *         &lt;element name="language" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumLanguage" minOccurs="0"/>
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="birthPlace" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlState" minOccurs="0"/>
 *         &lt;element name="birthPlaceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uidSet" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlUid" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="uidIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "XmlPerson", propOrder = {
        "defaultUid",
        "firstName",
        "lastName",
        "defaultPhoneNumber",
        "civility",
        "gender",
        "language",
        "birthDate",
        "birthPlace",
        "birthPlaceId",
        "uidSet",
        "uidIds",
        "adressSet",
        "adressIds",
        "contactSet",
        "contactIds"
})
public class XmlPerson
        extends XmlCancelableAndTracable {

    protected String defaultUid;
    protected String firstName;
    protected String lastName;
    protected String defaultPhoneNumber;
    @XmlSchemaType(name = "string")
    protected XmlEnumCivility civility;
    @XmlSchemaType(name = "string")
    protected XmlEnumGender gender;
    @XmlSchemaType(name = "string")
    protected XmlEnumLanguage language;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthDate;
    protected XmlState birthPlace;
    protected String birthPlaceId;
    @XmlElement(nillable = true)
    protected List<XmlUid> uidSet;
    @XmlElement(nillable = true)
    protected List<String> uidIds;
    @XmlElement(nillable = true)
    protected List<XmlAdress> adressSet;
    @XmlElement(nillable = true)
    protected List<String> adressIds;
    @XmlElement(nillable = true)
    protected List<XmlContact> contactSet;
    @XmlElement(nillable = true)
    protected List<String> contactIds;

    /**
     * Obtient la valeur de la propriété defaultUid.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDefaultUid() {
        return defaultUid;
    }

    /**
     * Définit la valeur de la propriété defaultUid.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDefaultUid(String value) {
        this.defaultUid = value;
    }

    /**
     * Obtient la valeur de la propriété firstName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Définit la valeur de la propriété firstName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Obtient la valeur de la propriété lastName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Définit la valeur de la propriété lastName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLastName(String value) {
        this.lastName = value;
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
     * Obtient la valeur de la propriété civility.
     *
     * @return possible object is
     * {@link XmlEnumCivility }
     */
    public XmlEnumCivility getCivility() {
        return civility;
    }

    /**
     * Définit la valeur de la propriété civility.
     *
     * @param value allowed object is
     *              {@link XmlEnumCivility }
     */
    public void setCivility(XmlEnumCivility value) {
        this.civility = value;
    }

    /**
     * Obtient la valeur de la propriété gender.
     *
     * @return possible object is
     * {@link XmlEnumGender }
     */
    public XmlEnumGender getGender() {
        return gender;
    }

    /**
     * Définit la valeur de la propriété gender.
     *
     * @param value allowed object is
     *              {@link XmlEnumGender }
     */
    public void setGender(XmlEnumGender value) {
        this.gender = value;
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
     * Obtient la valeur de la propriété birthDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Définit la valeur de la propriété birthDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Obtient la valeur de la propriété birthPlace.
     *
     * @return possible object is
     * {@link XmlState }
     */
    public XmlState getBirthPlace() {
        return birthPlace;
    }

    /**
     * Définit la valeur de la propriété birthPlace.
     *
     * @param value allowed object is
     *              {@link XmlState }
     */
    public void setBirthPlace(XmlState value) {
        this.birthPlace = value;
    }

    /**
     * Obtient la valeur de la propriété birthPlaceId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBirthPlaceId() {
        return birthPlaceId;
    }

    /**
     * Définit la valeur de la propriété birthPlaceId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBirthPlaceId(String value) {
        this.birthPlaceId = value;
    }

    /**
     * Gets the value of the uidSet property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uidSet property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUidSet().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlUid }
     */
    public List<XmlUid> getUidSet() {
        if (uidSet == null) {
            uidSet = new ArrayList<XmlUid>();
        }
        return this.uidSet;
    }

    /**
     * Gets the value of the uidIds property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uidIds property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUidIds().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getUidIds() {
        if (uidIds == null) {
            uidIds = new ArrayList<String>();
        }
        return this.uidIds;
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
