package com.oryx.core.gui.crud.system.ose.task;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.TaskConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.TaskTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlTask;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = TaskConstantsBundle.class)
@AssoEntity(classType = XmlTask.class)
@AssoTypeByTokenProvider(classType = TaskTypeByTokenProvider.class)
public class TaskGridForm extends AbstractGrid<XmlTask> {

    public TaskGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlTask bean, AbstractEditor.SaveHandler saveHandler) {
        return TaskEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}