package com.oryx.core.bundle.system.ref;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Contact details")
public interface ContactConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Contact type")
    public String contactType();

    @DefaultStringValue("Web")
    public String WEB();

    @DefaultStringValue("Email")
    public String EMAIL();

    @DefaultStringValue("Adress")
    public String ADRESS();

    @DefaultStringValue("Contact")
    public String CONTACT();

    @DefaultStringValue("Mobile")
    public String MOBILE();

    @DefaultStringValue("Phone")
    public String PHONE();

    @DefaultStringValue("Value")
    public String value();
}
