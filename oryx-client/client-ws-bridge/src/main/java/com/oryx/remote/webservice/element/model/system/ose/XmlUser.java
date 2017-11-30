package com.oryx.remote.webservice.element.model.system.ose;

import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element._enum.XmlEnumUserRole;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlUser complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="userCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="language" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumLanguage" minOccurs="0"/>
 *         &lt;element name="lastConnection" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="role" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumUserRole" minOccurs="0"/>
 *         &lt;element name="status" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumStatus" minOccurs="0"/>
 *         &lt;element name="person" type="{http://ref.system.model.element.webservice.remote.oryx.com}XmlPerson" minOccurs="0"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleSet" type="{http://ose.system.model.element.webservice.remote.oryx.com}XmlRoleInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="roleIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlUser", propOrder = {
        "userCode",
        "email",
        "userLogin",
        "userPassword",
        "startDate",
        "endDate",
        "language",
        "lastConnection",
        "role",
        "status",
        "person",
        "personId",
        "roleSet",
        "roleIds"
})
public class XmlUser
        extends XmlCancelableAndTracable {

    protected String userCode;
    protected String email;
    protected String userLogin;
    protected String userPassword;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlSchemaType(name = "string")
    protected XmlEnumLanguage language;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastConnection;
    @XmlSchemaType(name = "string")
    protected XmlEnumUserRole role;
    @XmlSchemaType(name = "string")
    protected XmlEnumStatus status;
    protected XmlPerson person;
    protected String personId;
    @XmlElement(nillable = true)
    protected List<XmlRoleInfo> roleSet;
    @XmlElement(nillable = true)
    protected List<String> roleIds;

    /**
     * Obtient la valeur de la propriété userCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * Définit la valeur de la propriété userCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserCode(String value) {
        this.userCode = value;
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
     * Obtient la valeur de la propriété userLogin.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * Définit la valeur de la propriété userLogin.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserLogin(String value) {
        this.userLogin = value;
    }

    /**
     * Obtient la valeur de la propriété userPassword.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Définit la valeur de la propriété userPassword.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * Obtient la valeur de la propriété startDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Définit la valeur de la propriété startDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Obtient la valeur de la propriété endDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Définit la valeur de la propriété endDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
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
     * Obtient la valeur de la propriété lastConnection.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLastConnection() {
        return lastConnection;
    }

    /**
     * Définit la valeur de la propriété lastConnection.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLastConnection(XMLGregorianCalendar value) {
        this.lastConnection = value;
    }

    /**
     * Obtient la valeur de la propriété role.
     *
     * @return possible object is
     * {@link XmlEnumUserRole }
     */
    public XmlEnumUserRole getRole() {
        return role;
    }

    /**
     * Définit la valeur de la propriété role.
     *
     * @param value allowed object is
     *              {@link XmlEnumUserRole }
     */
    public void setRole(XmlEnumUserRole value) {
        this.role = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     *
     * @return possible object is
     * {@link XmlEnumStatus }
     */
    public XmlEnumStatus getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     *
     * @param value allowed object is
     *              {@link XmlEnumStatus }
     */
    public void setStatus(XmlEnumStatus value) {
        this.status = value;
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
     * Gets the value of the roleSet property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleSet property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleSet().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlRoleInfo }
     */
    public List<XmlRoleInfo> getRoleSet() {
        if (roleSet == null) {
            roleSet = new ArrayList<XmlRoleInfo>();
        }
        return this.roleSet;
    }

    /**
     * Gets the value of the roleIds property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleIds property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleIds().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getRoleIds() {
        if (roleIds == null) {
            roleIds = new ArrayList<String>();
        }
        return this.roleIds;
    }

}
