package com.oryx.core.gui.crud.system.ose.domain;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.DomainConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.DomainTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlDomain;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = DomainConstantsBundle.class)
@AssoTypeByTokenProvider(classType = DomainTypeByTokenProvider.class)
public class DomainEditorForm extends AbstractEditor<XmlDomain> {

    public DomainEditorForm(IModule module, XmlDomain domain, SaveHandler saveHandler) {
        super(domain, saveHandler, module);
    }

    public static DomainEditorForm newInstance(IModule module, XmlDomain domain, SaveHandler saveHandler) {
        return new DomainEditorForm(module, domain, saveHandler);
    }
}