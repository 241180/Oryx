package com.oryx.remote.webservice.element.model.system.ref;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlAdress complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlAdress">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="country" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlCountry" minOccurs="0"/>
 *         &lt;element name="countryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlState" minOccurs="0"/>
 *         &lt;element name="stateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlAdress", propOrder = {
        "country",
        "countryId",
        "state",
        "stateId",
        "street",
        "latitude",
        "longitude"
})
public class XmlAdress
        extends XmlCancelableAndTracable {

    protected XmlCountry country;
    protected String countryId;
    protected XmlState state;
    protected String stateId;
    protected String street;
    protected double latitude;
    protected double longitude;

    /**
     * Obtient la valeur de la propriété country.
     *
     * @return possible object is
     * {@link XmlCountry }
     */
    public XmlCountry getCountry() {
        return country;
    }

    /**
     * Définit la valeur de la propriété country.
     *
     * @param value allowed object is
     *              {@link XmlCountry }
     */
    public void setCountry(XmlCountry value) {
        this.country = value;
    }

    /**
     * Obtient la valeur de la propriété countryId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * Définit la valeur de la propriété countryId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountryId(String value) {
        this.countryId = value;
    }

    /**
     * Obtient la valeur de la propriété state.
     *
     * @return possible object is
     * {@link XmlState }
     */
    public XmlState getState() {
        return state;
    }

    /**
     * Définit la valeur de la propriété state.
     *
     * @param value allowed object is
     *              {@link XmlState }
     */
    public void setState(XmlState value) {
        this.state = value;
    }

    /**
     * Obtient la valeur de la propriété stateId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStateId() {
        return stateId;
    }

    /**
     * Définit la valeur de la propriété stateId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStateId(String value) {
        this.stateId = value;
    }

    /**
     * Obtient la valeur de la propriété street.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStreet() {
        return street;
    }

    /**
     * Définit la valeur de la propriété street.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Obtient la valeur de la propriété latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Définit la valeur de la propriété latitude.
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Obtient la valeur de la propriété longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Définit la valeur de la propriété longitude.
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

}
