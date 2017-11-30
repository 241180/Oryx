package com.oryx.remote.webservices.service.translationservice;

import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;

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
 *         &lt;element name="response" type="{http://operation.element.webservice.remote.oryx.com}XmlOperationDescOut"/>
 *         &lt;element name="Object" type="{http://msg.system.model.element.webservice.remote.oryx.com}XmlTranslation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "response",
        "object"
})
@XmlRootElement(name = "crudResponse")
public class CrudResponse {

    @XmlElement(required = true)
    protected XmlOperationDescOut response;
    @XmlElement(name = "Object")
    protected List<XmlTranslation> object;

    /**
     * Obtient la valeur de la propriété response.
     *
     * @return possible object is
     * {@link XmlOperationDescOut }
     */
    public XmlOperationDescOut getResponse() {
        return response;
    }

    /**
     * Définit la valeur de la propriété response.
     *
     * @param value allowed object is
     *              {@link XmlOperationDescOut }
     */
    public void setResponse(XmlOperationDescOut value) {
        this.response = value;
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
     * {@link XmlTranslation }
     */
    public List<XmlTranslation> getObject() {
        if (object == null) {
            object = new ArrayList<XmlTranslation>();
        }
        return this.object;
    }

}
