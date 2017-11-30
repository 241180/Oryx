package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element._enum.XmlEnumPermission;
import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element.model.system.ose.XmlTask;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlTask", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_TASK
        , uniqueConstraints = {@UniqueConstraint(name = "UC_TASK_NAME_PERMISSION", columnNames = {SchemaConstantName.T_NAME, SchemaConstantName.T_PERMISSION})}
)
public class Task extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_NAME, length = SchemaConstantSize.NAME, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_PERMISSION, length = SchemaConstantSize.CODE, nullable = false)
    private XmlEnumPermission permission;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION)
    private String descriptionTextArea;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_STATUS, length = SchemaConstantSize.CODE, nullable = false)
    private XmlEnumStatus status;

    @Column(name = SchemaConstantName.T_MENU_PATH, length = SchemaConstantSize.L_DESCRIPTION)
    private String menuPath;

    @Override
    public Object newInstance() {
        return new Task();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlTask();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public XmlEnumStatus getStatus() {
        return status;
    }

    public void setStatus(XmlEnumStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return descriptionTextArea;
    }

    public void setDescription(String description) {
        this.descriptionTextArea = description;
    }

    public XmlEnumPermission getPermission() {
        return permission;
    }

    public void setPermission(XmlEnumPermission permission) {
        this.permission = permission;
    }

    public String getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(String descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }
}
