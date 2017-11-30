package com.oryx.core.module;

import com.oryx.core.binder.IBoundableKey;
import com.oryx.core.binder.IBoundableObject;
import com.oryx.core.module.annotation.capable.IModuleCapable;

import java.util.Map;
import java.util.Set;

/**
 * Created by SAMI on 25/03/2017.
 */
public interface IModule extends IModuleCapable {
    public boolean isConfigured();

    public IModule configure();

    public IModule initializeServices();

    public void install(Class<? extends IModule> moduleClass);

    public void copy(IModule src);

    public String getModuleName();

    public IModule getApplicationModule();

    public void setApplicationModule(IModule applicationModule);

    public Map<Class<? extends IBoundableKey>, Map<Class<?>, IBoundableObject>> getBinderObjectMap();

    public Map<Class<? extends IBoundableKey>, Map<String, Class<?>>> getBoundObjectDescriptionMap();

    public void bind(Class<? extends IBoundableKey> binderKey, Class<?> objectKey, IBoundableObject boundable);

    public void register(Class<? extends IBoundableKey> binderKey, String desc, Class<?> objectKey);

    public IBoundableObject getBoundObject(Class<? extends IBoundableKey> binderKey, Class<?> objectKey);

    public IBoundableObject getByObjectDescription(Class<? extends IBoundableKey> binderKey, String description);

    public Set<String> getObjectDesctiptionSet(Class<? extends IBoundableKey> binderKey, boolean onlyAllowed);

    public boolean isObjectAllowedByDescription(Class<? extends IBoundableKey> binderKey, String description);

    public boolean isObjectAllowedByEntityName(Class<? extends IBoundableKey> binderKey, String entityName);

    public Object AuthentificateAndLoadContext(String login, String password, String sessionToken);
}