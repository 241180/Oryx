package com.oryx.core.model.bu.billing;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.bu.sale.Product;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlBillItem", namespace = "http://billing.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_BILL_ITEM
        /*, uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
                */
)
public class BillItem extends CancelableAndTracable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_PRODUCT_ID)
    @ForeignKey(name = "FK_BILL_ITEM_REF_PRODUCT")
    private Product product;
    @Transient
    private UUID productId;

    @Column(name = SchemaConstantName.T_QUANTITY, nullable = false)
    private Double quantity;

    @Column(name = SchemaConstantName.T_UNIT_PRICE, nullable = false)
    private Double unitPrice;

    @Column(name = SchemaConstantName.T_DISCOUNT)
    private Double discount;

    @Column(name = SchemaConstantName.T_TAX)
    private Double tax;

    @Override
    public Object newInstance() {
        return new BillItem();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlBillItem();
    }
}