package com.oryx.core.gui.crud.bu.billing.account;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.AccountConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.AccountTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = AccountConstantsBundle.class)
@AssoEntity(classType = XmlAccount.class)
@AssoTypeByTokenProvider(classType = AccountTypeByTokenProvider.class)
public class AccountGridForm extends AbstractGrid<XmlAccount> {

    public AccountGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlAccount bean, AbstractEditor.SaveHandler saveHandler) {
        return AccountEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}