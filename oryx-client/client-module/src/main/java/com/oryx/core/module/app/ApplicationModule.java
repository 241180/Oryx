package com.oryx.core.module.app;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.ApplicationModuleConstantsBundle;
import com.oryx.core.context.IClientContext;
import com.oryx.core.context.ITaskContext;
import com.oryx.core.delegate.IDelegateKey;
import com.oryx.core.delegate.system.ref.AuthenticationServiceDelegate;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.module.AbstractModule;
import com.oryx.core.module.IAuthentication;
import com.oryx.core.module.IModule;
import com.oryx.core.module.service.CrudServiceModule;
import com.oryx.core.module.service.ViewServiceModule;
import com.oryx.core.module.ui.CrudUIModule;
import com.oryx.core.module.ui.ViewUIModule;
import com.oryx.core.service.ParameterService;
import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element.model.system.ose.XmlMenu;
import com.oryx.remote.webservice.element.model.system.ose.XmlRoleInfo;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = ApplicationModuleConstantsBundle.class)
public class ApplicationModule extends AbstractModule {

    @Override
    public IModule configure() {
        super.configure();
        install(CrudServiceModule.class);
        install(ViewServiceModule.class);

        install(CrudUIModule.class);
        install(ViewUIModule.class);


        return this;
    }

    @Override
    public IModule initializeServices() {
        super.initializeServices();

        CommonServiceHelper.bindParameterService(new ParameterService(this));

        return this;
    }

    @Override
    public Object AuthentificateAndLoadContext(String login, String password, String sessionToken) {
        if ((login != null && password != null) || sessionToken != null) {
            AuthenticationServiceDelegate delegate = (AuthenticationServiceDelegate) this.getBoundObject(IDelegateKey.class, IAuthentication.class);
            XmlUser xmlUser = delegate.authenticate(login, password, sessionToken);
            if (xmlUser != null) {
                //Load context
                IClientContext.loadContext(this);

                if (xmlUser.getRoleSet() != null && !xmlUser.getRoleSet().isEmpty()) {
                    for (XmlRoleInfo roleInfo : xmlUser.getRoleSet()) {
                        if (roleInfo.getStatus() == XmlEnumStatus.ACTIVE && roleInfo.getMenuSet() != null && !roleInfo.getMenuSet().isEmpty()) {
                            for (XmlMenu menu : roleInfo.getMenuSet()) {
                                if (menu.getStatus() == XmlEnumStatus.ACTIVE && menu.getTaskSet() != null && !menu.getTaskSet().isEmpty()) {
                                    ITaskContext.updateTaskMap(xmlUser.getId(), IClientContext.convertToContextTaskList(menu.getTaskSet()));
                                }
                            }
                        }
                    }
                }

                return xmlUser;
            }
        }
        return null;
    }
}
