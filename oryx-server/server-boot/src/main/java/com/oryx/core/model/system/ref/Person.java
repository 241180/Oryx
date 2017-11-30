package com.oryx.core.model.system.ref;

import com.oryx.core.annotation.decl.*;
import com.oryx.core.model.*;
import com.oryx.remote.webservice.element._enum.XmlEnumCivility;
import com.oryx.remote.webservice.element._enum.XmlEnumGender;
import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.persistence.Entity;
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

@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlPerson", namespace = "http://ref.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_PERSON
        , uniqueConstraints = {@UniqueConstraint(name = "UC_PERSON_UID", columnNames = {SchemaConstantName.T_PERSON_UID})}
)
public class Person extends CancelableAndTracable {

    @Column(name = SchemaConstantName.T_PERSON_UID, length = SchemaConstantSize.UID, nullable = false)
    private String defaultUid;

    @Column(name = SchemaConstantName.T_FIRST_NAME, length = SchemaConstantSize.NAME, nullable = false)
    private String firstName;

    @Column(name = SchemaConstantName.T_LAST_NAME, length = SchemaConstantSize.NAME, nullable = false)
    private String lastName;

    @Column(name = SchemaConstantName.T_PHONE_NUMBER, length = SchemaConstantSize.PHONE_NUMBER)
    private String defaultPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_CIVILITY, length = SchemaConstantSize.CODE, nullable = false)
    private XmlEnumCivility civility;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_GENDER, length = SchemaConstantSize.CODE, nullable = false)
    private XmlEnumGender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = ComSchemaConstantName.T_LANG_CODE, length = ComSchemaConstantSize.LANG_CODE)
    private XmlEnumLanguage language;

    @Column(name = SchemaConstantName.T_BIRTH_DATE, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_BIRTH_STATE_ID)
    @ForeignKey(name = "FK_PERSON_REF_PBIRTH_STATE")
    private State birthPlace;
    @Transient
    private UUID birthPlaceId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_PERSON_ID)
    @ForeignKey(name = "FK_PERSON_REF_UID")
    private Set<Uid> uidSet;
    @Transient
    private List<UUID> uidIds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = SchemaConstantName.T_ASSO_PERSON_ADRESS,
            joinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_PERSON_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_ADRESS_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            }
    )
    @ForeignKey(name = "FK_PERSON", inverseName = "FK_ADRESS")
    private Set<Adress> adressSet;
    @Transient
    private List<UUID> adressIds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = SchemaConstantName.T_ASSO_PERSON_CONTACT,
            joinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_PERSON_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_CONTACT_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            }
    )
    @ForeignKey(name = "FK_PERSONT", inverseName = "FK_CONTACT")
    private Set<Contact> contactSet;
    @Transient
    private List<UUID> contactIds;


    public Person() {

    }

    public Person(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String defaultUid, String firstName, String lastName, String defaultPhoneNumber, XmlEnumCivility civility, XmlEnumGender gender, XmlEnumLanguage language, Date birthDate, State birthPlace, UUID birthPlaceId, Set<Uid> uidSet, List<UUID> uidIds, Set<Adress> adressSet, List<UUID> adressIds, Set<Contact> contactSet, List<UUID> contactIds) {
        this.defaultUid = defaultUid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.defaultPhoneNumber = defaultPhoneNumber;
        this.civility = civility;
        this.gender = gender;
        this.language = language;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.birthPlaceId = birthPlaceId;
        this.uidSet = uidSet;
        this.uidIds = uidIds;
        this.adressSet = adressSet;
        this.adressIds = adressIds;
        this.contactSet = contactSet;
        this.contactIds = contactIds;
    }

    @Override
    public Object newInstance() {
        return new Person();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlPerson();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public XmlEnumCivility getCivility() {
        return civility;
    }

    public void setCivility(XmlEnumCivility civility) {
        this.civility = civility;
    }

    public XmlEnumGender getGender() {
        return gender;
    }

    public void setGender(XmlEnumGender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Adress> getAdressSet() {
        return adressSet;
    }

    public void setAdressSet(Set<Adress> adressSet) {
        this.adressSet = adressSet;
    }

    public List<UUID> getAdressIds() {
        return adressIds;
    }

    public void setAdressIds(List<UUID> adressIds) {
        this.adressIds = adressIds;
    }

    public Set<Uid> getUidSet() {
        return uidSet;
    }

    public void setUidSet(Set<Uid> uidSet) {
        this.uidSet = uidSet;
    }

    public List<UUID> getUidIds() {
        return uidIds;
    }

    public void setUidIds(List<UUID> uidIds) {
        this.uidIds = uidIds;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public List<UUID> getContactIds() {
        return contactIds;
    }

    public void setContactIds(List<UUID> contactIds) {
        this.contactIds = contactIds;
    }

    public UUID getBirthPlaceId() {
        return birthPlaceId;
    }

    public void setBirthPlaceId(UUID birthPlaceId) {
        this.birthPlaceId = birthPlaceId;
    }

    public String getDefaultUid() {
        return defaultUid;
    }

    public void setDefaultUid(String defaultUid) {
        this.defaultUid = defaultUid;
    }

    public String getDefaultPhoneNumber() {
        return defaultPhoneNumber;
    }

    public void setDefaultPhoneNumber(String defaultPhoneNumber) {
        this.defaultPhoneNumber = defaultPhoneNumber;
    }

    public State getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(State birthPlace) {
        this.birthPlace = birthPlace;
    }

    public XmlEnumLanguage getLanguage() {
        return language;
    }

    public void setLanguage(XmlEnumLanguage language) {
        this.language = language;
    }
}
