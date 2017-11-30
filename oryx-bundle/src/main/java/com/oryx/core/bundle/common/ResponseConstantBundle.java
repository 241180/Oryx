package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface ResponseConstantBundle extends ICommonConstantBundle {
    @DefaultStringValue("Yes")
    public String YES();

    @DefaultStringValue("No")
    public String NO();

    @DefaultStringValue("Ok")
    public String OK();

    @DefaultStringValue("Always")
    public String ALWAYS();
}
