package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.ComSchemaConstantName;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element.model.system.ose.XmlMenu;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Set;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlMenu", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_MENU
        , uniqueConstraints = {@UniqueConstraint(name = "UC_MENU_NAME", columnNames = {SchemaConstantName.T_NAME})}
)
public class Menu extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_NAME, length = SchemaConstantSize.NAME, nullable = false)
    private String name;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION)
    private String descriptionTextArea;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_STATUS, length = SchemaConstantSize.CODE, nullable = false)
    private XmlEnumStatus status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = SchemaConstantName.T_ASSO_MENU_TASK,
            joinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_MENU_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_TASK_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            }
    )
    @ForeignKey(name = "FK_MENU", inverseName = "FK_TASK")
    private Set<Task> taskSet;
    @Transient
    private List<String> taskIds;

    @Override
    public Object newInstance() {
        return new Menu();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlMenu();
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

    public Set<Task> getTasks() {
        return taskSet;
    }

    public void setTasks(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    public Set<Task> getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }

    public String getDescription() {
        return descriptionTextArea;
    }

    public void setDescription(String description) {
        this.descriptionTextArea = description;
    }
}
