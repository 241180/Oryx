package com.oryx.remote.webservice.element.model.bu.stock;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProduct;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlProductLot complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlProductLot">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="lotCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product" type="{http://sale.bu.model.element.webservice.remote.oryx.com}XmlProduct" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="stockInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="stockOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlProductLot", propOrder = {
        "lotCode",
        "lotName",
        "descriptionTextArea",
        "product",
        "productId",
        "quantity",
        "stockInDate",
        "stockOutDate",
        "expiryDate"
})
public class XmlProductLot
        extends XmlCancelableAndTracable {

    protected String lotCode;
    protected String lotName;
    protected String descriptionTextArea;
    protected XmlProduct product;
    protected String productId;
    protected Double quantity;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stockInDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stockOutDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryDate;

    /**
     * Obtient la valeur de la propriété lotCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLotCode() {
        return lotCode;
    }

    /**
     * Définit la valeur de la propriété lotCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLotCode(String value) {
        this.lotCode = value;
    }

    /**
     * Obtient la valeur de la propriété lotName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLotName() {
        return lotName;
    }

    /**
     * Définit la valeur de la propriété lotName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLotName(String value) {
        this.lotName = value;
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
     * Obtient la valeur de la propriété product.
     *
     * @return possible object is
     * {@link XmlProduct }
     */
    public XmlProduct getProduct() {
        return product;
    }

    /**
     * Définit la valeur de la propriété product.
     *
     * @param value allowed object is
     *              {@link XmlProduct }
     */
    public void setProduct(XmlProduct value) {
        this.product = value;
    }

    /**
     * Obtient la valeur de la propriété productId.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Définit la valeur de la propriété productId.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProductId(String value) {
        this.productId = value;
    }

    /**
     * Obtient la valeur de la propriété quantity.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * Définit la valeur de la propriété quantity.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setQuantity(Double value) {
        this.quantity = value;
    }

    /**
     * Obtient la valeur de la propriété stockInDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStockInDate() {
        return stockInDate;
    }

    /**
     * Définit la valeur de la propriété stockInDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStockInDate(XMLGregorianCalendar value) {
        this.stockInDate = value;
    }

    /**
     * Obtient la valeur de la propriété stockOutDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStockOutDate() {
        return stockOutDate;
    }

    /**
     * Définit la valeur de la propriété stockOutDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStockOutDate(XMLGregorianCalendar value) {
        this.stockOutDate = value;
    }

    /**
     * Obtient la valeur de la propriété expiryDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Définit la valeur de la propriété expiryDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

}
