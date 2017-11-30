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
@XmlType(name = "XmlTypeCapable", namespace = "http://model.element.webservice.remote.oryx.com")
@MappedSuperclass
public abstract class TypeCapable extends CodeCapable {
    @Column(name = ComSchemaConstantName.T_MEANING, length = ComSchemaConstantSize.S_DESCRIPTION)
    private String meaning;

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
