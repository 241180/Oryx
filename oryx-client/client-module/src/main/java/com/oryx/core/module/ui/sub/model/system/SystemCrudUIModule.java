package com.oryx.core.module.ui.sub.model.system;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.core.module.ui.sub.model.system.msg.SystemMsgCrudUIModule;
import com.oryx.core.module.ui.sub.model.system.ose.SystemOseCrudUIModule;
import com.oryx.core.module.ui.sub.model.system.ref.SystemRefCrudUIModule;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class SystemCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        install(SystemMsgCrudUIModule.class);
        install(SystemOseCrudUIModule.class);
        install(SystemRefCrudUIModule.class);

        return this;
    }
}
