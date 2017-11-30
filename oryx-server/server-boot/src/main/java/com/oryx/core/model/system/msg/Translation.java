package com.oryx.core.model.system.msg;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element._enum.XmlEnumLanguage;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;

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
@XmlType(name = "XmlTranslation", namespace = "http://msg.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_TRANSLATION
        , uniqueConstraints = {@UniqueConstraint(name = "UC_TRAN_CODE_LANG_CODE", columnNames = {SchemaConstantName.T_BUNDLE, SchemaConstantName.T_LANGUAGE_CODE, SchemaConstantName.T_TEXT})
}
)
public class Translation extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_BUNDLE, nullable = false, length = SchemaConstantSize.M_DESCRIPTION)
    private String bundleOrigin;

    @Column(name = SchemaConstantName.T_LANGUAGE_CODE, length = SchemaConstantSize.LANG_CODE, nullable = false)
    private XmlEnumLanguage language;

    @Column(name = SchemaConstantName.T_TEXT, length = SchemaConstantSize.M_DESCRIPTION, nullable = false)
    private String text;

    @Column(name = SchemaConstantName.T_TEXT_TRANSLATION, length = SchemaConstantSize.M_DESCRIPTION, nullable = false)
    private String translation;

    @Override
    public Object newInstance() {
        return new Translation();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlTranslation();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getBundleOrigin() {
        return bundleOrigin;
    }

    public void setBundleOrigin(String bundleOrigin) {
        this.bundleOrigin = bundleOrigin;
    }

    public XmlEnumLanguage getLanguage() {
        return language;
    }

    public void setLanguage(XmlEnumLanguage language) {
        this.language = language;
    }
}