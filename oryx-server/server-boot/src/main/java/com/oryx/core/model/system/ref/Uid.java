package com.oryx.core.model.system.ref;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element._enum.XmlEnumUID;
import com.oryx.remote.webservice.element.model.system.ref.XmlUid;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlUid", namespace = "http://ref.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_PERSON_UID
        , uniqueConstraints = {@UniqueConstraint(name = "UC_UID_TYPE_VALUE", columnNames = {SchemaConstantName.T_UID_TYPE, SchemaConstantName.T_UID_VALUE})}
)
public class Uid extends CancelableAndTracable {

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_UID_TYPE, length = SchemaConstantSize.TYPE/* , nullable = false */)
    private XmlEnumUID uidType;

    @Column(name = SchemaConstantName.T_UID_VALUE, length = SchemaConstantSize.M_VALUE)
    private String uid;

    @Override
    public Object newInstance() {
        return new Uid();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlUid();
    }

    public XmlEnumUID getUidType() {
        return uidType;
    }

    public void setUidType(XmlEnumUID uidType) {
        this.uidType = uidType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}