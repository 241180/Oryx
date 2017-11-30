package com.oryx.remote.webservices.service.authenticationservice;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java pour anonymous complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sessionToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "login",
        "password",
        "domainCode",
        "sessionToken"
})
@XmlRootElement(name = "authenticationRequest")
public class AuthenticationRequest {

    @XmlElement(required = true)
    protected String login;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String sessionToken;

    /**
     * Obtient la valeur de la propriété login.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLogin() {
        return login;
    }

    /**
     * Définit la valeur de la propriété login.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Obtient la valeur de la propriété password.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Définit la valeur de la propriété password.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtient la valeur de la propriété domainCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Définit la valeur de la propriété domainCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDomainCode(String value) {
        this.domainCode = value;
    }

    /**
     * Obtient la valeur de la propriété sessionToken.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSessionToken() {
        return sessionToken;
    }

    /**
     * Définit la valeur de la propriété sessionToken.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSessionToken(String value) {
        this.sessionToken = value;
    }

}
