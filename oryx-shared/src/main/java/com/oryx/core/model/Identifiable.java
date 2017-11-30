package com.oryx.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

/**
 * Created by 241180 on 26/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlIdentifiable", namespace = "http://model.element.webservice.remote.oryx.com")
@MappedSuperclass
public abstract class Identifiable extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = ComSchemaConstantName.T_ID, updatable = false, nullable = false, columnDefinition = ComSchemaConstantName.ID_COL_DEFINITION)
    private UUID id;

    @Column(name = ComSchemaConstantName.T_VERSION)
    private Integer version;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public void beforeSave() {
        super.beforeSave();
        if (version == null) {
            version = 1;
        } else {
            version++;
        }
    }

    @Override
    public void beforeUpdate() {
        super.beforeUpdate();
        if (version == null) {
            version = 1;
        } else {
            version++;
        }
    }
}
