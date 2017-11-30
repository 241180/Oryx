package com.oryx.core.gui.crud.system.ref.uid;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.UidConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.UidTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlUid;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = UidConstantsBundle.class)
@AssoTypeByTokenProvider(classType = UidTypeByTokenProvider.class)
public class UidEditorForm extends AbstractEditor<XmlUid> {

    public UidEditorForm(IModule module, XmlUid uid, SaveHandler saveHandler) {
        super(uid, saveHandler, module);
    }

    public static UidEditorForm newInstance(IModule module, XmlUid uid, SaveHandler saveHandler) {
        return new UidEditorForm(module, uid, saveHandler);
    }
}