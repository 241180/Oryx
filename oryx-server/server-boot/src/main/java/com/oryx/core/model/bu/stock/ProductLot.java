package com.oryx.core.model.bu.stock;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.*;
import com.oryx.core.model.bu.sale.Product;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlProductLot", namespace = "http://stock.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_STOCK_POSITION
        /*, uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
                */
)
public class ProductLot extends CancelableAndTracable {
    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false/*, nullable = false*/)
    private String lotCode;

    @Column(name = SchemaConstantName.T_NAME, length = SchemaConstantSize.NAME/*, nullable = false*/)
    private String lotName;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION/*, nullable = false*/)
    private String descriptionTextArea;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_PRODUCT_ID)
    @ForeignKey(name = "FK_PRODUCT_LOT_REF_PRODUCT")
    private Product product;
    @Transient
    private UUID productId;

    @Column(name = SchemaConstantName.T_QUANTITY, nullable = false)
    private Double quantity;

    @Column(name = SchemaConstantName.T_STOCK_IN_DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date stockInDate;

    @Column(name = SchemaConstantName.T_STOCK_OUT_DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date stockOutDate;

    @Column(name = SchemaConstantName.T_EXPIRY_DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    @Override
    public Object newInstance() {
        return new ProductLot();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlProductLot();
    }
}