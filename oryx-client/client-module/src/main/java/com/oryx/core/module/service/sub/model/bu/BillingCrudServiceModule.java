package com.oryx.core.module.service.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.bu.billing.AccountServiceDelegate;
import com.oryx.core.delegate.bu.billing.BillItemServiceDelegate;
import com.oryx.core.delegate.bu.billing.BillServiceDelegate;
import com.oryx.core.delegate.bu.billing.InstanceServiceDelegate;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.AccountServices;
import com.oryx.remote.webservice.element._enum.BillItemServices;
import com.oryx.remote.webservice.element._enum.BillServices;
import com.oryx.remote.webservice.element._enum.InstanceServices;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;
import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class BillingCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(XmlBill.class, BillServiceDelegate.class, BillServices.class);
        this.bindService(XmlBillItem.class, BillItemServiceDelegate.class, BillItemServices.class);
        this.bindService(XmlInstance.class, InstanceServiceDelegate.class, InstanceServices.class);
        this.bindService(XmlAccount.class, AccountServiceDelegate.class, AccountServices.class);

        return this;
    }
}
