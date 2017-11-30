package com.oryx.core.model.system.ref;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.listener.system.ref.ThirdPartyListener;
import com.oryx.core.model.*;
import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.system.ref.XmlThirdParty;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlThirdParty", namespace = "http://ref.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@EntityListeners(ThirdPartyListener.class)
@Table(
        name = SchemaConstantName.T_THIRD_PARTY
        , uniqueConstraints = {
        @UniqueConstraint(name = "UC_NAME"
                , columnNames = {SchemaConstantName.T_NAME}),
}

)
public class ThirdParty extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_NAME, nullable = false)
    private String name;

    @Column(name = SchemaConstantName.T_REFERENCE, nullable = false)
    private String reference;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = ComSchemaConstantSize.M_DESCRIPTION, nullable = false)
    private String descriptionTextArea;

    @Enumerated(EnumType.STRING)
    @Column(name = ComSchemaConstantName.T_LANG_CODE, length = ComSchemaConstantSize.LANG_CODE)
    private XmlEnumLanguage language;

    @Column(name = SchemaConstantName.T_PHONE_NUMBER, length = SchemaConstantSize.PHONE_NUMBER)
    private String defaultPhoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = SchemaConstantName.T_ASSO_THIRD_PARTY_ADRESS,
            joinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_THIRD_PARTY_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_ADRESS_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            }
    )
    @ForeignKey(name = "FK_THIRD_PARTY", inverseName = "FK_ADRESS")
    private Set<Adress> adressSet;
    @Transient
    private List<UUID> adressIds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = SchemaConstantName.T_ASSO_THIRD_PARTY_CONTACT,
            joinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_THIRD_PARTY_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = SchemaConstantName.T_CONTACT_ID, referencedColumnName = ComSchemaConstantName.T_ID)
            }
    )
    @ForeignKey(name = "FK_THIRD_PARTY", inverseName = "FK_CONTACT")
    private Set<Contact> contactSet;
    @Transient
    private List<UUID> contactIds;

    @Override
    public Object newInstance() {
        return new ThirdParty();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlThirdParty();
    }
}