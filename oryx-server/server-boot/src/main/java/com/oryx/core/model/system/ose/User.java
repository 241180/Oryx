package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.listener.system.ref.UserListener;
import com.oryx.core.model.*;
import com.oryx.core.model.system.ref.Person;
import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element._enum.XmlEnumUserRole;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlUser", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@EntityListeners(UserListener.class)
@Table(
        name = SchemaConstantName.T_USER
        , uniqueConstraints = {@UniqueConstraint(name = "UC_USER_CODE", columnNames = {SchemaConstantName.T_CODE}),
        @UniqueConstraint(name = "UC_USER_EMAIL", columnNames = {SchemaConstantName.T_EMAIL}),
        @UniqueConstraint(name = "UC_USER_PERSON_ID", columnNames = {SchemaConstantName.T_PERSON_ID}),
        @UniqueConstraint(name = "UC_USER_LOGIN", columnNames = {SchemaConstantName.T_LOGIN})}
)
public class User extends CancelableAndTracable {
    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false/*, nullable = false*/)
    private String userCode;

    //@Size(min = 3, max = 50, message = "name must be longer than 3 and less than 40 characters")
    @NotNull(message = "Email is required")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Must be valid email")
    @Column(name = SchemaConstantName.T_EMAIL, length = SchemaConstantSize.EMAIL/*, nullable = false*/)
    private String email;

    @Column(name = SchemaConstantName.T_LOGIN, length = SchemaConstantSize.LOGIN/*, nullable = false*/)
    private String userLogin;

    @Column(name = SchemaConstantName.T_USER_PASSWORD, length = SchemaConstantSize.PASS_WORD/*, nullable = false*/)
    private String userPassword;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = SchemaConstantName.T_START_DATE)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = SchemaConstantName.T_END_DATE)
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = ComSchemaConstantName.T_LANG_CODE, length = ComSchemaConstantSize.LANG_CODE)
    private XmlEnumLanguage language;

    @Column(name = SchemaConstantName.T_LAST_CONNECTION)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnection;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_USER_ROLE, length = SchemaConstantSize.CODE/*, nullable = false*/)
    private XmlEnumUserRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_STATUS, length = SchemaConstantSize.CODE/*, nullable = false*/)
    private XmlEnumStatus status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_PERSON_ID)
    @ForeignKey(name = "FK_USER_REF_PERSON")
    private Person person;
    @Transient
    private UUID personId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = SchemaConstantName.T_ASSO_USER_ROLE,
            joinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_USER_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_ROLE_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            }
    )
    @ForeignKey(name = "FK_USER", inverseName = "FK_ROLE")
    private Set<RoleInfo> roleSet;
    @Transient
    private List<String> roleIds;

    @Override
    public Object newInstance() {
        return new User();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlUser();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(Date lastConnection) {
        this.lastConnection = lastConnection;
    }

    public XmlEnumUserRole getRole() {
        return role;
    }

    public void setRole(XmlEnumUserRole role) {
        this.role = role;
    }

    public XmlEnumStatus getStatus() {
        return status;
    }

    public void setStatus(XmlEnumStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public Set<RoleInfo> getRoles() {
        return roleSet;
    }

    public void setRoles(Set<RoleInfo> roleSet) {
        this.roleSet = roleSet;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public Set<RoleInfo> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<RoleInfo> roleSet) {
        this.roleSet = roleSet;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public XmlEnumLanguage getLanguage() {
        return language;
    }

    public void setLanguage(XmlEnumLanguage language) {
        this.language = language;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}