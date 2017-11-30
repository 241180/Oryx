package com.oryx.core.gui.crud.bu.billing.billItem;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.BillItemConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillItemTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = BillItemConstantsBundle.class)
@AssoEntity(classType = XmlBillItem.class)
@AssoTypeByTokenProvider(classType = BillItemTypeByTokenProvider.class)
public class BillItemGridForm extends AbstractGrid<XmlBillItem> {

    public BillItemGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlBillItem bean, AbstractEditor.SaveHandler saveHandler) {
        return BillItemEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}