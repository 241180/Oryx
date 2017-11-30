package com.oryx.core.gui.crud.bu.billing.account;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.AccountConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.AccountTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = AccountConstantsBundle.class)
@AssoTypeByTokenProvider(classType = AccountTypeByTokenProvider.class)
public class AccountEditorForm extends AbstractEditor<XmlAccount> {

    public AccountEditorForm(IModule module, XmlAccount account, SaveHandler saveHandler) {
        super(account, saveHandler, module);
    }

    public static AccountEditorForm newInstance(IModule module, XmlAccount account, SaveHandler saveHandler) {
        return new AccountEditorForm(module, account, saveHandler);
    }
}