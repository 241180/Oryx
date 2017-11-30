package com.oryx.remote.webservice.element.model.bu.sale;

import com.oryx.remote.webservice.element._enum.XmlEnumCartStatus;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlCart complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlCart">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="cartCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumCartStatus" minOccurs="0"/>
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="settlementDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="grossAmmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cartItemSet" type="{http://sale.bu.model.element.webservice.remote.oryx.com}XmlCartItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cartItemIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlCart", propOrder = {
        "cartCode",
        "status",
        "expiryDate",
        "settlementDate",
        "grossAmmount",
        "tax",
        "cartItemSet",
        "cartItemIds"
})
public class XmlCart
        extends XmlCancelableAndTracable {

    protected String cartCode;
    @XmlSchemaType(name = "string")
    protected XmlEnumCartStatus status;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settlementDate;
    protected Double grossAmmount;
    protected Double tax;
    @XmlElement(nillable = true)
    protected List<XmlCartItem> cartItemSet;
    @XmlElement(nillable = true)
    protected List<String> cartItemIds;

    /**
     * Obtient la valeur de la propriété cartCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCartCode() {
        return cartCode;
    }

    /**
     * Définit la valeur de la propriété cartCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCartCode(String value) {
        this.cartCode = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     *
     * @return possible object is
     * {@link XmlEnumCartStatus }
     */
    public XmlEnumCartStatus getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     *
     * @param value allowed object is
     *              {@link XmlEnumCartStatus }
     */
    public void setStatus(XmlEnumCartStatus value) {
        this.status = value;
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

    /**
     * Obtient la valeur de la propriété settlementDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getSettlementDate() {
        return settlementDate;
    }

    /**
     * Définit la valeur de la propriété settlementDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setSettlementDate(XMLGregorianCalendar value) {
        this.settlementDate = value;
    }

    /**
     * Obtient la valeur de la propriété grossAmmount.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getGrossAmmount() {
        return grossAmmount;
    }

    /**
     * Définit la valeur de la propriété grossAmmount.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setGrossAmmount(Double value) {
        this.grossAmmount = value;
    }

    /**
     * Obtient la valeur de la propriété tax.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getTax() {
        return tax;
    }

    /**
     * Définit la valeur de la propriété tax.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setTax(Double value) {
        this.tax = value;
    }

    /**
     * Gets the value of the cartItemSet property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cartItemSet property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCartItemSet().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlCartItem }
     */
    public List<XmlCartItem> getCartItemSet() {
        if (cartItemSet == null) {
            cartItemSet = new ArrayList<XmlCartItem>();
        }
        return this.cartItemSet;
    }

    /**
     * Gets the value of the cartItemIds property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cartItemIds property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCartItemIds().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getCartItemIds() {
        if (cartItemIds == null) {
            cartItemIds = new ArrayList<String>();
        }
        return this.cartItemIds;
    }

}
