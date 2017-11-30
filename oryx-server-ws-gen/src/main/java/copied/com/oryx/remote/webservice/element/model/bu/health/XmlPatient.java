package com.oryx.remote.webservice.element.model.bu.health;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlPatient complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlPatient">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="patientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="person" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlPerson" minOccurs="0"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlPatient", propOrder = {
        "patientCode",
        "email",
        "person",
        "personId"
})
public class XmlPatient
        extends XmlCancelableAndTracable {

    protected String patientCode;
    protected String email;
    protected XmlPerson person;
    protected String personId;

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

    /**
     * Obtient la valeur de la propriété person.
     *
     * @return possible object is
     * {@link XmlPerson }
     */
    public XmlPerson getPerson() {
        return person;
    }

    /**
     * Définit la valeur de la propriété person.
     *
     * @param value allowed object is
     *              {@link XmlPerson }
     */
    public void setPerson(XmlPerson value) {
        this.person = value;
    }

    /**
     * Obtient la valeur de la propriété personId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * Définit la valeur de la propriété personId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPersonId(String value) {
        this.personId = value;
    }

}
