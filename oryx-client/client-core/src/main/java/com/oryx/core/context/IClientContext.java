package com.oryx.core.context;

import com.oryx.core.bundle.translation.IBundleTranslation;
import com.oryx.core.delegate.IDelegateKey;
import com.oryx.core.enums.EnumLanguage;
import com.oryx.core.module.IModule;
import com.oryx.core.service.ICrudServiceDelegate;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;
import com.oryx.remote.webservice.element.model.system.ose.XmlTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smbarki on 04/09/2017.
 */
public interface IClientContext {
    public static final List<XmlTranslation> contextTranslationList = new ArrayList<>();
    public static final List<ITaskContext.Task> contextTaskList = new ArrayList<>();

    public static List<XmlTranslation> getTranslations() {
        return contextTranslationList.size() > 0 ? contextTranslationList : null;
    }

    public static List<ITaskContext.Task> getTasks() {
        return contextTaskList.size() > 0 ? contextTaskList : null;
    }

    public static void loadTranslations(IModule module) {
        if (!IBundleTranslation.isLoaded()) {
            ICrudServiceDelegate delegate = (ICrudServiceDelegate) module.getBoundObject(IDelegateKey.class, XmlTranslation.class);
            delegate.findAll();
            List<XmlTranslation> loadedTranslations = delegate.getResponseBeans();
            if (loadedTranslations != null && loadedTranslations.size() > 0) {
                contextTranslationList.clear();
                contextTranslationList.addAll(loadedTranslations);
            }

            if (loadedTranslations != null && !loadedTranslations.isEmpty()) {
                for (XmlTranslation tr : loadedTranslations) {
                    IBundleTranslation.addTranslation(EnumLanguage.valueOf(tr.getLanguage().name()), tr.getBundleOrigin(), tr.getText(), tr.getTranslation());
                }
            }
        }
    }

    public static List<ITaskContext.Task> convertToContextTaskList(List<XmlTask> tasks) {
        List<ITaskContext.Task> result = new ArrayList<>();
        for (XmlTask xmlTask : tasks) {
            ITaskContext.Task task = new ITaskContext.Task(xmlTask.getName(), xmlTask.getDescriptionTextArea(), xmlTask.getMenuPath());
            result.add(task);
        }
        return result;
    }

    public static void loadTasks(IModule module) {
        ICrudServiceDelegate delegate = (ICrudServiceDelegate) module.getBoundObject(IDelegateKey.class, XmlTask.class);
        delegate.findAll();
        List<XmlTask> loadedTasks = delegate.getResponseBeans();
        if (loadedTasks != null && loadedTasks.size() > 0) {
            contextTaskList.clear();
            contextTaskList.addAll(convertToContextTaskList(loadedTasks));
        }
    }

    public static void loadContext(IModule module) {
        loadTranslations(module);

        loadTasks(module);
        ITaskContext.updateTaskMap(contextTaskList);
    }
}
