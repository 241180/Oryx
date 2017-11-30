package com.oryx.core.parameter;

import com.oryx.core.service.IService;

import java.util.UUID;

public interface IParameterService extends IService {
    public String getValue(UUID userId, String paramCode, String defaultVlue);

    public String getValue(UUID userId, String paramCode);

    public String getValue(String paramCode, String defaultVlue);

    public String getValue(String paramCode);
}
