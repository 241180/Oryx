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
 * <p>Classe Java pour XmlErrorMessage complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlErrorMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="messageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumLanguage" minOccurs="0"/>
 *         &lt;element name="meaning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlErrorMessage", propOrder = {
        "messageCode",
        "language",
        "meaning"
})
public class XmlErrorMessage
        extends XmlCancelableAndTracable {

    protected String messageCode;
    @XmlSchemaType(name = "string")
    protected XmlEnumLanguage language;
    protected String meaning;

    /**
     * Obtient la valeur de la propriété messageCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * Définit la valeur de la propriété messageCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMessageCode(String value) {
        this.messageCode = value;
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
     * Obtient la valeur de la propriété meaning.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * Définit la valeur de la propriété meaning.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMeaning(String value) {
        this.meaning = value;
    }

}
