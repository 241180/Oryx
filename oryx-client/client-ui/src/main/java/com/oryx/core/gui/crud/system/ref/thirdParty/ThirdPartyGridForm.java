package com.oryx.core.gui.crud.system.ref.thirdParty;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.ThirdPartyConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.ThirdPartyTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlThirdParty;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ThirdPartyConstantsBundle.class)
@AssoEntity(classType = XmlThirdParty.class)
@AssoTypeByTokenProvider(classType = ThirdPartyTypeByTokenProvider.class)
public class ThirdPartyGridForm extends AbstractGrid<XmlThirdParty> {

    public ThirdPartyGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlThirdParty bean, AbstractEditor.SaveHandler saveHandler) {
        return ThirdPartyEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}