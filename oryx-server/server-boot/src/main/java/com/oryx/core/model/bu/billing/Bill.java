package com.oryx.core.model.bu.billing;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.*;
import com.oryx.remote.webservice.element._enum.XmlEnumBillStatus;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;
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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlBill", namespace = "http://billing.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_BILL
        /*, uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
                */
)
public class Bill extends CancelableAndTracable {
    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false/*, nullable = false*/)
    private String billCode;

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_BILL_STATUS, length = SchemaConstantSize.CODE)
    private XmlEnumBillStatus status;

    @Column(name = SchemaConstantName.T_CALCULATION_DATE, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date calculationDate;

    @Column(name = SchemaConstantName.T_ISSUE_DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name = SchemaConstantName.T_DUE_DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    @Column(name = SchemaConstantName.T_SETTLEMENT_DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date settlementDate;

    @Column(name = SchemaConstantName.T_GROSS_AMOUNT, nullable = false)
    private Double grossAmmount;

    @Column(name = SchemaConstantName.T_TAX)
    private Double tax;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_BILL_ID)
    @ForeignKey(name = "FK_BILL_REF_BILL_ITEM")
    private Set<BillItem> billItemSet;
    @Transient
    private List<UUID> billItemIds;

    @Override
    public Object newInstance() {
        return new Bill();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlBill();
    }
}