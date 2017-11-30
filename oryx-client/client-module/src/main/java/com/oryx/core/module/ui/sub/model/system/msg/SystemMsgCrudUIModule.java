package com.oryx.core.module.ui.sub.model.system.msg;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.gui.crud.system.msg.errorMessage.ErrorMessageForm;
import com.oryx.core.gui.crud.system.msg.translation.TranslationForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class SystemMsgCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlTranslation.class, TranslationForm.class);
        this.bindFormLayout(XmlErrorMessage.class, ErrorMessageForm.class);

        return this;
    }
}
