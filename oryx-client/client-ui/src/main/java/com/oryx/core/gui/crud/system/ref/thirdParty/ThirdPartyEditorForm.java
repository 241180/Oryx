package com.oryx.core.gui.crud.system.ref.thirdParty;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.ThirdPartyConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.ThirdPartyTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlThirdParty;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ThirdPartyConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ThirdPartyTypeByTokenProvider.class)
public class ThirdPartyEditorForm extends AbstractEditor<XmlThirdParty> {

    public ThirdPartyEditorForm(IModule module, XmlThirdParty thirdparty, SaveHandler saveHandler) {
        super(thirdparty, saveHandler, module);
    }

    public static ThirdPartyEditorForm newInstance(IModule module, XmlThirdParty thirdparty, SaveHandler saveHandler) {
        return new ThirdPartyEditorForm(module, thirdparty, saveHandler);
    }
}