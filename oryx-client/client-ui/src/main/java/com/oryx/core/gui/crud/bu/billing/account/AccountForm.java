package com.oryx.core.gui.crud.bu.billing.account;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.AccountTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;

@AssoEntity(classType = XmlAccount.class)
@AssoGridForm(classType = AccountGridForm.class)
@AssoTypeByTokenProvider(classType = AccountTypeByTokenProvider.class)
public class AccountForm extends AbstractCrudFormLayout<XmlAccount> {

    public AccountForm(IModule module) {
        super(module);
    }
}
