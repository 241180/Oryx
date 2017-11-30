package com.oryx.core.gui.crud.system.ose.task;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.TaskConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.TaskTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlTask;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = TaskConstantsBundle.class)
@AssoTypeByTokenProvider(classType = TaskTypeByTokenProvider.class)
public class TaskEditorForm extends AbstractEditor<XmlTask> {

    public TaskEditorForm(IModule module, XmlTask task, SaveHandler saveHandler) {
        super(task, saveHandler, module);
    }

    public static TaskEditorForm newInstance(IModule module, XmlTask task, SaveHandler saveHandler) {
        return new TaskEditorForm(module, task, saveHandler);
    }
}