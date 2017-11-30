package com.oryx.core.bundle.bu;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx Application")
public interface HealthCrudUIConstantsBundle extends ICommonConstantBundle {
    //HEALTH
    @DefaultStringValue("Rdv management")
    public String XmlRdv();

    @DefaultStringValue("Health check management")
    public String XmlHealthCheck();

    @DefaultStringValue("Patient management")
    public String XmlPatient();
}
