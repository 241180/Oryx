package com.oryx.core.model.system.ref;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.enums.EnumContact;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element.model.system.ref.XmlContact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlContact", namespace = "http://ref.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_CONTACT
        //,uniqueConstraints = {@UniqueConstraint(columnNames = {"contactType", "value"})}
)
public class Contact extends CancelableAndTracable {

    @Column(name = SchemaConstantName.T_CONTACT_TYPE, length = SchemaConstantSize.TYPE, nullable = false)
    private EnumContact contactType;

    @Column(name = SchemaConstantName.T_CONTACT_VALUE, length = SchemaConstantSize.M_VALUE, nullable = false)
    private String value;

    @Override
    public Object newInstance() {
        return new Contact();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlContact();
    }

    public EnumContact getContactType() {
        return contactType;
    }

    public void setContactType(EnumContact contactType) {
        this.contactType = contactType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
