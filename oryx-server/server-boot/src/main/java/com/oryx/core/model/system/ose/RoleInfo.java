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
import com.oryx.remote.webservice.element.model.system.ose.XmlRoleInfo;
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
@XmlType(name = "XmlRoleInfo", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_ROLE_INFO
        , uniqueConstraints = {@UniqueConstraint(name = "UC_ROLE_NAME", columnNames = {SchemaConstantName.T_ROLE_NAME})}
)
public class RoleInfo extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_ROLE_NAME, length = SchemaConstantSize.NAME, nullable = false)
    private String name;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION)
    private String descriptionTextArea;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_STATUS, length = SchemaConstantSize.CODE, nullable = false)
    private XmlEnumStatus status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = SchemaConstantName.T_ASSO_ROLE_MENU,
            joinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_ROLE_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_MENU_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            }
    )
    @ForeignKey(name = "FK_ROLE", inverseName = "FK_MENU")
    private Set<Menu> menuSet;

    @Transient
    private List<String> menuIds;

    @Override
    public Object newInstance() {
        return new RoleInfo();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlRoleInfo();
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
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

    public Set<Menu> getMenus() {
        return menuSet;
    }

    public void setMenus(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }

    public String getDescription() {
        return descriptionTextArea;
    }

    public void setDescription(String description) {
        this.descriptionTextArea = description;
    }
}