package com.oryx.core.gui.crud.bu.billing.billItem;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillItemTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;

@AssoEntity(classType = XmlBillItem.class)
@AssoGridForm(classType = BillItemGridForm.class)
@AssoTypeByTokenProvider(classType = BillItemTypeByTokenProvider.class)
public class BillItemForm extends AbstractCrudFormLayout<XmlBillItem> {

    public BillItemForm(IModule module) {
        super(module);
    }
}
