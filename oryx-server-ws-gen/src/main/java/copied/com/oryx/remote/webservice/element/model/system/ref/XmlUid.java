package com.oryx.remote.webservice.element.model.system.ref;

import com.oryx.remote.webservice.element._enum.XmlEnumUID;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlUid complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlUid">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="uidType" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumUID" minOccurs="0"/>
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlUid", propOrder = {
        "uidType",
        "uid"
})
public class XmlUid
        extends XmlCancelableAndTracable {

    @XmlSchemaType(name = "string")
    protected XmlEnumUID uidType;
    protected String uid;

    /**
     * Obtient la valeur de la propriété uidType.
     *
     * @return possible object is
     * {@link XmlEnumUID }
     */
    public XmlEnumUID getUidType() {
        return uidType;
    }

    /**
     * Définit la valeur de la propriété uidType.
     *
     * @param value allowed object is
     *              {@link XmlEnumUID }
     */
    public void setUidType(XmlEnumUID value) {
        this.uidType = value;
    }

    /**
     * Obtient la valeur de la propriété uid.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUid() {
        return uid;
    }

    /**
     * Définit la valeur de la propriété uid.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUid(String value) {
        this.uid = value;
    }

}
