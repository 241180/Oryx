package com.oryx.core.initializer;

import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ServerServiceInitializer {

    @Autowired
    ParameterService parameterService;

    @PostConstruct
    public void initialize() {
        CommonServiceHelper.bindParameterService(parameterService);
    }
}
