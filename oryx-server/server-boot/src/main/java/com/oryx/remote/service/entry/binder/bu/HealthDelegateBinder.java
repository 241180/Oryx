package com.oryx.remote.service.entry.binder.bu;

import com.oryx.core.binder.delegate.AbstractAutowiredDelegateBinder;
import com.oryx.core.service.bu.health.HealthCheckServiceDelegate;
import com.oryx.core.service.bu.health.PatientServiceDelegate;
import com.oryx.core.service.bu.health.RdvServiceDelegate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smbarki on 31/03/2017.
 */

@Service
public class HealthDelegateBinder extends AbstractAutowiredDelegateBinder {
    final static Logger logger = Logger.getLogger(HealthDelegateBinder.class);

    @Autowired
    private RdvServiceDelegate rdvServiceDelegate;

    @Autowired
    private HealthCheckServiceDelegate healthCheckServiceDelegate;

    @Autowired
    private PatientServiceDelegate patientServiceDelegate;
}
