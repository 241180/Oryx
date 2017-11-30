package com.oryx.remote.webservice.element.model.system.ose;

import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element.model.XmlCancelableAndTracable;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 241180 on 09/01/2017.
 * <p>
 * <p>Classe Java pour XmlMenu complex type.
 * <p>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;complexType name="XmlMenu">
 *   &lt;complexContent>
 *     &lt;extension base="{http://model.element.webservice.remote.oryx.com}XmlCancelableAndTracable">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptionTextArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://enum.element.webservice.remote.oryx.com}XmlEnumStatus" minOccurs="0"/>
 *         &lt;element name="taskSet" type="{http://ose.system.model.element.webservice.remote.oryx.com}XmlTask" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlMenu", propOrder = {
        "name",
        "descriptionTextArea",
        "status",
        "taskSet",
        "taskIds"
})
public class XmlMenu
        extends XmlCancelableAndTracable {

    protected String name;
    protected String descriptionTextArea;
    @XmlSchemaType(name = "string")
    protected XmlEnumStatus status;
    @XmlElement(nillable = true)
    protected List<XmlTask> taskSet;
    @XmlElement(nillable = true)
    protected List<String> taskIds;

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
     * Gets the value of the taskSet property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskSet property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskSet().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlTask }
     */
    public List<XmlTask> getTaskSet() {
        if (taskSet == null) {
            taskSet = new ArrayList<XmlTask>();
        }
        return this.taskSet;
    }

    /**
     * Gets the value of the taskIds property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskIds property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskIds().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getTaskIds() {
        if (taskIds == null) {
            taskIds = new ArrayList<String>();
        }
        return this.taskIds;
    }

}
