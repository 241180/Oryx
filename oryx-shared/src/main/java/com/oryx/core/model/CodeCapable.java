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
@XmlType(name = "XmlCodeCapable", namespace = "http://model.element.webservice.remote.oryx.com")
@MappedSuperclass
public abstract class CodeCapable extends Identifiable {

    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
