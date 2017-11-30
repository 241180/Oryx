package com.oryx.core.model.system.msg;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;

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
@XmlType(name = "XmlErrorMessage", namespace = "http://msg.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_ERROR_MESSAGE
        , uniqueConstraints = {@UniqueConstraint(name = "UC_ERR_MSG_CODE_LANG_CODE"
        , columnNames = {SchemaConstantName.T_CODE, SchemaConstantName.T_LANGUAGE_CODE})}
)
public class ErrorMessage extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_CODE, length = SchemaConstantSize.CODE, nullable = false)
    private String messageCode;

    @Column(name = SchemaConstantName.T_LANGUAGE_CODE, length = SchemaConstantSize.LANG_CODE, nullable = false)
    private XmlEnumLanguage language;

    @Column(name = SchemaConstantName.T_MEANING, length = SchemaConstantSize.L_DESCRIPTION, nullable = false)
    private String meaning;

    @Override
    public Object newInstance() {
        return new ErrorMessage();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlErrorMessage();
    }

    public XmlEnumLanguage getLanguage() {
        return language;
    }

    public void setLanguage(XmlEnumLanguage language) {
        this.language = language;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}