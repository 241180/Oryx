package com.oryx.core.module.ui;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.ViewConstantsBundle;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.core.module.ui.sub.view.system.ose.SystemOseViewUIModule;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = ViewConstantsBundle.class)
public class ViewUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        install(SystemOseViewUIModule.class);

        return this;
    }
}
