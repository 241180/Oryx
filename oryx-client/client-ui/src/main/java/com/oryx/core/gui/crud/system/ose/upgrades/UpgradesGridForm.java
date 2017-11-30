package com.oryx.core.gui.crud.system.ose.upgrades;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.UpgradesConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.UpgradesTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlUpgrades;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = UpgradesConstantsBundle.class)
@AssoEntity(classType = XmlUpgrades.class)
@AssoTypeByTokenProvider(classType = UpgradesTypeByTokenProvider.class)
public class UpgradesGridForm extends AbstractGrid<XmlUpgrades> {

    public UpgradesGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlUpgrades bean, AbstractEditor.SaveHandler saveHandler) {
        return UpgradesEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}