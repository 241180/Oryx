package com.oryx.remote.webservice.element.operation;

import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour XmlOperationDescIn complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlOperationDescIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://operation.element.webservice.remote.oryx.com}AbstractXmlServiceRequestDesc">
 *       &lt;sequence>
 *         &lt;element name="objectType" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumObjectType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlOperationDescIn", propOrder = {
        "objectType"
})
public class XmlOperationDescIn
        extends AbstractXmlServiceRequestDesc {

    @XmlSchemaType(name = "string")
    protected XmlEnumObjectType objectType;

    /**
     * Obtient la valeur de la propriété objectType.
     *
     * @return possible object is
     * {@link XmlEnumObjectType }
     */
    public XmlEnumObjectType getObjectType() {
        return objectType;
    }

    /**
     * Définit la valeur de la propriété objectType.
     *
     * @param value allowed object is
     *              {@link XmlEnumObjectType }
     */
    public void setObjectType(XmlEnumObjectType value) {
        this.objectType = value;
    }

}
