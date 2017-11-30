package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("FieldProcessParam details")
public interface FieldProcessParamConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Process code")
    public String processCode();

    @DefaultStringValue("field")
    public String fieldCode();

    @DefaultStringValue("Description")
    public String description();

    @DefaultStringValue("Reference")
    public String processRef();

    @DefaultStringValue("Process type")
    public String processType();

    @DefaultStringValue("Process result")
    public String processResult();
}
