package com.oryx.core.module.service.sub.model.misc;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.system.ref.AuthenticationServiceDelegate;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IAuthentication;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.AuthenticationServices;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class MiscCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(IAuthentication.class, AuthenticationServiceDelegate.class, AuthenticationServices.class);

        return this;
    }
}
