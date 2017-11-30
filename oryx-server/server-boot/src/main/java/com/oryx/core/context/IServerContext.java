package com.oryx.core.context;

import com.oryx.core.binder.delegate.CrudDelegateHelper;
import com.oryx.core.bundle.translation.IBundleTranslation;
import com.oryx.core.enums.EnumLanguage;
import com.oryx.core.model.system.msg.Translation;
import com.oryx.core.model.system.ose.Task;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by smbarki on 04/09/2017.
 */
public interface IServerContext {
    public static final List<Translation> contextTranslationList = new ArrayList<>();
    public static final List<ITaskContext.Task> contextTaskList = new ArrayList<>();

    public static List<Translation> getTranslations() {
        return contextTranslationList.size() > 0 ? contextTranslationList : null;
    }

    public static List<ITaskContext.Task> getTasks() {
        return contextTaskList.size() > 0 ? contextTaskList : null;
    }

    public static void loadTranslations() {
        if (!IBundleTranslation.isLoaded()) {
            try {
                List<Translation> loadedTranslations = CrudDelegateHelper.findAll(Translation.class);
                if (loadedTranslations != null && loadedTranslations.size() > 0) {
                    contextTranslationList.clear();
                    contextTranslationList.addAll(loadedTranslations);
                }

                if (loadedTranslations != null && !loadedTranslations.isEmpty()) {
                    for (Translation tr : loadedTranslations) {
                        IBundleTranslation.addTranslation(EnumLanguage.valueOf(tr.getLanguage().name()), tr.getBundleOrigin(), tr.getText(), tr.getTranslation());
                    }
                }
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<ITaskContext.Task> convertToContextTaskList(List<Task> tasks) {
        List<ITaskContext.Task> result = new ArrayList<>();
        for (Task task : tasks) {
            ITaskContext.Task t = new ITaskContext.Task(task.getName(), task.getDescriptionTextArea(), task.getMenuPath());
            result.add(t);
        }
        return result;
    }

    public static void loadTasks() {
        try {
            List<Task> loadedTasks = CrudDelegateHelper.findAll(Task.class);
            if (loadedTasks != null && loadedTasks.size() > 0) {
                contextTaskList.clear();
                contextTaskList.addAll(convertToContextTaskList(loadedTasks));
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void loadContext() {
        loadTranslations();
        loadTasks();
        ITaskContext.updateTaskMap(contextTaskList);
    }
}
