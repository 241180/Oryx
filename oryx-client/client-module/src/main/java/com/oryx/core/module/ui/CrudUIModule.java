package com.oryx.core.module.ui;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.core.module.ui.sub.model.bu.BillingCrudUIModule;
import com.oryx.core.module.ui.sub.model.bu.HealthCrudUIModule;
import com.oryx.core.module.ui.sub.model.bu.SaleCrudUIModule;
import com.oryx.core.module.ui.sub.model.bu.StockCrudUIModule;
import com.oryx.core.module.ui.sub.model.system.SystemCrudUIModule;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class CrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        install(SystemCrudUIModule.class);
        install(HealthCrudUIModule.class);
        install(BillingCrudUIModule.class);
        install(SaleCrudUIModule.class);
        install(StockCrudUIModule.class);

        return this;
    }
}
