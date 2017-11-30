package com.oryx.core.module.service;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.ViewServiceConstantsBundle;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.core.module.service.sub.view.system.ose.SystemOseViewServiceModule;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = ViewServiceConstantsBundle.class)
public class ViewServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        install(SystemOseViewServiceModule.class);

        return this;
    }
}
