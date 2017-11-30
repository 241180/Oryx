package com.oryx.core.module.ui.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.gui.crud.bu.billing.Bill.BillForm;
import com.oryx.core.gui.crud.bu.billing.Instance.InstanceForm;
import com.oryx.core.gui.crud.bu.billing.account.AccountForm;
import com.oryx.core.gui.crud.bu.billing.billItem.BillItemForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;
import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class BillingCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlBill.class, BillForm.class);
        this.bindFormLayout(XmlInstance.class, InstanceForm.class);
        this.bindFormLayout(XmlBillItem.class, BillItemForm.class);
        this.bindFormLayout(XmlAccount.class, AccountForm.class);

        return this;
    }
}
