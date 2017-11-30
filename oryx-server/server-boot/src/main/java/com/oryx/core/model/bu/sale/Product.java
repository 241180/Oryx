package com.oryx.core.model.bu.sale;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.*;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProduct;
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
@XmlType(name = "XmlProduct", namespace = "http://sale.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_PRODUCT
        /*, uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
                */
)
public class Product extends CancelableAndTracable {

    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false/*, nullable = false*/)
    private String productCode;

    @Column(name = SchemaConstantName.T_NAME, length = SchemaConstantSize.NAME/*, nullable = false*/)
    private String productName;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION/*, nullable = false*/)
    private String descriptionTextArea;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_CATEGORY_ID)
    @ForeignKey(name = "FK_PRODUCT_REF_CATEGORY")
    private ProductCategory category;
    @Transient
    private UUID categoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_BRAND_ID)
    @ForeignKey(name = "FK_PRODUCT_REF_BRAND")
    private Brand brand;
    @Transient
    private UUID brandId;

    @Override
    public Object newInstance() {
        return new Product();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlProduct();
    }
}