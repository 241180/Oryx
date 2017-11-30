package com.oryx.core;

import com.oryx.core.model.AbstractEntity;
import org.apache.log4j.Logger;
import org.hibernate.collection.internal.PersistentSet;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by 241180 on 31/01/2017.
 */
public class BeanUtils {
    final static Logger logger = Logger.getLogger(BeanUtils.class);

    public static void copyBeans(Object beanSrc, Object beanDest, int level) {
        /*try {
            Converter dateConverter = new XmlDateConverter();
            Converter boolConverter = new XmlBooleanConverter();
            BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
            beanUtilsBean.getConvertUtils().register(dateConverter, Date.class);
            beanUtilsBean.getConvertUtils().register(dateConverter, XMLGregorianCalendar.class);
            beanUtilsBean.getConvertUtils().register(boolConverter, Boolean.class);
            beanUtilsBean.copyProperties(beanDest, beanSrc);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

        if (level > 3)
            return;
        else
            level++;


        Class<?> currentSrc = beanSrc.getClass();
        Class<?> currentDest = beanDest.getClass();
        while (currentSrc != null && currentDest != null) { // we don't want to process Object.class
            for (Field fieldSrc : currentSrc.getDeclaredFields()) {

                if (Modifier.isStatic(fieldSrc.getModifiers()))
                    break;

                Field fieldDest = null;
                try {
                    fieldDest = currentDest.getDeclaredField(fieldSrc.getName());
                } catch (NoSuchFieldException e) {
                    //e.printStackTrace();
                    logger.warn("NoSuchFieldException for field: " + fieldSrc.getName());
                }

                boolean fieldSrcAccessible = fieldSrc.isAccessible();
                fieldSrc.setAccessible(true);

                boolean fieldDestAccessible = fieldDest.isAccessible();
                fieldDest.setAccessible(true);

                Object valueSrc = null;
                try {
                    valueSrc = fieldSrc.get(beanSrc);
                } catch (IllegalAccessException e) {
                    //e.printStackTrace();
                    logger.warn("IllegalAccessException for field: " + fieldSrc.getName());
                    valueSrc = null;
                }

                Object valueDest = null;
                try {
                    valueDest = fieldDest.get(beanDest);
                } catch (IllegalAccessException e) {
                    //e.printStackTrace();
                    logger.warn("IllegalAccessException for field: " + fieldDest.getName());
                    valueSrc = null;
                }

                if (valueSrc != null) {
                    try {
                        if (fieldDest.getType() == String.class && valueSrc instanceof UUID) {
                            valueDest = ((UUID) valueSrc).toString();
                            fieldDest.set(beanDest, valueDest);
                        } else if (fieldDest.getType() == UUID.class && valueSrc instanceof String) {
                            if (valueSrc != null && !((String) valueSrc).isEmpty()) {
                                valueDest = UUID.fromString((String) valueSrc);
                            }
                            fieldDest.set(beanDest, valueDest);
                        } else if ((valueSrc instanceof AbstractEntity && valueDest instanceof AbstractEntity)
                                || (valueSrc instanceof AbstractEntity && valueDest == null)) {
                            if (valueDest == null) {
                                valueDest = ((AbstractEntity) valueSrc).newXmlInstance();
                                copyBeans(valueSrc, valueDest, level);
                                fieldDest.set(beanDest, valueDest);
                            } else {
                                copyBeans(valueSrc, valueDest, level);
                            }
                        } else if ((valueSrc instanceof List && valueDest instanceof Set)
                                || (valueSrc instanceof List && valueDest == null)) {
                            if (fieldDest.getType() == List.class) {
                                valueDest = new ArrayList<>((List) valueSrc);
                            } else {
                                valueDest = new HashSet((List) valueSrc);
                            }
                            fieldDest.set(beanDest, valueDest);
                        } else if ((valueSrc instanceof PersistentSet && valueDest instanceof List)
                                || (valueSrc instanceof PersistentSet && valueDest == null)) {
                            valueDest = new ArrayList<>();
                            for (Object o : (Set) valueSrc) {
                                if (o instanceof AbstractEntity) {
                                    Object xmlo = ((AbstractEntity) o).newXmlInstance();
                                    copyBeans(o, xmlo, level);
                                    ((List) valueDest).add(xmlo);
                                }
                            }
                            fieldDest.set(beanDest, valueDest);
                        } else if ((valueSrc instanceof List && valueDest instanceof PersistentSet)
                                || (valueSrc instanceof List && valueDest == null)) {
                            valueDest = new PersistentSet();
                            for (Object o : (List) valueSrc) {
                                if (o instanceof AbstractEntity) {
                                    Object xmlo = ((AbstractEntity) o).newXmlInstance();
                                    copyBeans(o, xmlo, level);
                                    ((PersistentSet) valueDest).add(xmlo);
                                }
                            }
                            ((PersistentSet) valueDest).addAll((List) valueSrc);
                            fieldDest.set(beanDest, valueDest);
                        } else if ((fieldSrc.getType() == XMLGregorianCalendar.class && fieldDest.getType() == Date.class)
                                || (fieldSrc.getType() == XMLGregorianCalendar.class && fieldDest == null)) {
                            valueDest = ((XMLGregorianCalendar) valueSrc).toGregorianCalendar().getTime();
                            fieldDest.set(beanDest, valueDest);
                        } else if ((fieldSrc.getType() == Date.class && fieldDest.getType() == XMLGregorianCalendar.class)
                                || (fieldSrc.getType() == Date.class && fieldDest == null)) {
                            GregorianCalendar c = new GregorianCalendar();
                            c.setTime((Date) valueSrc);
                            valueDest = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                            fieldDest.set(beanDest, valueDest);
                        } else {
                            fieldDest.set(beanDest, valueSrc);
                        }

                    } catch (IllegalArgumentException e) {
                        //e.printStackTrace();
                        logger.warn("IllegalArgumentException for field: " + fieldSrc.getName());
                        valueSrc = null;
                    } catch (IllegalAccessException e) {
                        //e.printStackTrace();
                        logger.warn("IllegalAccessException for field: " + fieldSrc.getName());
                        valueSrc = null;
                    } catch (DatatypeConfigurationException e) {
                        //e.printStackTrace();
                        logger.warn("DatatypeConfigurationException for field: " + fieldSrc.getName() + " convertion from date to XMLGregorianCalendar.");
                        valueSrc = null;
                    }
                }

                fieldSrc.setAccessible(fieldSrcAccessible);
                fieldDest.setAccessible(fieldDestAccessible);

            }
            currentSrc = currentSrc.getSuperclass();
            currentDest = currentDest.getSuperclass();
        }

    }
}
