package com.oryx.remote.webservice.element.model.bu.sale;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlShopper complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlShopper">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="shopperCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="person" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlPerson" minOccurs="0"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user" type="{http://ose.system.model.element.webservice.remote.oryx.com}XmlUser" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlShopper", propOrder = {
        "shopperCode",
        "email",
        "person",
        "personId",
        "user",
        "userId"
})
public class XmlShopper
        extends XmlCancelableAndTracable {

    protected String shopperCode;
    protected String email;
    protected XmlPerson person;
    protected String personId;
    protected XmlUser user;
    protected String userId;

    /**
     * Obtient la valeur de la propriété shopperCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShopperCode() {
        return shopperCode;
    }

    /**
     * Définit la valeur de la propriété shopperCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShopperCode(String value) {
        this.shopperCode = value;
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

    /**
     * Obtient la valeur de la propriété user.
     *
     * @return possible object is
     * {@link XmlUser }
     */
    public XmlUser getUser() {
        return user;
    }

    /**
     * Définit la valeur de la propriété user.
     *
     * @param value allowed object is
     *              {@link XmlUser }
     */
    public void setUser(XmlUser value) {
        this.user = value;
    }

    /**
     * Obtient la valeur de la propriété userId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Définit la valeur de la propriété userId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
