package com.oryx.remote.webservice.element.model.bu.billing;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.oryx.remote.webservice.element.model.bu.billing package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oryx.remote.webservice.element.model.bu.billing
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XmlInstance }
     */
    public XmlInstance createXmlInstance() {
        return new XmlInstance();
    }

    /**
     * Create an instance of {@link XmlBill }
     */
    public XmlBill createXmlBill() {
        return new XmlBill();
    }

    /**
     * Create an instance of {@link XmlAccount }
     */
    public XmlAccount createXmlAccount() {
        return new XmlAccount();
    }

    /**
     * Create an instance of {@link XmlBillItem }
     */
    public XmlBillItem createXmlBillItem() {
        return new XmlBillItem();
    }

}
