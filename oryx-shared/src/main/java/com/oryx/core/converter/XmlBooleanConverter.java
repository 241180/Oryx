package com.oryx.core.converter;

import org.apache.commons.beanutils.converters.AbstractConverter;

/**
 * Created by 241180 on 26/01/2017.
 */
public class XmlBooleanConverter extends AbstractConverter {
    @Override
    protected Object convertToType(Class aClass, Object o) throws Throwable {
        return null;
    }

    @Override
    public Object convert(Class type, Object value) {
        if (value == null) {
            if (type == Boolean.class)
                return new Boolean(false);
            else
                return null;
        }

        if (type == Boolean.class) {
            if (value.getClass() == Boolean.class) {
                return ((Boolean) value).booleanValue();
            }
        }

        //else
        return super.convert(type, value);
    }

    @Override
    protected Class getDefaultType() {
        return Boolean.class;
    }
}