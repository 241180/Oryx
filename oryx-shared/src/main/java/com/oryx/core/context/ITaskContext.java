package com.oryx.core.context;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smbarki on 05/09/2017.
 */
public interface ITaskContext {
    final static Logger logger = Logger.getLogger(ITaskContext.class);
    final static String DefaultUserId = ".";
    public static final Map<String /*User ID*/, Map<String /*Name*/, String /*Menu path*/>> taskMap = new HashMap<>();

    public static boolean isLoaded() {
        return (taskMap != null && taskMap.size() > 0) ? true : false;
    }

    public static boolean isLoaded(String userId) {
        return isLoaded() ? taskMap.containsKey(userId) : false;
    }

    public static List<String> getTasks() {
        if (isLoaded()) {
            List<String> tasks = new ArrayList<>();
            for (Map<String /*Name*/, String /*Menu path*/> userTasks : taskMap.values()) {
                if (userTasks != null && userTasks.size() > 0) {
                    for (String taskName : userTasks.keySet()) {
                        tasks.add(taskName);
                    }
                }
            }
            return tasks;
        }

        return null;
    }

    public static Map<String /*Name*/, String /*Menu path*/> getTasksWithMenuPath() {
        if (isLoaded()) {
            Map<String /*Name*/, String /*Menu path*/> tasksWithMenuPath = new HashMap<>();
            for (Map<String /*Name*/, String /*Menu path*/> userTasks : taskMap.values()) {
                tasksWithMenuPath.putAll(userTasks);
            }
            return tasksWithMenuPath;
        }

        return null;
    }

    public static List<String> getTasksByUser(String userId) {
        if (isLoaded() && userId != null && !userId.isEmpty()) {
            List<String> tasks = new ArrayList<>();
            Map<String /*Name*/, String /*Menu path*/> userTasks = taskMap.get(userId);
            if (userTasks != null && userTasks.size() > 0) {
                for (String taskName : userTasks.keySet()) {
                    tasks.add(taskName);
                }
            }

            return tasks;
        }

        return null;
    }

    public static List<String> getTasksByUser(String userId, boolean withDefault) {
        if (isLoaded() && userId != null && !userId.isEmpty()) {
            List<String> tasks = new ArrayList<>(getTasksByUser(userId));

            if (withDefault && taskMap.containsKey(DefaultUserId)) {
                Map<String /*Name*/, String /*Menu path*/> defaultTasks = taskMap.get(DefaultUserId);
                if (defaultTasks != null && defaultTasks.size() > 0) {
                    for (String taskName : defaultTasks.keySet()) {
                        tasks.add(taskName);
                    }
                }
            }

            return tasks;
        }

        return null;
    }

    public static void updateTaskMap(List<Task> taskList) {
        Map<String /*Name*/, String /*Menu path*/> userTasks = taskMap.get(DefaultUserId);
        if (userTasks == null) {
            userTasks = new HashMap<>();
            taskMap.put(DefaultUserId, userTasks);
        } else {
            userTasks.clear();
        }

        if (taskList != null && !taskList.isEmpty()) {
            for (Task task : taskList) {
                userTasks.put(task.taskName, task.menuPath);
            }
        }
    }

    public static void updateTaskMap(String userId, List<Task> taskList) {
        Map<String /*Name*/, String /*Menu path*/> userTasks = taskMap.get(userId);
        if (userTasks == null) {
            userTasks = new HashMap<>();
            taskMap.put(userId, userTasks);
        } else {
            userTasks.clear();
        }

        if (taskList != null && !taskList.isEmpty()) {
            for (Task task : taskList) {
                userTasks.put(task.taskName, task.menuPath);
            }
        }
    }

    class Task {
        public String taskName;
        public String description;
        public String menuPath;

        public Task(String taskName, String description, String menuPath) {
            this.taskName = taskName;
            this.description = description;
            this.menuPath = menuPath;
        }
    }
}
