package com.oryx.core.module;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.binder.IBoundableKey;
import com.oryx.core.binder.IBoundableObject;
import com.oryx.core.context.ITaskContext;
import com.vaadin.server.VaadinSession;

import java.util.*;

/**
 * Created by smbarki on 11/08/2017.
 */
public abstract class AbstractModule implements IModule {

    private boolean configured = false;
    //Map<Key ( = IDelegate, ILayout, ILayoutForSelectionKey), <Entity  Class, Object(Layout, Delegate) >>
    private Map<Class<? extends IBoundableKey>, Map<Class<?>, IBoundableObject>> binderObjectMap = new HashMap<>();
    private Map<Class<? extends IBoundableKey>, Map<String, Class<?>>> boundObjectDescriptionMap = new HashMap<>();
    private IModule applicationModule;

    public boolean isConfigured() {
        return this.configured;
    }

    @Override
    public IModule configure() {
        configured = true;
        return this;
    }

    @Override
    public IModule initializeServices() {
        return this;
    }

    @Override
    public Set<String> getObjectDesctiptionSet(Class<? extends IBoundableKey> binderKey, boolean onlyAllowed) {
        if (onlyAllowed) {
            List<String> userTasks = ITaskContext.getTasksByUser((String) VaadinSession.getCurrent().getAttribute("USER_ID"));
            if (userTasks != null && !userTasks.isEmpty() && boundObjectDescriptionMap.get(binderKey) != null) {
                Set<String> descriptions = new HashSet<>();
                for (String desc : boundObjectDescriptionMap.get(binderKey).keySet()) {
                    if (userTasks.contains(boundObjectDescriptionMap.get(binderKey).get(desc).getSimpleName())) {
                        descriptions.add(desc);
                    }
                }
                return descriptions;
            } else {
                return null;
            }
        } else {
            return boundObjectDescriptionMap.get(binderKey) != null ? boundObjectDescriptionMap.get(binderKey).keySet() : new HashSet<>();
        }
    }

    @Override
    public boolean isObjectAllowedByDescription(Class<? extends IBoundableKey> binderKey, String description) {
        List<String> userTasks = ITaskContext.getTasksByUser((String) VaadinSession.getCurrent().getAttribute("USER_ID"));
        if (userTasks != null && !userTasks.isEmpty() && boundObjectDescriptionMap != null
                && boundObjectDescriptionMap.get(binderKey) != null
                && boundObjectDescriptionMap.get(binderKey).get(description) != null
                && userTasks.contains(boundObjectDescriptionMap.get(binderKey).get(description).getSimpleName())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isObjectAllowedByEntityName(Class<? extends IBoundableKey> binderKey, String entityName) {
        List<String> userTasks = ITaskContext.getTasksByUser((String) VaadinSession.getCurrent().getAttribute("USER_ID"));
        if (userTasks != null && !userTasks.isEmpty() && boundObjectDescriptionMap != null
                && userTasks.contains(entityName)) {
            return true;
        }

        return false;
    }

    public Map<Class<? extends IBoundableKey>, Map<Class<?>, IBoundableObject>> getBinderObjectMap() {
        return this.binderObjectMap;
    }

    public void setBinderObjectMap(Map<Class<? extends IBoundableKey>, Map<Class<?>, IBoundableObject>> binderObjectMap) {
        this.binderObjectMap = binderObjectMap;
    }

    @Override
    public void bind(Class<? extends IBoundableKey> binderKey, Class<?> objectKey, IBoundableObject boundable) {
        Map<Class<?>, IBoundableObject> binderKeyMap = getBinderObjectMap().get(binderKey);
        if (binderKeyMap == null) {
            binderKeyMap = new HashMap<>();
            getBinderObjectMap().put(binderKey, binderKeyMap);
        }

        binderKeyMap.put(objectKey, boundable);
    }

    @Override
    public IBoundableObject getBoundObject(Class<? extends IBoundableKey> binderKey, Class<?> objectKey) {
        Map<Class<?>, IBoundableObject> binderKeyMap = getBinderObjectMap().get(binderKey);
        if (binderKeyMap == null) {
            return null;
        }

        return binderKeyMap.get(objectKey);
    }

    public Map<Class<? extends IBoundableKey>, Map<String, Class<?>>> getBoundObjectDescriptionMap() {
        return boundObjectDescriptionMap;
    }

    public void setBoundObjectDescriptionMap(Map<Class<? extends IBoundableKey>, Map<String, Class<?>>> boundObjectDescriptionMap) {
        this.boundObjectDescriptionMap = boundObjectDescriptionMap;
    }

    @Override
    public IBoundableObject getByObjectDescription(Class<? extends IBoundableKey> binderKey, String description) {
        return getBoundObject(binderKey, boundObjectDescriptionMap.get(binderKey).get(description));
    }


    @Override
    public IModule getApplicationModule() {
        return applicationModule;
    }

    @Override
    public void setApplicationModule(IModule applicationModule) {
        this.applicationModule = applicationModule;
    }

    @Override
    public String getModuleName() {
        String moduleName = IBundleCapable.getBundleInterface(this).getAnnotation(DefaultStringValue.class).value();
        if (moduleName != null)
            return moduleName;
        else
            return getClass().getSimpleName();
    }

    @Override
    public void copy(IModule src) {
        //copy ui and services
        src.getBinderObjectMap().forEach((k, v) -> {
            Map<Class<?>, IBoundableObject> map = this.getBinderObjectMap().get(k);
            if (map != null) {
                map.putAll(v);
            } else {
                this.getBinderObjectMap().put(k, v);
            }
        });

        //copy descriptions
        src.getBoundObjectDescriptionMap().forEach((k, v) -> {
            Map<String, Class<?>> map = this.getBoundObjectDescriptionMap().get(k);
            if (map != null) {
                map.putAll(v);
            } else {
                this.getBoundObjectDescriptionMap().put(k, v);
            }
        });

    }

    @Override
    public void install(Class<? extends IModule> moduleClass) {
        try {
            IModule module = moduleClass.newInstance();
            if (this.getApplicationModule() == null) {
                module.setApplicationModule(this);
            } else {
                module.setApplicationModule(this.getApplicationModule());
            }
            module.configure();
            this.copy(module);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void register(Class<? extends IBoundableKey> binderKey, String desc, Class<?> objectKey) {
        Map<String, Class<?>> descMap = boundObjectDescriptionMap.get(binderKey);
        if (descMap == null) {
            descMap = new HashMap<>();
            boundObjectDescriptionMap.put(binderKey, descMap);
        }

        descMap.put(desc, objectKey);
    }


    @Override
    public Object AuthentificateAndLoadContext(String login, String password, String sessionToken) {
        return null;
    }
}
