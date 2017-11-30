package com.oryx.core.bundle.bu.health;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Patient details")
public interface PatientConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Patient")
    public String XmlPatient();
}
