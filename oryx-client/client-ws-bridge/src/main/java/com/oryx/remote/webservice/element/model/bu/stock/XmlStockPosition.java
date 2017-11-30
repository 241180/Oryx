package com.oryx.remote.webservice.element.model.bu.stock;

import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProduct;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlStockPosition complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlStockPosition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="product" type="{http://sale.bu.model.element.webservice.remote.oryx.com}XmlProduct" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlStockPosition", propOrder = {
        "product",
        "productId",
        "quantity"
})
public class XmlStockPosition
        extends XmlCancelableAndTracable {

    protected XmlProduct product;
    protected String productId;
    protected Double quantity;

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

}
