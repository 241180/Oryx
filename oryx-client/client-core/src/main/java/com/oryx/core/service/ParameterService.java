package com.oryx.core.service;

import com.oryx.core.delegate.IDelegateKey;
import com.oryx.core.module.IModule;
import com.oryx.core.parameter.IParameterService;
import com.oryx.remote.webservice.element.model.system.ose.XmlParameter;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

public class ParameterService implements IParameterService {

    private IModule module;

    public ParameterService(IModule module) {
        this.module = module;
    }

    @Override
    public String getValue(UUID userId, String paramCode, String defaultValue) {

        ICrudServiceDelegate delegate = (ICrudServiceDelegate) module.getBoundObject(IDelegateKey.class, XmlParameter.class);
        XmlParameter criteria = new XmlParameter();
        criteria.setReference(userId.toString());
        criteria.setName(paramCode);
        List<XmlParameter> result = delegate.findByCriteria(criteria);
        if (!CollectionUtils.isEmpty(result)) {
            return result.get(0).getValue();
        }

        return defaultValue;
    }

    @Override
    public String getValue(UUID userId, String paramCode) {
        return getValue(userId, paramCode, null);
    }

    @Override
    public String getValue(String paramCode, String defaultValue) {
        return getValue(null, paramCode, defaultValue);
    }

    @Override
    public String getValue(String paramCode) {
        return getValue(null, paramCode, null);
    }
}
