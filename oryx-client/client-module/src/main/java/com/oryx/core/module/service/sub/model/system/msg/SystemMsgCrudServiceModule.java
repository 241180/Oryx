package com.oryx.core.module.service.sub.model.system.msg;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.system.msg.ErrorMessageServiceDelegate;
import com.oryx.core.delegate.system.msg.TranslationServiceDelegate;
import com.oryx.core.delegate.system.ref.AuthenticationServiceDelegate;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IAuthentication;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.AuthenticationServices;
import com.oryx.remote.webservice.element._enum.ErrorMessageServices;
import com.oryx.remote.webservice.element._enum.TranslationServices;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class SystemMsgCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(IAuthentication.class, AuthenticationServiceDelegate.class, AuthenticationServices.class);

        this.bindService(XmlTranslation.class, TranslationServiceDelegate.class, TranslationServices.class);
        this.bindService(XmlErrorMessage.class, ErrorMessageServiceDelegate.class, ErrorMessageServices.class);

        return this;
    }
}
