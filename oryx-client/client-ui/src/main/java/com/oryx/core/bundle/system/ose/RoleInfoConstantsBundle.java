package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Role details")
public interface RoleInfoConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Administrator")
    public String ROLE_ADMIN();

    @DefaultStringValue("User")
    public String ROLE_USER();

    @DefaultStringValue("Name")
    public String name();

    @DefaultStringValue("Description")
    public String description();

    @DefaultStringValue("Status")
    public String status();

    @DefaultStringValue("Active")
    public String ACTIVE();

    @DefaultStringValue("Inactive")
    public String INACTIVE();

    @DefaultStringValue("Menu Set")
    public String menuSet();

    @DefaultStringValue("Menu Ids")
    public String menuIds();
}
