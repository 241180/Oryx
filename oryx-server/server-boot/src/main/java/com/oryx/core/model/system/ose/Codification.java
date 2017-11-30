package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element.model.system.ose.XmlCodification;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlCodification", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_CODIFICATION
        , uniqueConstraints = {@UniqueConstraint(name = "UC_CODIF_SERV_CODE_INT_CODE", columnNames = {SchemaConstantName.T_SERVER_CODE, SchemaConstantName.T_INTERNAL_CODE})}
)
public class Codification extends CancelableAndTracable {

    @Column(name = SchemaConstantName.T_SERVER_CODE, length = SchemaConstantSize.CODE, nullable = false)
    private String serverCode;

    @Column(name = SchemaConstantName.T_INTERNAL_CODE, length = SchemaConstantSize.M_VALUE, nullable = false)
    private String internalCode;

    @Column(name = SchemaConstantName.T_EXTERNAL_CODE, length = SchemaConstantSize.M_VALUE, nullable = false)
    private String externalCode;

    @Column(name = SchemaConstantName.T_STAT_DATE)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = SchemaConstantName.T_END_DATE)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Override
    public Object newInstance() {
        return new Codification();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlCodification();
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }
}
