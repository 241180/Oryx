package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.system.ose.XmlAnnex;

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
@XmlType(name = "XmlAnnex", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_ANNEX
        , uniqueConstraints = {@UniqueConstraint(name = "UC_ANNEX_CODE_LANG_VALUE", columnNames = {SchemaConstantName.T_ANNEX_CODE
        , SchemaConstantName.T_LANGUAGE_CODE
        , SchemaConstantName.T_ANNEX_VALUE})}
)
public class Annex extends CancelableAndTracable {

    @Column(name = SchemaConstantName.T_ANNEX_CODE, length = SchemaConstantSize.TABLE_CODE, nullable = false)
    private String tableCode;

    @Column(name = SchemaConstantName.T_LANGUAGE_CODE, length = SchemaConstantSize.LANG_CODE, nullable = false)
    private XmlEnumLanguage langage;

    @Column(name = SchemaConstantName.T_ANNEX_VALUE, length = SchemaConstantSize.S_VALUE, nullable = false)
    private String value;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION)
    private String descriptionTextArea;

    @Column(name = SchemaConstantName.T_ANNEX_REFERENCE, length = SchemaConstantSize.S_VALUE)
    private String reference;

    @Override
    public Object newInstance() {
        return new Annex();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlAnnex();
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public XmlEnumLanguage getLangage() {
        return langage;
    }

    public void setLangage(XmlEnumLanguage langage) {
        this.langage = langage;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(String descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }
}
