package com.oryx.remote.webservice.element.model.bu.sale;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.oryx.remote.webservice.element.model.bu.sale package.
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oryx.remote.webservice.element.model.bu.sale
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XmlCartItem }
     */
    public XmlCartItem createXmlCartItem() {
        return new XmlCartItem();
    }

    /**
     * Create an instance of {@link XmlBrand }
     */
    public XmlBrand createXmlBrand() {
        return new XmlBrand();
    }

    /**
     * Create an instance of {@link XmlCart }
     */
    public XmlCart createXmlCart() {
        return new XmlCart();
    }

    /**
     * Create an instance of {@link XmlProductCategory }
     */
    public XmlProductCategory createXmlProductCategory() {
        return new XmlProductCategory();
    }

    /**
     * Create an instance of {@link XmlProduct }
     */
    public XmlProduct createXmlProduct() {
        return new XmlProduct();
    }

    /**
     * Create an instance of {@link XmlShopper }
     */
    public XmlShopper createXmlShopper() {
        return new XmlShopper();
    }

}
