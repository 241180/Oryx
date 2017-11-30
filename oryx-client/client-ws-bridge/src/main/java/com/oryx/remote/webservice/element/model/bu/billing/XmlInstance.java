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
 * <p>Classe Java pour XmlInstance complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlInstance">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="instanceDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlInstance", propOrder = {
        "instanceDateTime"
})
public class XmlInstance
        extends XmlCancelableAndTracable {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar instanceDateTime;

    /**
     * Obtient la valeur de la propriété instanceDateTime.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getInstanceDateTime() {
        return instanceDateTime;
    }

    /**
     * Définit la valeur de la propriété instanceDateTime.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setInstanceDateTime(XMLGregorianCalendar value) {
        this.instanceDateTime = value;
    }

}
