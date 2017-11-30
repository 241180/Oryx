package com.oryx.core.model.system.ref;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element.model.system.ref.XmlState;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlState", namespace = "http://ref.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_STATE
        , uniqueConstraints = {@UniqueConstraint(name = "UC_STATE_NAME_CNTRY_ID", columnNames = {SchemaConstantName.T_NAME
        , SchemaConstantName.T_COUNTRY_ID})}
)
public class State extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_NAME, length = SchemaConstantSize.NAME)
    private String name;

    @Column(name = SchemaConstantName.T_COUNTRY_NAME, length = SchemaConstantSize.NAME)
    private String countryName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_COUNTRY_ID)
    private Country country;
    @Transient
    private UUID countryId;

    @Column(name = SchemaConstantName.T_POSTAL_CODE, length = SchemaConstantSize.POSTAL_CODE/* , nullable = false */)
    private String postalCode;

    @Column(name = SchemaConstantName.T_LATITUDE)
    private Double latitude;

    @Column(name = SchemaConstantName.T_LONGITUDE)
    private Double longitude;

    @Column(name = SchemaConstantName.T_ALTITUDE)
    private Double altitude;

    @Override
    public Object newInstance() {
        return new State();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlState();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public UUID getCountryId() {
        return countryId;
    }

    public void setCountryId(UUID countryId) {
        this.countryId = countryId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
}