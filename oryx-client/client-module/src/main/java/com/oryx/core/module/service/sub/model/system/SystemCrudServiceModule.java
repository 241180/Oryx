package com.oryx.core.module.service.sub.model.system;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.core.module.service.sub.model.system.msg.SystemMsgCrudServiceModule;
import com.oryx.core.module.service.sub.model.system.ose.SystemOseCrudServiceModule;
import com.oryx.core.module.service.sub.model.system.ref.SystemRefCrudServiceModule;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class SystemCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        install(SystemOseCrudServiceModule.class);
        install(SystemRefCrudServiceModule.class);
        install(SystemMsgCrudServiceModule.class);

        return this;
    }
}
