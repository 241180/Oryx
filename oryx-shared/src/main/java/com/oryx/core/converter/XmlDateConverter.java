package com.oryx.core.converter;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.apache.commons.beanutils.converters.AbstractConverter;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 241180 on 26/01/2017.
 */
public class XmlDateConverter extends AbstractConverter {
    @Override
    protected Object convertToType(Class aClass, Object o) throws Throwable {
        return null;
    }

    @Override
    public Object convert(Class type, Object value) {
        if (value == null) {
            return null;
        }

        if (type == Boolean.class) {
            if (value.getClass() == Boolean.class) {
                return ((Boolean) value).booleanValue();
            }
        } else if (type == Date.class) {
            if (value.getClass() == XMLGregorianCalendarImpl.class) {
                return ((XMLGregorianCalendar) value).toGregorianCalendar().getTime();
            }
        } else if (type == String.class) {
            if (value.getClass() == XMLGregorianCalendarImpl.class) {
                return ((XMLGregorianCalendar) value).toGregorianCalendar().getTime().toString();
            }
        } else if (type == XMLGregorianCalendar.class) {
            if (value.getClass() == Timestamp.class) {
                GregorianCalendar gCalendar = new GregorianCalendar();
                gCalendar.setTime((Timestamp) value);
                XMLGregorianCalendar xmlCalendar = null;
                try {
                    xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
                } catch (DatatypeConfigurationException ex) {
                    ex.printStackTrace();
                }
                return xmlCalendar;
            }
        }

        //else
        return super.convert(type, value);
    }

    @Override
    protected Class getDefaultType() {
        return Date.class;
    }
}