package com.oryx.core.model.bu.billing;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.ComSchemaConstantName;
import com.oryx.core.model.ComSchemaConstantSize;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlAccount", namespace = "http://billing.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_ACCOUNT
        /*, uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
                */
)
public class Account extends CancelableAndTracable {
    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false/*, nullable = false*/)
    private String accountCode;

    @Column(name = SchemaConstantName.T_ACTIVTION_DATE, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate;

    @Column(name = SchemaConstantName.T_DEACTIVTION_DATE, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deactivationDate;

    @Column(name = SchemaConstantName.T_AMOUNT, nullable = false)
    private Double ammount;

    @Override
    public Object newInstance() {
        return new Account();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlAccount();
    }
}