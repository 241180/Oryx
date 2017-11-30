package com.oryx.core.converter;

import com.vaadin.data.util.converter.Converter;
import org.apache.log4j.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by 241180 on 14/03/2017.
 */

public class XMLGregorianCalendarDateConverter implements Converter<Date, XMLGregorianCalendar> {

    final static Logger logger = Logger.getLogger(XMLGregorianCalendarDateConverter.class);

    @Override
    public XMLGregorianCalendar convertToModel(Date date, Class<? extends XMLGregorianCalendar> aClass, Locale locale) throws ConversionException {
        if (date == null)
            return null;

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        try {
            XMLGregorianCalendar result = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            return result;
        } catch (DatatypeConfigurationException e) {
            //e.printStackTrace();
            logger.warn("DatatypeConfigurationException date to XMLGregorianCalendar");
        }

        return null;
    }

    @Override
    public Date convertToPresentation(XMLGregorianCalendar xmlGregorianCalendar, Class<? extends Date> aClass, Locale locale) throws ConversionException {
        if (xmlGregorianCalendar != null)
            return xmlGregorianCalendar.toGregorianCalendar().getTime();
        else
            return null;
    }

    public Class<XMLGregorianCalendar> getModelType() {
        return XMLGregorianCalendar.class;
    }

    public Class<Date> getPresentationType() {
        return Date.class;
    }
}
