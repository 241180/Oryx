package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Codification details")
public interface CodificationConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Internal code")
    public String internalCode();

    @DefaultStringValue("External Code")
    public String externalCode();

    @DefaultStringValue("Start date")
    public String startDate();

    @DefaultStringValue("End Date")
    public String endDate();

    @DefaultStringValue("Server code")
    public String serverCode();
}
