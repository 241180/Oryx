package com.oryx.remote.webservice.element.model.bu.health;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlHealthCheck complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlHealthCheck">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="healthCheckDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlHealthCheck", propOrder = {
        "healthCheckDateTime"
})
public class XmlHealthCheck
        extends XmlCancelableAndTracable {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar healthCheckDateTime;

    /**
     * Obtient la valeur de la propriété healthCheckDateTime.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getHealthCheckDateTime() {
        return healthCheckDateTime;
    }

    /**
     * Définit la valeur de la propriété healthCheckDateTime.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setHealthCheckDateTime(XMLGregorianCalendar value) {
        this.healthCheckDateTime = value;
    }

}
