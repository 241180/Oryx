package com.oryx.core.module.ui.sub.model.system.ose;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.gui.crud.system.ose.annex.AnnexForm;
import com.oryx.core.gui.crud.system.ose.codification.CodificationForm;
import com.oryx.core.gui.crud.system.ose.domain.DomainForm;
import com.oryx.core.gui.crud.system.ose.fieldProcessParam.FieldProcessParamForm;
import com.oryx.core.gui.crud.system.ose.menu.MenuForm;
import com.oryx.core.gui.crud.system.ose.parameter.ParameterForm;
import com.oryx.core.gui.crud.system.ose.roleInfo.RoleInfoForm;
import com.oryx.core.gui.crud.system.ose.task.TaskForm;
import com.oryx.core.gui.crud.system.ose.upgrades.UpgradesForm;
import com.oryx.core.gui.crud.system.ose.user.UserForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.model.system.ose.*;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class SystemOseCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlAnnex.class, AnnexForm.class);
        this.bindFormLayout(XmlCodification.class, CodificationForm.class);
        this.bindFormLayout(XmlDomain.class, DomainForm.class);
        this.bindFormLayout(XmlFieldProcessParam.class, FieldProcessParamForm.class);
        this.bindFormLayout(XmlMenu.class, MenuForm.class);
        this.bindFormLayout(XmlRoleInfo.class, RoleInfoForm.class);
        this.bindFormLayout(XmlTask.class, TaskForm.class);
        this.bindFormLayout(XmlUpgrades.class, UpgradesForm.class);
        this.bindFormLayout(XmlUser.class, UserForm.class);
        this.bindFormLayout(XmlParameter.class, ParameterForm.class);

        return this;
    }
}
