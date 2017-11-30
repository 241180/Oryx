package com.oryx.core.model.system.ref;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.*;
import com.oryx.remote.webservice.element.model.system.ref.XmlCountry;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlCountry", namespace = "http://ref.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_COUNTRY
        , uniqueConstraints = {@UniqueConstraint(name = "UC_CNTRY_NAME", columnNames = {SchemaConstantName.T_NAME})
        , @UniqueConstraint(name = "UC_CNTRY_CODE", columnNames = {SchemaConstantName.T_CODE})}
)
public class Country extends CancelableAndTracable {

    @Column(name = ComSchemaConstantName.T_CODE, length = ComSchemaConstantSize.CODE, updatable = false)
    private String countryCode;

    @Column(name = ComSchemaConstantName.T_LANG_CODE, length = ComSchemaConstantSize.LANG_CODE)
    private String language;

    @Column(name = SchemaConstantName.T_NAME, length = SchemaConstantSize.NAME, nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_POL_CAPITAL_ID)
    @ForeignKey(name = "FK_COUNTRY_REF_POL_CAPITAL")
    private State polCapital;
    @Transient
    private UUID polCapitalId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_ECO_CAPITAL_ID)
    @ForeignKey(name = "FK_COUNTRY_REF_ECO_CAPITAL")
    private State ecoCapital;
    @Transient
    private UUID ecoCapitalId;

    @Override
    public Object newInstance() {
        return new Country();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlCountry();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getPolCapital() {
        return polCapital;
    }

    public void setPolCapital(State polCapital) {
        this.polCapital = polCapital;
    }

    public UUID getPolCapitalId() {
        return polCapitalId;
    }

    public void setPolCapitalId(UUID polCapitalId) {
        this.polCapitalId = polCapitalId;
    }

    public State getEcoCapital() {
        return ecoCapital;
    }

    public void setEcoCapital(State ecoCapital) {
        this.ecoCapital = ecoCapital;
    }

    public UUID getEcoCapitalId() {
        return ecoCapitalId;
    }

    public void setEcoCapitalId(UUID ecoCapitalId) {
        this.ecoCapitalId = ecoCapitalId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}