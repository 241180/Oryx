package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Annex details")
public interface AnnexConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Table")
    public String tableCode();

    @DefaultStringValue("Langue")
    public String langage();

    @DefaultStringValue("Valeur")
    public String value();

    @DefaultStringValue("Description")
    public String description();

    @DefaultStringValue("Référence")
    public String reference();
}
