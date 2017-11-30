package com.oryx.remote.webservices.service.authenticationservice;

import com.oryx.remote.webservice.element.model.system.ose.XmlUser;

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
 *         &lt;element name="user" type="{http://ose.system.model.element.webservice.remote.oryx.com}XmlUser"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "user"
})
@XmlRootElement(name = "authenticationResponse")
public class AuthenticationResponse {

    @XmlElement(required = true)
    protected XmlUser user;

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

}
