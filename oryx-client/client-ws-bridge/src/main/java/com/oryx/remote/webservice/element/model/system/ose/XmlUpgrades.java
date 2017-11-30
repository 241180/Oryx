package com.oryx.remote.webservice.element.model.system.ose;

import com.oryx.remote.webservice.element.model.XmlTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlUpgrades complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlUpgrades">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlTracable">
 *       &lt;sequence>
 *         &lt;element name="upgradeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="softwareVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlUpgrades", propOrder = {
        "upgradeCode",
        "softwareVersion",
        "descriptionTextArea"
})
public class XmlUpgrades
        extends XmlTracable {

    protected String upgradeCode;
    protected String softwareVersion;
    protected String descriptionTextArea;

    /**
     * Obtient la valeur de la propriété upgradeCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUpgradeCode() {
        return upgradeCode;
    }

    /**
     * Définit la valeur de la propriété upgradeCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUpgradeCode(String value) {
        this.upgradeCode = value;
    }

    /**
     * Obtient la valeur de la propriété softwareVersion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * Définit la valeur de la propriété softwareVersion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSoftwareVersion(String value) {
        this.softwareVersion = value;
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
