package com.oryx.remote.webservice.element.operation;

import com.oryx.remote.webservice.element._enum.XmlEnumServiceOperation;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java pour AbstractXmlServiceRequestDesc complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="AbstractXmlServiceRequestDesc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operation" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumServiceOperation" minOccurs="0"/>
 *         &lt;element name="msg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractXmlServiceRequestDesc", propOrder = {
        "operation",
        "msg"
})
@XmlSeeAlso({
        XmlOperationDescIn.class
})
public abstract class AbstractXmlServiceRequestDesc {

    @XmlSchemaType(name = "string")
    protected XmlEnumServiceOperation operation;
    protected String msg;

    /**
     * Obtient la valeur de la propriété operation.
     *
     * @return possible object is
     * {@link XmlEnumServiceOperation }
     */
    public XmlEnumServiceOperation getOperation() {
        return operation;
    }

    /**
     * Définit la valeur de la propriété operation.
     *
     * @param value allowed object is
     *              {@link XmlEnumServiceOperation }
     */
    public void setOperation(XmlEnumServiceOperation value) {
        this.operation = value;
    }

    /**
     * Obtient la valeur de la propriété msg.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Définit la valeur de la propriété msg.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMsg(String value) {
        this.msg = value;
    }

}
