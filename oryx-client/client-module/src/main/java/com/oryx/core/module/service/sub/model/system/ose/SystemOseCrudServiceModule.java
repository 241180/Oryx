package com.oryx.core.module.service.sub.model.system.ose;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.system.ose.*;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.*;
import com.oryx.remote.webservice.element.model.system.ose.*;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class SystemOseCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(XmlAnnex.class, AnnexServiceDelegate.class, AnnexServices.class);
        this.bindService(XmlCodification.class, CodificationServiceDelegate.class, CodificationServices.class);
        this.bindService(XmlDomain.class, DomainServiceDelegate.class, DomainServices.class);
        this.bindService(XmlFieldProcessParam.class, FieldProcessParamServiceDelegate.class, FieldProcessParamServices.class);
        this.bindService(XmlMenu.class, MenuServiceDelegate.class, MenuServices.class);
        this.bindService(XmlRoleInfo.class, RoleInfoServiceDelegate.class, RoleInfoServices.class);
        this.bindService(XmlTask.class, TaskServiceDelegate.class, TaskServices.class);
        this.bindService(XmlUpgrades.class, UpgradesServiceDelegate.class, UpgradesServices.class);
        this.bindService(XmlUser.class, UserServiceDelegate.class, UserServices.class);
        this.bindService(XmlParameter.class, ParameterServiceDelegate.class, ParameterServices.class);

        return this;
    }
}
