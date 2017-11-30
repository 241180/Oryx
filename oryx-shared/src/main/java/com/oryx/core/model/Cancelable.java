package com.oryx.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by SAMI on 25/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlCancelable", namespace = "http://model.element.webservice.remote.oryx.com")
@MappedSuperclass
public abstract class Cancelable extends DomainCapable {
    @Column(name = ComSchemaConstantName.T_CHECK_CANCEL, nullable = false)
    private Boolean checkCancel;

    @Column(name = ComSchemaConstantName.T_CANCELED_BY, columnDefinition = ComSchemaConstantName.ID_COL_DEFINITION)
    private UUID canceledBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ComSchemaConstantName.T_CANCEL_DATE)
    private Date cancelDate;

    public Boolean getCheckCancel() {
        return checkCancel;
    }

    public void setCheckCancel(Boolean checkCancel) {
        this.checkCancel = checkCancel;
    }

    public UUID getCanceledBy() {
        return canceledBy;
    }

    public void setCanceledBy(UUID cancelBy) {
        this.canceledBy = cancelBy;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }
}
