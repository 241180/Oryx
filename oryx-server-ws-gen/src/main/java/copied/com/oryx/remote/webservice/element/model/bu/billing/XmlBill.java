package com.oryx.remote.webservice.element.model.bu.billing;

import com.oryx.remote.webservice.element._enum.XmlEnumBillStatus;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlBill complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlBill">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="billCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumBillStatus" minOccurs="0"/>
 *         &lt;element name="calculationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="issueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="settlementDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="grossAmmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="billItemSet" type="{http://billing.bu.model.element.webservice.remote.oryx.com}XmlBillItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="billItemIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlBill", propOrder = {
        "billCode",
        "status",
        "calculationDate",
        "issueDate",
        "dueDate",
        "settlementDate",
        "grossAmmount",
        "tax",
        "billItemSet",
        "billItemIds"
})
public class XmlBill
        extends XmlCancelableAndTracable {

    protected String billCode;
    @XmlSchemaType(name = "string")
    protected XmlEnumBillStatus status;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar calculationDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar issueDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dueDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settlementDate;
    protected Double grossAmmount;
    protected Double tax;
    @XmlElement(nillable = true)
    protected List<XmlBillItem> billItemSet;
    @XmlElement(nillable = true)
    protected List<String> billItemIds;

    /**
     * Obtient la valeur de la propriété billCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBillCode() {
        return billCode;
    }

    /**
     * Définit la valeur de la propriété billCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBillCode(String value) {
        this.billCode = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     *
     * @return possible object is
     * {@link XmlEnumBillStatus }
     */
    public XmlEnumBillStatus getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     *
     * @param value allowed object is
     *              {@link XmlEnumBillStatus }
     */
    public void setStatus(XmlEnumBillStatus value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriété calculationDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCalculationDate() {
        return calculationDate;
    }

    /**
     * Définit la valeur de la propriété calculationDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCalculationDate(XMLGregorianCalendar value) {
        this.calculationDate = value;
    }

    /**
     * Obtient la valeur de la propriété issueDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getIssueDate() {
        return issueDate;
    }

    /**
     * Définit la valeur de la propriété issueDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setIssueDate(XMLGregorianCalendar value) {
        this.issueDate = value;
    }

    /**
     * Obtient la valeur de la propriété dueDate.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Définit la valeur de la propriété dueDate.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
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
     * Gets the value of the billItemSet property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billItemSet property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillItemSet().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlBillItem }
     */
    public List<XmlBillItem> getBillItemSet() {
        if (billItemSet == null) {
            billItemSet = new ArrayList<XmlBillItem>();
        }
        return this.billItemSet;
    }

    /**
     * Gets the value of the billItemIds property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billItemIds property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillItemIds().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getBillItemIds() {
        if (billItemIds == null) {
            billItemIds = new ArrayList<String>();
        }
        return this.billItemIds;
    }

}
