package com.oryx.remote.webservice.element.model.bu.sale;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlProduct complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlProduct">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://sale.bu.model.element.webservice.remote.oryx.com}XmlProductCategory" minOccurs="0"/>
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brand" type="{http://sale.bu.model.element.webservice.remote.oryx.com}XmlBrand" minOccurs="0"/>
 *         &lt;element name="brandId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlProduct", propOrder = {
        "productCode",
        "productName",
        "descriptionTextArea",
        "category",
        "categoryId",
        "brand",
        "brandId"
})
public class XmlProduct
        extends XmlCancelableAndTracable {

    protected String productCode;
    protected String productName;
    protected String descriptionTextArea;
    protected XmlProductCategory category;
    protected String categoryId;
    protected XmlBrand brand;
    protected String brandId;

    /**
     * Obtient la valeur de la propriété productCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Définit la valeur de la propriété productCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Obtient la valeur de la propriété productName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Définit la valeur de la propriété productName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProductName(String value) {
        this.productName = value;
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
     * Obtient la valeur de la propriété category.
     *
     * @return possible object is
     * {@link XmlProductCategory }
     */
    public XmlProductCategory getCategory() {
        return category;
    }

    /**
     * Définit la valeur de la propriété category.
     *
     * @param value allowed object is
     *              {@link XmlProductCategory }
     */
    public void setCategory(XmlProductCategory value) {
        this.category = value;
    }

    /**
     * Obtient la valeur de la propriété categoryId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Définit la valeur de la propriété categoryId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCategoryId(String value) {
        this.categoryId = value;
    }

    /**
     * Obtient la valeur de la propriété brand.
     *
     * @return possible object is
     * {@link XmlBrand }
     */
    public XmlBrand getBrand() {
        return brand;
    }

    /**
     * Définit la valeur de la propriété brand.
     *
     * @param value allowed object is
     *              {@link XmlBrand }
     */
    public void setBrand(XmlBrand value) {
        this.brand = value;
    }

    /**
     * Obtient la valeur de la propriété brandId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * Définit la valeur de la propriété brandId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrandId(String value) {
        this.brandId = value;
    }

}
