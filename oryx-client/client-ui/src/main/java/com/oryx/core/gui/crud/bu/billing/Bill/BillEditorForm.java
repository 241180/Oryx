package com.oryx.core.gui.crud.bu.billing.Bill;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.BillConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = BillConstantsBundle.class)
@AssoTypeByTokenProvider(classType = BillTypeByTokenProvider.class)
public class BillEditorForm extends AbstractEditor<XmlBill> {

    public BillEditorForm(IModule module, XmlBill bill, SaveHandler saveHandler) {
        super(bill, saveHandler, module);
    }

    public static BillEditorForm newInstance(IModule module, XmlBill bill, SaveHandler saveHandler) {
        return new BillEditorForm(module, bill, saveHandler);
    }
}