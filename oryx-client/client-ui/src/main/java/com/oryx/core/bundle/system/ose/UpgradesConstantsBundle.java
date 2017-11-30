package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Upgrade details")
public interface UpgradesConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Software version")
    public String softwareVersion();

    @DefaultStringValue("Description")
    public String descriptionTextArea();

    @DefaultStringValue("Code")
    public String upgradeCode();
}
