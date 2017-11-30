package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element.model.system.ose.XmlFieldProcessParam;

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
@XmlType(name = "XmlFieldProcessParam", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_FIELD_PROCESS_PARAM
        , uniqueConstraints = {@UniqueConstraint(name = "UC_FPP_CODE_FIELD_REF_TYPE", columnNames = {SchemaConstantName.T_PROCESS_CODE
        , SchemaConstantName.T_FIELD_CODE
        , SchemaConstantName.T_PROCESS_REF
        , SchemaConstantName.T_PROCESS_TYPE})}
)
public class FieldProcessParam extends CancelableAndTracable {

    @Column(name = SchemaConstantName.T_PROCESS_CODE, length = SchemaConstantSize.CODE, nullable = false)
    private String processCode;

    @Column(name = SchemaConstantName.T_FIELD_CODE, length = SchemaConstantSize.M_VALUE, nullable = false)
    private String fieldCode;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION)
    private String descriptionTextArea;

    @Column(name = SchemaConstantName.T_PROCESS_REF, length = SchemaConstantSize.CODE/* , nullable = false */)
    private String processRef;

    @Column(name = SchemaConstantName.T_PROCESS_TYPE, length = SchemaConstantSize.CODE/* , nullable = false */)
    private String processType;

    @Column(name = SchemaConstantName.T_PROCESS_RESULT, length = SchemaConstantSize.CODE/* , nullable = false */)
    private String processResult;

    @Override
    public Object newInstance() {
        return new FieldProcessParam();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlFieldProcessParam();
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getProcessRef() {
        return processRef;
    }

    public void setProcessRef(String processRef) {
        this.processRef = processRef;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }

    public String getDescription() {
        return descriptionTextArea;
    }

    public void setDescription(String description) {
        this.descriptionTextArea = description;
    }
}
