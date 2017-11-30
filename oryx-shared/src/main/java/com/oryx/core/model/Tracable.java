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
@XmlType(name = "XmlTracable", namespace = "http://model.element.webservice.remote.oryx.com")
@MappedSuperclass
public abstract class Tracable extends DomainCapable {

    @Column(name = ComSchemaConstantName.T_CREATED_BY, /*nullable = false,*/ updatable = false, columnDefinition = ComSchemaConstantName.ID_COL_DEFINITION)
    private UUID createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ComSchemaConstantName.T_CREATE_DATE, /*nullable = false,*/ updatable = false)
    private Date creationDate = new Date();

    @Column(name = ComSchemaConstantName.T_UPDATED_BY, columnDefinition = ComSchemaConstantName.ID_COL_DEFINITION)
    private UUID updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ComSchemaConstantName.T_UPDATE_DATE)
    private Date lastUpdateDate;

    @Override
    public void beforeSave() {
        super.beforeSave();
        if (creationDate == null) {
            creationDate = new Date();
        } else {
            lastUpdateDate = new Date();
        }
    }

    @Override
    public void beforeUpdate() {
        super.beforeUpdate();
        lastUpdateDate = new Date();
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
