package com.oryx.core.dashboard.view.crud.frame;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.ApplicationConstantsBundle;
import com.oryx.core.frame.AbstractApplicationPanel;
import com.oryx.core.module.annotation.decl.Module;
import com.oryx.core.module.app.ApplicationModule;

@Bundle(classType = ApplicationConstantsBundle.class)
@Module(classType = ApplicationModule.class)
public class CrudPanel extends AbstractApplicationPanel {
    public CrudPanel() {
        super();
    }
}
