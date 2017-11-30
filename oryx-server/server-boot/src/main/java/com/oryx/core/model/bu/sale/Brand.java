package com.oryx.core.model.bu.sale;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.*;
import com.oryx.remote.webservice.element.model.bu.sale.XmlBrand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlBrand", namespace = "http://sale.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_BRAND
        /*, uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
                */
)
public class Brand extends CancelableAndTracable {
    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false/*, nullable = false*/)
    private String brandCode;

    @Column(name = SchemaConstantName.T_NAME, length = SchemaConstantSize.NAME/*, nullable = false*/)
    private String brandName;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION/*, nullable = false*/)
    private String descriptionTextArea;

    @Override
    public Object newInstance() {
        return new Brand();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlBrand();
    }
}