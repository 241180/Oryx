package com.oryx.core.module.service;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.core.module.service.sub.model.bu.BillingCrudServiceModule;
import com.oryx.core.module.service.sub.model.bu.HealthCrudServiceModule;
import com.oryx.core.module.service.sub.model.bu.SaleCrudServiceModule;
import com.oryx.core.module.service.sub.model.bu.StockCrudServiceModule;
import com.oryx.core.module.service.sub.model.misc.MiscCrudServiceModule;
import com.oryx.core.module.service.sub.model.system.SystemCrudServiceModule;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class CrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        install(SystemCrudServiceModule.class);
        install(HealthCrudServiceModule.class);
        install(BillingCrudServiceModule.class);
        install(SaleCrudServiceModule.class);
        install(StockCrudServiceModule.class);
        install(MiscCrudServiceModule.class);

        return this;
    }
}
