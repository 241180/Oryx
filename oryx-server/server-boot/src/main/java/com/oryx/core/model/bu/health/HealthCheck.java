package com.oryx.core.model.bu.health;

import com.oryx.core.annotation.decl.GenDataRepository;
import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenServiceDelegate;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.CancelableAndTracable;
import com.oryx.core.model.SchemaConstantName;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlHealthCheck", namespace = "http://health.bu.model.element.webservice.remote.oryx.com")
@GenServiceDelegate
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenDataRepository(extendType = "org.springframework.data.repository.PagingAndSortingRepository")
@GenEntityEnumeration
@Entity
@Table(
        name = SchemaConstantName.T_HEALTH_CHECK
        /*, uniqueConstraints = {
        @UniqueConstraint(name = "UC_DATE_HOST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_HOST_ID}),
        @UniqueConstraint(name = "UC_DATE_GUEST"
                , columnNames = {SchemaConstantName.T_RDV_DATE, SchemaConstantName.T_GUEST_ID})}
                */
)
public class HealthCheck extends CancelableAndTracable {
    @Column(name = SchemaConstantName.T_RDV_DATE, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date healthCheckDateTime;

    /*
    Poid
Kg
Taille
cm
PAS
mmHg
PAD
mmHg
Pouls
bpm
Temp
°C
Glycémie
g/l
Cholést.
mmol/l
     */


    @Override
    public Object newInstance() {
        return new HealthCheck();
    }

    @Override
    public Object newXmlInstance() {
        return new XmlHealthCheck();
    }
}