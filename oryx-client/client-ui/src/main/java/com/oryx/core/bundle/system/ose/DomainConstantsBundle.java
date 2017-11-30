package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Domain details")
public interface DomainConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("code")
    public String domainCode();

    @DefaultStringValue("Description")
    public String description();

    @DefaultStringValue("Reference")
    public String reference();
}
