package com.oryx.remote.webservice.element.model.system.ose;

import com.oryx.remote.webservice.element._enum.XmlEnumPermission;
import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlTask complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlTask">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="permission" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumPermission" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumStatus" minOccurs="0"/>
 *         &lt;element name="menuPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlTask", propOrder = {
        "name",
        "permission",
        "descriptionTextArea",
        "status",
        "menuPath"
})
public class XmlTask
        extends XmlCancelableAndTracable {

    protected String name;
    @XmlSchemaType(name = "string")
    protected XmlEnumPermission permission;
    protected String descriptionTextArea;
    @XmlSchemaType(name = "string")
    protected XmlEnumStatus status;
    protected String menuPath;

    /**
     * Obtient la valeur de la propriété name.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété permission.
     *
     * @return possible object is
     * {@link XmlEnumPermission }
     */
    public XmlEnumPermission getPermission() {
        return permission;
    }

    /**
     * Définit la valeur de la propriété permission.
     *
     * @param value allowed object is
     *              {@link XmlEnumPermission }
     */
    public void setPermission(XmlEnumPermission value) {
        this.permission = value;
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
     * Obtient la valeur de la propriété status.
     *
     * @return possible object is
     * {@link XmlEnumStatus }
     */
    public XmlEnumStatus getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     *
     * @param value allowed object is
     *              {@link XmlEnumStatus }
     */
    public void setStatus(XmlEnumStatus value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriété menuPath.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMenuPath() {
        return menuPath;
    }

    /**
     * Définit la valeur de la propriété menuPath.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMenuPath(String value) {
        this.menuPath = value;
    }

}
