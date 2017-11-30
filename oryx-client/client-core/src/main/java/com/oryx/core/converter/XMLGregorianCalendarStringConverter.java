package com.oryx.core.converter;

import com.vaadin.data.util.converter.Converter;
import org.apache.log4j.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by 241180 on 14/03/2017.
 */

public class XMLGregorianCalendarStringConverter implements Converter<String, XMLGregorianCalendar> {

    final static Logger logger = Logger.getLogger(XMLGregorianCalendarStringConverter.class);

    @Override
    public XMLGregorianCalendar convertToModel(String date, Class<? extends XMLGregorianCalendar> aClass, Locale locale) throws ConversionException {
        if (date == null)
            return null;

        try {
            return stringToXMLGregorianCalendar(date);
        } catch (DatatypeConfigurationException e) {
            //e.printStackTrace();
            logger.warn("DatatypeConfigurationException date to XMLGregorianCalendar");
        } catch (ParseException e) {
            logger.warn("ParseException date to XMLGregorianCalendar");
            //e.printStackTrace();
        }

        return null;
    }

    @Override
    public String convertToPresentation(XMLGregorianCalendar xmlGregorianCalendar, Class<? extends String> aClass, Locale locale) throws ConversionException {
        if (xmlGregorianCalendar != null)
            return xmlGregorianCalendar.toGregorianCalendar().getTime().toString();
        else
            return null;
    }

    public Class<XMLGregorianCalendar> getModelType() {
        return XMLGregorianCalendar.class;
    }

    public Class<String> getPresentationType() {
        return String.class;
    }

    public XMLGregorianCalendar stringToXMLGregorianCalendar(String s)
            throws ParseException,
            DatatypeConfigurationException {
        XMLGregorianCalendar result = null;
        Date date;
        SimpleDateFormat simpleDateFormat;
        GregorianCalendar gregorianCalendar;

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        date = simpleDateFormat.parse(s);
        gregorianCalendar =
                (GregorianCalendar) GregorianCalendar.getInstance();
        gregorianCalendar.setTime(date);
        result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        return result;
    }
}
