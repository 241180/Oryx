package com.oryx.remote.webservice.element.view.bu.health;

import com.oryx.remote.webservice.element.model.system.ref.XmlCountry;
import com.oryx.remote.webservice.element.model.system.ref.XmlState;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlPatientView complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlPatientView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="patientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultUid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="birthCity" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlState" minOccurs="0"/>
 *         &lt;element name="birthCityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthCountry" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlCountry" minOccurs="0"/>
 *         &lt;element name="birthCountryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adressStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adressCity" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlState" minOccurs="0"/>
 *         &lt;element name="adressCityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adressCountry" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlCountry" minOccurs="0"/>
 *         &lt;element name="adressCountryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNumber_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNumber_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlPatientView", propOrder = {
        "patientCode",
        "defaultUid",
        "firstName",
        "lastName",
        "birthDate",
        "birthCity",
        "birthCityId",
        "birthCountry",
        "birthCountryId",
        "adressStreet",
        "adressCity",
        "adressCityId",
        "adressCountry",
        "adressCountryId",
        "phoneNumber1",
        "phoneNumber2",
        "email"
})
public class XmlPatientView {

    protected String patientCode;
    protected String defaultUid;
    protected String firstName;
    protected String lastName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthDate;
    protected XmlState birthCity;
    protected String birthCityId;
    protected XmlCountry birthCountry;
    protected String birthCountryId;
    protected String adressStreet;
    protected XmlState adressCity;
    protected String adressCityId;
    protected XmlCountry adressCountry;
    protected String adressCountryId;
    @XmlElement(name = "phoneNumber_1")
    protected String phoneNumber1;
    @XmlElement(name = "phoneNumber_2")
    protected String phoneNumber2;
    protected String email;

    /**
     * Obtient la valeur de la propriété patientCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPatientCode() {
        return patientCode;
    }

    /**
     * Définit la valeur de la propriété patientCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPatientCode(String value) {
        this.patientCode = value;
    }

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
     * Obtient la valeur de la propriété birthCity.
     *
     * @return possible object is
     * {@link XmlState }
     */
    public XmlState getBirthCity() {
        return birthCity;
    }

    /**
     * Définit la valeur de la propriété birthCity.
     *
     * @param value allowed object is
     *              {@link XmlState }
     */
    public void setBirthCity(XmlState value) {
        this.birthCity = value;
    }

    /**
     * Obtient la valeur de la propriété birthCityId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBirthCityId() {
        return birthCityId;
    }

    /**
     * Définit la valeur de la propriété birthCityId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBirthCityId(String value) {
        this.birthCityId = value;
    }

    /**
     * Obtient la valeur de la propriété birthCountry.
     *
     * @return possible object is
     * {@link XmlCountry }
     */
    public XmlCountry getBirthCountry() {
        return birthCountry;
    }

    /**
     * Définit la valeur de la propriété birthCountry.
     *
     * @param value allowed object is
     *              {@link XmlCountry }
     */
    public void setBirthCountry(XmlCountry value) {
        this.birthCountry = value;
    }

    /**
     * Obtient la valeur de la propriété birthCountryId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBirthCountryId() {
        return birthCountryId;
    }

    /**
     * Définit la valeur de la propriété birthCountryId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBirthCountryId(String value) {
        this.birthCountryId = value;
    }

    /**
     * Obtient la valeur de la propriété adressStreet.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAdressStreet() {
        return adressStreet;
    }

    /**
     * Définit la valeur de la propriété adressStreet.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAdressStreet(String value) {
        this.adressStreet = value;
    }

    /**
     * Obtient la valeur de la propriété adressCity.
     *
     * @return possible object is
     * {@link XmlState }
     */
    public XmlState getAdressCity() {
        return adressCity;
    }

    /**
     * Définit la valeur de la propriété adressCity.
     *
     * @param value allowed object is
     *              {@link XmlState }
     */
    public void setAdressCity(XmlState value) {
        this.adressCity = value;
    }

    /**
     * Obtient la valeur de la propriété adressCityId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAdressCityId() {
        return adressCityId;
    }

    /**
     * Définit la valeur de la propriété adressCityId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAdressCityId(String value) {
        this.adressCityId = value;
    }

    /**
     * Obtient la valeur de la propriété adressCountry.
     *
     * @return possible object is
     * {@link XmlCountry }
     */
    public XmlCountry getAdressCountry() {
        return adressCountry;
    }

    /**
     * Définit la valeur de la propriété adressCountry.
     *
     * @param value allowed object is
     *              {@link XmlCountry }
     */
    public void setAdressCountry(XmlCountry value) {
        this.adressCountry = value;
    }

    /**
     * Obtient la valeur de la propriété adressCountryId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAdressCountryId() {
        return adressCountryId;
    }

    /**
     * Définit la valeur de la propriété adressCountryId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAdressCountryId(String value) {
        this.adressCountryId = value;
    }

    /**
     * Obtient la valeur de la propriété phoneNumber1.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    /**
     * Définit la valeur de la propriété phoneNumber1.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhoneNumber1(String value) {
        this.phoneNumber1 = value;
    }

    /**
     * Obtient la valeur de la propriété phoneNumber2.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    /**
     * Définit la valeur de la propriété phoneNumber2.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhoneNumber2(String value) {
        this.phoneNumber2 = value;
    }

    /**
     * Obtient la valeur de la propriété email.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit la valeur de la propriété email.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
