package com.oryx.core.gui.crud.bu.billing.billItem;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.BillItemConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillItemTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = BillItemConstantsBundle.class)
@AssoTypeByTokenProvider(classType = BillItemTypeByTokenProvider.class)
public class BillItemEditorForm extends AbstractEditor<XmlBillItem> {

    public BillItemEditorForm(IModule module, XmlBillItem bill, SaveHandler saveHandler) {
        super(bill, saveHandler, module);
    }

    public static BillItemEditorForm newInstance(IModule module, XmlBillItem bill, SaveHandler saveHandler) {
        return new BillItemEditorForm(module, bill, saveHandler);
    }
}