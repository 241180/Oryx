package com.oryx.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by SAMI on 25/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlDomainCapable", namespace = "http://model.element.webservice.remote.oryx.com")
@MappedSuperclass
public abstract class DomainCapable extends Identifiable {

    @Column(name = ComSchemaConstantName.T_DOMAIN_CODE, length = ComSchemaConstantSize.CODE, updatable = false)
    private String domainScope;

    public String getDomainScope() {
        return domainScope;
    }

    public void setDomainScope(String domainScope) {
        this.domainScope = domainScope;
    }
}
