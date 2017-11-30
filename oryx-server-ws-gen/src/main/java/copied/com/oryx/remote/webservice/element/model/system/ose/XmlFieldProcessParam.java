package com.oryx.remote.webservice.element.model.system.ose;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlFieldProcessParam complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlFieldProcessParam">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="processCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fieldCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlFieldProcessParam", propOrder = {
        "processCode",
        "fieldCode",
        "descriptionTextArea",
        "processRef",
        "processType",
        "processResult"
})
public class XmlFieldProcessParam
        extends XmlCancelableAndTracable {

    protected String processCode;
    protected String fieldCode;
    protected String descriptionTextArea;
    protected String processRef;
    protected String processType;
    protected String processResult;

    /**
     * Obtient la valeur de la propriété processCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProcessCode() {
        return processCode;
    }

    /**
     * Définit la valeur de la propriété processCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProcessCode(String value) {
        this.processCode = value;
    }

    /**
     * Obtient la valeur de la propriété fieldCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * Définit la valeur de la propriété fieldCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFieldCode(String value) {
        this.fieldCode = value;
    }

    /**
     * Obtient la valeur de la propriété descriptionTextArea.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescriptionTextArea() {
        return descriptionTextArea;
    }

    /**
     * Définit la valeur de la propriété descriptionTextArea.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescriptionTextArea(String value) {
        this.descriptionTextArea = value;
    }

    /**
     * Obtient la valeur de la propriété processRef.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProcessRef() {
        return processRef;
    }

    /**
     * Définit la valeur de la propriété processRef.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProcessRef(String value) {
        this.processRef = value;
    }

    /**
     * Obtient la valeur de la propriété processType.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProcessType() {
        return processType;
    }

    /**
     * Définit la valeur de la propriété processType.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProcessType(String value) {
        this.processType = value;
    }

    /**
     * Obtient la valeur de la propriété processResult.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProcessResult() {
        return processResult;
    }

    /**
     * Définit la valeur de la propriété processResult.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProcessResult(String value) {
        this.processResult = value;
    }

}
