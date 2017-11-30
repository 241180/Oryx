package com.oryx.core.gui.crud.bu.billing.Bill;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;

@AssoEntity(classType = XmlBill.class)
@AssoGridForm(classType = BillGridForm.class)
@AssoTypeByTokenProvider(classType = BillTypeByTokenProvider.class)
public class BillForm extends AbstractCrudFormLayout<XmlBill> {

    public BillForm(IModule module) {
        super(module);
    }
}
