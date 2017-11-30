package com.oryx.core.model.bu.health;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.*;
import com.oryx.core.model.system.ref.Person;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlPatient", namespace = "http://health.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_PATIENT
        , uniqueConstraints = {@UniqueConstraint(name = "UC_PATIENT_CODE", columnNames = {SchemaConstantName.T_CODE}),
        @UniqueConstraint(name = "UC_PATIENT_EMAIL", columnNames = {SchemaConstantName.T_EMAIL}),
        @UniqueConstraint(name = "UC_PATIENT_PERSON_ID", columnNames = {SchemaConstantName.T_PERSON_ID})}
)
public class Patient extends CancelableAndTracable {
    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false/*, nullable = false*/)
    private String patientCode;

    @Column(name = SchemaConstantName.T_EMAIL, length = SchemaConstantSize.EMAIL/*, nullable = false*/)
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_PERSON_ID)
    @ForeignKey(name = "FK_PATIENT_REF_PERSON")
    private Person person;
    @Transient
    private UUID personId;


    @Override
    public Object newInstance() {
        return new Patient();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlPatient();
    }
}