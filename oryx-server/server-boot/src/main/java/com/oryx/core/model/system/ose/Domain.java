package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element.model.system.ose.XmlDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlDomain", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_DOMAIN
        , uniqueConstraints = {@UniqueConstraint(name = "UC_DOMAIN_CODE", columnNames = {SchemaConstantName.T_CODE})
}
)
public class Domain extends CancelableAndTracable {

    @Column(name = SchemaConstantName.T_CODE, length = SchemaConstantSize.CODE, nullable = false)
    private String domainCode;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION)
    private String descriptionTextArea;

    @Column(name = SchemaConstantName.T_DOMAIN_REFERENCE, length = SchemaConstantSize.S_VALUE)
    private String reference;

    @Override
    public Object newInstance() {
        return new Domain();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlDomain();
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return descriptionTextArea;
    }

    public void setDescription(String description) {
        this.descriptionTextArea = description;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }
}
