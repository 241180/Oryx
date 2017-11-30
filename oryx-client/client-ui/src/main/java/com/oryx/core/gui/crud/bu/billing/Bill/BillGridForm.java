package com.oryx.core.gui.crud.bu.billing.Bill;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.BillConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = BillConstantsBundle.class)
@AssoEntity(classType = XmlBill.class)
@AssoTypeByTokenProvider(classType = BillTypeByTokenProvider.class)
public class BillGridForm extends AbstractGrid<XmlBill> {

    public BillGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlBill bean, AbstractEditor.SaveHandler saveHandler) {
        return BillEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}