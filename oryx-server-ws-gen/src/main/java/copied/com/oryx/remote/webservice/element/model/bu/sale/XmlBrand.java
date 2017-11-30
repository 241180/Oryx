package com.oryx.remote.webservice.element.model.bu.sale;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlBrand complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlBrand">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="brandCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlBrand", propOrder = {
        "brandCode",
        "brandName",
        "descriptionTextArea"
})
public class XmlBrand
        extends XmlCancelableAndTracable {

    protected String brandCode;
    protected String brandName;
    protected String descriptionTextArea;

    /**
     * Obtient la valeur de la propriété brandCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * Définit la valeur de la propriété brandCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrandCode(String value) {
        this.brandCode = value;
    }

    /**
     * Obtient la valeur de la propriété brandName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Définit la valeur de la propriété brandName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrandName(String value) {
        this.brandName = value;
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

}
