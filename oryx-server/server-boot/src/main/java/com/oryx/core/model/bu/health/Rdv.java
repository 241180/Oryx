package com.oryx.core.model.bu.health;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.core.model.SchemaConstantSize;
import com.oryx.core.model.system.ref.Person;
import com.oryx.remote.webservice.element._enum.XmlEnumRdvStatus;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlRdv", namespace = "http://health.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_RDV
        , uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
)
public class Rdv extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_RDV_DATE, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rdvDateTime;

    @Column(name = SchemaConstantName.T_RDV_DURATION, nullable = false)
    private Integer duration; // in min

    @Enumerated(EnumType.STRING)
    @Column(name = SchemaConstantName.T_STATUS, length = SchemaConstantSize.CODE/*, nullable = false*/)
    private XmlEnumRdvStatus status;

    @Column(name = SchemaConstantName.T_REASON, length = SchemaConstantSize.L_DESCRIPTION/*, nullable = false*/)
    private String reason;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_HOST_ID)
    @ForeignKey(name = "FK_RDV_REF_HOST_PERSON")
    private Person host;
    @Transient
    private UUID hostId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = SchemaConstantName.T_GUEST_ID)
    @ForeignKey(name = "FK_RDV_REF_GUEST_PERSON")
    private Person guest;
    @Transient
    private UUID guestId;

    @Override
    public Object newInstance() {
        return new Rdv();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlRdv();
    }

    public XmlEnumRdvStatus getStatus() {
        return status;
    }

    public void setStatus(XmlEnumRdvStatus status) {
        this.status = status;
    }

    public Date getRdvDateTime() {
        return rdvDateTime;
    }

    public void setRdvDateTime(Date rdvDateTime) {
        this.rdvDateTime = rdvDateTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

    public UUID getHostId() {
        return hostId;
    }

    public void setHostId(UUID hostId) {
        this.hostId = hostId;
    }

    public Person getGuest() {
        return guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    public UUID getGuestId() {
        return guestId;
    }

    public void setGuestId(UUID guestId) {
        this.guestId = guestId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}