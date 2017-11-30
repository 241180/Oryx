package com.oryx.remote.webservices.service.instanceservice;

import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;
import com.oryx.remote.webservice.element.operation.XmlAuthentification;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="auth" type="{http://operation.element.webservice.remote.oryx.com}XmlAuthentification"/>
 *         &lt;element name="request" type="{http://operation.element.webservice.remote.oryx.com}XmlOperationDescIn"/>
 *         &lt;element name="Object" type="{http://billing.bu.model.element.webservice.remote.oryx.com}XmlInstance" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "auth",
        "request",
        "object"
})
@XmlRootElement(name = "crudRequest")
public class CrudRequest {

    @XmlElement(required = true)
    protected XmlAuthentification auth;
    @XmlElement(required = true)
    protected XmlOperationDescIn request;
    @XmlElement(name = "Object")
    protected List<XmlInstance> object;

    /**
     * Obtient la valeur de la propriété auth.
     *
     * @return possible object is
     * {@link XmlAuthentification }
     */
    public XmlAuthentification getAuth() {
        return auth;
    }

    /**
     * Définit la valeur de la propriété auth.
     *
     * @param value allowed object is
     *              {@link XmlAuthentification }
     */
    public void setAuth(XmlAuthentification value) {
        this.auth = value;
    }

    /**
     * Obtient la valeur de la propriété request.
     *
     * @return possible object is
     * {@link XmlOperationDescIn }
     */
    public XmlOperationDescIn getRequest() {
        return request;
    }

    /**
     * Définit la valeur de la propriété request.
     *
     * @param value allowed object is
     *              {@link XmlOperationDescIn }
     */
    public void setRequest(XmlOperationDescIn value) {
        this.request = value;
    }

    /**
     * Gets the value of the object property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the object property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObject().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlInstance }
     */
    public List<XmlInstance> getObject() {
        if (object == null) {
            object = new ArrayList<XmlInstance>();
        }
        return this.object;
    }

}
