package com.oryx.core.gui.crud.system.ose.upgrades;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.UpgradesConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.UpgradesTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlUpgrades;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = UpgradesConstantsBundle.class)
@AssoTypeByTokenProvider(classType = UpgradesTypeByTokenProvider.class)
public class UpgradesEditorForm extends AbstractEditor<XmlUpgrades> {

    public UpgradesEditorForm(IModule module, XmlUpgrades upgrades, SaveHandler saveHandler) {
        super(upgrades, saveHandler, module);
    }

    public static UpgradesEditorForm newInstance(IModule module, XmlUpgrades upgrades, SaveHandler saveHandler) {
        return new UpgradesEditorForm(module, upgrades, saveHandler);
    }

}