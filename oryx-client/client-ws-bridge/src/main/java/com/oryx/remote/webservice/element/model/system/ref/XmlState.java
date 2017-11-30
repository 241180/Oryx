package com.oryx.remote.webservice.element.model.system.ref;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlState complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlState">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlCountry" minOccurs="0"/>
 *         &lt;element name="countryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="altitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlState", propOrder = {
        "name",
        "countryName",
        "country",
        "countryId",
        "postalCode",
        "latitude",
        "longitude",
        "altitude"
})
public class XmlState
        extends XmlCancelableAndTracable {

    protected String name;
    protected String countryName;
    protected XmlCountry country;
    protected String countryId;
    protected String postalCode;
    protected Double latitude;
    protected Double longitude;
    protected Double altitude;

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
     * Obtient la valeur de la propriété countryName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Définit la valeur de la propriété countryName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

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
     * Obtient la valeur de la propriété postalCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Définit la valeur de la propriété postalCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Obtient la valeur de la propriété latitude.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Définit la valeur de la propriété latitude.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Obtient la valeur de la propriété longitude.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Définit la valeur de la propriété longitude.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Obtient la valeur de la propriété altitude.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * Définit la valeur de la propriété altitude.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setAltitude(Double value) {
        this.altitude = value;
    }

}
