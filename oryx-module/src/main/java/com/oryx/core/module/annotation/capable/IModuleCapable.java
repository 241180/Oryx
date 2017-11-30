package com.oryx.core.module.annotation.capable;

import com.oryx.core.module.IModule;
import com.oryx.core.module.annotation.decl.Module;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smbarki on 08/06/2017.
 */
public interface IModuleCapable {
    final static Logger logger = Logger.getLogger(IModuleCapable.class);

    public static Map<Object, IModule> moduleMap = new HashMap<>();

    public static Class<? extends IModule> getClassType(Object current) {
        if (current != null) {
            Module moduleAnnotation = current.getClass().getAnnotation(Module.class);
            if (moduleAnnotation != null) {
                return moduleAnnotation.classType();
            } else {
                logger.error("No module associated for class " + current.getClass().getSimpleName());
            }
        }

        return null;
    }

    public static IModule getInstance(Object current) {
        Class<? extends IModule> type = getClassType(current);
        if (moduleMap.containsKey(current)) {
            return moduleMap.get(current);
        } else {
            if (type != null) {
                try {
                    IModule module = type.newInstance();
                    if (!module.isConfigured()) {
                        module.configure();
                        module.initializeServices();
                    }
                    moduleMap.put(current, module);
                    return module;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
