package com.oryx.core.helper;

import com.oryx.core.parameter.IParameterService;
import com.oryx.core.service.IService;

import java.util.HashMap;
import java.util.Map;

public interface CommonServiceHelper {
    public static Map<Class<? extends IService>, IService> serviceMap = new HashMap<>();

    public static void bindService(Class<? extends IService> serviceClass, IService service) {
        serviceMap.put(serviceClass, service);
    }

    public static IService getService(Class<? extends IService> serviceClass) {
        return serviceMap.get(serviceClass);
    }

    public static IParameterService getParameterService() {
        return (IParameterService) serviceMap.get(IParameterService.class);
    }

    public static void bindParameterService(IParameterService service) {
        serviceMap.put(IParameterService.class, service);
    }
}
