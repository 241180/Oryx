package com.oryx.remote.webservice.element.model.bu.sale;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlProductCategory complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlProductCategory">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="categoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlProductCategory", propOrder = {
        "categoryCode",
        "categoryName",
        "descriptionTextArea"
})
public class XmlProductCategory
        extends XmlCancelableAndTracable {

    protected String categoryCode;
    protected String categoryName;
    protected String descriptionTextArea;

    /**
     * Obtient la valeur de la propriété categoryCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Définit la valeur de la propriété categoryCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
    }

    /**
     * Obtient la valeur de la propriété categoryName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Définit la valeur de la propriété categoryName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCategoryName(String value) {
        this.categoryName = value;
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
