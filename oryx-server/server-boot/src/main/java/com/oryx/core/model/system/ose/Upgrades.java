package com.oryx.core.model.system.ose;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.core.model.Tracable;
import com.oryx.remote.webservice.element.model.system.ose.XmlUpgrades;

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
@XmlType(name = "XmlUpgrades", namespace = "http://ose.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_UPGRADES
        , uniqueConstraints = {@UniqueConstraint(name = "UC_UPGRADES_CODE_SFT_VERSION", columnNames = {SchemaConstantName.T_CODE
        , SchemaConstantName.T_SOFTWARE_VERSION})}
)
public class Upgrades extends Tracable {
    @Column(name = SchemaConstantName.T_CODE, length = SchemaConstantSize.CODE, nullable = false)
    private String upgradeCode;

    @Column(name = SchemaConstantName.T_SOFTWARE_VERSION, length = SchemaConstantSize.VERSION, nullable = false)
    private String softwareVersion;

    @Column(name = SchemaConstantName.T_DESCRIPTION, length = SchemaConstantSize.M_DESCRIPTION)
    private String descriptionTextArea;

    @Override
    public Object newInstance() {
        return new Upgrades();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlUpgrades();
    }

    public String getVersion() {
        return softwareVersion;
    }

    public void setVersion(String version) {
        this.softwareVersion = version;
    }

    public String getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(String descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getUpgradeCode() {
        return upgradeCode;
    }

    public void setUpgradeCode(String upgradeCode) {
        this.upgradeCode = upgradeCode;
    }
}