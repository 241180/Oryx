package com.oryx.core.model.system.ref;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlAdress", namespace = "http://ref.system.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_ADDRESS
        , uniqueConstraints = {@UniqueConstraint(name = "UC_CNTRY_STATE_STREET", columnNames = {SchemaConstantName.T_COUNTRY_ID
        , SchemaConstantName.T_STATE_ID
        , SchemaConstantName.T_STREET})
}
)
public class Adress extends CancelableAndTracable {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_COUNTRY_ID, nullable = false)
    @ForeignKey(name = "FK_ADRESS_REF_COUNTRY")
    private Country country;
    @Transient
    private UUID countryId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_STATE_ID, nullable = false)
    @ForeignKey(name = "FK_ADRESS_REF_STATE")
    private State state;
    @Transient
    private UUID stateId;

    @Column(name = SchemaConstantName.T_STREET, length = SchemaConstantSize.STREET, nullable = false)
    private String street;
    @Column(name = SchemaConstantName.T_LATITUDE)
    private double latitude;
    @Column(name = SchemaConstantName.T_LONGITUDE)
    private double longitude;

    @Override
    public Object newInstance() {
        return new Adress();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlAdress();
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}