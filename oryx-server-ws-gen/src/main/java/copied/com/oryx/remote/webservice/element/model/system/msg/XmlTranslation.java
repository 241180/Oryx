package com.oryx.remote.webservice.element.model.system.msg;

import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlTranslation complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlTranslation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="bundleOrigin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumLanguage" minOccurs="0"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="translation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlTranslation", propOrder = {
        "bundleOrigin",
        "language",
        "text",
        "translation"
})
public class XmlTranslation
        extends XmlCancelableAndTracable {

    protected String bundleOrigin;
    @XmlSchemaType(name = "string")
    protected XmlEnumLanguage language;
    protected String text;
    protected String translation;

    /**
     * Obtient la valeur de la propriété bundleOrigin.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBundleOrigin() {
        return bundleOrigin;
    }

    /**
     * Définit la valeur de la propriété bundleOrigin.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBundleOrigin(String value) {
        this.bundleOrigin = value;
    }

    /**
     * Obtient la valeur de la propriété language.
     *
     * @return possible object is
     * {@link XmlEnumLanguage }
     */
    public XmlEnumLanguage getLanguage() {
        return language;
    }

    /**
     * Définit la valeur de la propriété language.
     *
     * @param value allowed object is
     *              {@link XmlEnumLanguage }
     */
    public void setLanguage(XmlEnumLanguage value) {
        this.language = value;
    }

    /**
     * Obtient la valeur de la propriété text.
     *
     * @return possible object is
     * {@link String }
     */
    public String getText() {
        return text;
    }

    /**
     * Définit la valeur de la propriété text.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Obtient la valeur de la propriété translation.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Définit la valeur de la propriété translation.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTranslation(String value) {
        this.translation = value;
    }

}
