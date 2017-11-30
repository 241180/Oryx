package com.oryx.core.service;

import com.oryx.core.parameter.IParameterService;
import com.oryx.core.service.system.ose.ParameterServiceDelegate;
import com.oryx.remote.webservice.element.model.system.ose.XmlParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@Service
public class ParameterService implements IParameterService {

    @Autowired
    ParameterServiceDelegate parameterServiceDelegate;

    @Override
    public String getValue(UUID userId, String paramCode, String defaultValue) {
        try {
            XmlParameter criteria = new XmlParameter();
            criteria.setReference(userId != null ? userId.toString() : null);
            criteria.setName(paramCode);
            List<XmlParameter> result = parameterServiceDelegate.findByCriteria(criteria);
            if (!CollectionUtils.isEmpty(result)) {
                return result.get(0).getValue();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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
