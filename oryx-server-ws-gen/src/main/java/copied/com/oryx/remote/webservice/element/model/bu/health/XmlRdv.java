package com.oryx.remote.webservice.element.model.bu.health;

import com.oryx.remote.webservice.element._enum.XmlEnumRdvStatus;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlRdv complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlRdv">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="rdvDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="status" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumRdvStatus" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="host" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlPerson" minOccurs="0"/>
 *         &lt;element name="hostId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guest" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlPerson" minOccurs="0"/>
 *         &lt;element name="guestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlRdv", propOrder = {
        "rdvDateTime",
        "duration",
        "status",
        "reason",
        "host",
        "hostId",
        "guest",
        "guestId"
})
public class XmlRdv
        extends XmlCancelableAndTracable {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rdvDateTime;
    protected Integer duration;
    @XmlSchemaType(name = "string")
    protected XmlEnumRdvStatus status;
    protected String reason;
    protected XmlPerson host;
    protected String hostId;
    protected XmlPerson guest;
    protected String guestId;

    /**
     * Obtient la valeur de la propriété rdvDateTime.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getRdvDateTime() {
        return rdvDateTime;
    }

    /**
     * Définit la valeur de la propriété rdvDateTime.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setRdvDateTime(XMLGregorianCalendar value) {
        this.rdvDateTime = value;
    }

    /**
     * Obtient la valeur de la propriété duration.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Définit la valeur de la propriété duration.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDuration(Integer value) {
        this.duration = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     *
     * @return possible object is
     * {@link XmlEnumRdvStatus }
     */
    public XmlEnumRdvStatus getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     *
     * @param value allowed object is
     *              {@link XmlEnumRdvStatus }
     */
    public void setStatus(XmlEnumRdvStatus value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriété reason.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReason() {
        return reason;
    }

    /**
     * Définit la valeur de la propriété reason.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Obtient la valeur de la propriété host.
     *
     * @return possible object is
     * {@link XmlPerson }
     */
    public XmlPerson getHost() {
        return host;
    }

    /**
     * Définit la valeur de la propriété host.
     *
     * @param value allowed object is
     *              {@link XmlPerson }
     */
    public void setHost(XmlPerson value) {
        this.host = value;
    }

    /**
     * Obtient la valeur de la propriété hostId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHostId() {
        return hostId;
    }

    /**
     * Définit la valeur de la propriété hostId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHostId(String value) {
        this.hostId = value;
    }

    /**
     * Obtient la valeur de la propriété guest.
     *
     * @return possible object is
     * {@link XmlPerson }
     */
    public XmlPerson getGuest() {
        return guest;
    }

    /**
     * Définit la valeur de la propriété guest.
     *
     * @param value allowed object is
     *              {@link XmlPerson }
     */
    public void setGuest(XmlPerson value) {
        this.guest = value;
    }

    /**
     * Obtient la valeur de la propriété guestId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * Définit la valeur de la propriété guestId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGuestId(String value) {
        this.guestId = value;
    }

}
