package com.oryx.core.model;

import com.oryx.core.BeanUtils;
import com.oryx.core.guid.Guid10Generator;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.parameter.ICommonParameterNames;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by 241180 on 26/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlAbstractEntity", namespace = "http://model.element.webservice.remote.oryx.com")
public abstract class AbstractEntity implements Entity {
    public static final Guid10Generator guid10Generator = new Guid10Generator();
    private static Object SINGLETON;

    private static Object XML_SINGLETON;

    public abstract Object newInstance();

    public abstract Object newXmlInstance();

    public void beforeSave() {
        try {
            for (Field field : getClass().getDeclaredFields()) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                //Code generation if empty
                if (field.getName().toLowerCase().endsWith("code") && field.getType() == String.class) {
                    String code = (String) field.get(this);
                    if (code == null || code.isEmpty()) {
                        String pattern = CommonServiceHelper.getParameterService().getValue(ICommonParameterNames.CODE_CALCULATION_RULE);
                        if (pattern != null) {
                            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
                            code = LocalDateTime.now().format(fmt);
                        } else {
                            code = guid10Generator.nextGuid().toUpperCase();
                        }

                        field.set(this, code);
                    }
                }

                //create linked Identifiable object from id
                if (field.getName().endsWith("Id") && field.getType() == UUID.class) {
                    Field entityField = null;
                    try {
                        entityField = this.getClass().getDeclaredField(field.getName().replace("Id", ""));
                        if (entityField != null && Identifiable.class.isAssignableFrom(entityField.getType())) {
                            boolean isEntityFieldAccessible = entityField.isAccessible();
                            entityField.setAccessible(true);
                            UUID id = (UUID) field.get(this);
                            if (id != null && entityField.get(this) == null) {
                                try {
                                    Identifiable entity = (Identifiable) entityField.getType().getConstructor().newInstance();
                                    entity.setId(id);
                                    entityField.set(this, entity);
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                }
                            }
                            entityField.setAccessible(isEntityFieldAccessible);
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }

                //create entity list from recieved ids
                if (field.getName().endsWith("Ids")) {
                    List<String> ids = (List) field.get(this);  //get ids list
                    if (ids != null && ids.size() > 0) {
                        Field setField = getClass().getDeclaredField(field.getName().replace("Ids", "Set"));    //get Set field
                        if (setField != null
                                && setField.getGenericType() instanceof ParameterizedType
                                && ((ParameterizedType) setField.getGenericType()).getActualTypeArguments().length > 0) {
                            //get generic argument Type
                            Class<?> entityClassType = (Class<?>) ((ParameterizedType) setField.getGenericType()).getActualTypeArguments()[0];
                            if (entityClassType != null) {
                                boolean _isAccessible = setField.isAccessible();
                                setField.setAccessible(true);
                                Set<Identifiable> set = new HashSet<>();
                                //Create entities from ids list
                                for (String roleId : ids) {
                                    Identifiable identifiable = (Identifiable) entityClassType.getConstructor().newInstance();
                                    identifiable.setId(UUID.fromString(roleId));
                                    set.add(identifiable);
                                }
                                setField.set(this, set);
                                setField.setAccessible(_isAccessible);
                            }
                        }
                    }
                }

                field.setAccessible(isAccessible);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void beforeUpdate() {
        beforeSave();
    }

    public void beforeDelete() {

    }

    public void afterDelete() {

    }

    public void afterSelect() {
        for (Field field : getClass().getDeclaredFields()) {
            if (field.getName().endsWith("Id")) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                try {
                    Field identifiableFiled = getClass().getDeclaredField(field.getName().replace("Id", ""));
                    if (identifiableFiled != null && Identifiable.class.isAssignableFrom(identifiableFiled.getType())) {
                        boolean _isAccessible = identifiableFiled.isAccessible();
                        identifiableFiled.setAccessible(true);
                        Identifiable identifiable = (Identifiable) identifiableFiled.get(this);
                        if (identifiable != null) {
                            field.set(this, identifiable.getId());
                            identifiable.afterSelect();
                        }
                        identifiableFiled.setAccessible(_isAccessible);
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                field.setAccessible(isAccessible);
            }

            if (field.getName().endsWith("Ids")) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                try {
                    Field setField = getClass().getDeclaredField(field.getName().replace("Ids", "Set"));
                    if (setField != null) {
                        boolean _isAccessible = setField.isAccessible();
                        setField.setAccessible(true);
                        Set<Identifiable> set = (Set) setField.get(this);
                        if (set != null && set.size() > 0) {
                            List ids = new ArrayList<>();
                            for (Identifiable identifiable : set) {
                                identifiable.afterSelect();
                                ids.add(identifiable.getId().toString());
                            }
                            field.set(this, ids);
                        }
                        setField.setAccessible(_isAccessible);
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                field.setAccessible(isAccessible);
            }
        }
    }

    public Object instance() {
        if (SINGLETON != null)
            return SINGLETON;
        else
            return SINGLETON = newInstance();
    }

    public Object xmlInstance() {
        if (XML_SINGLETON != null)
            return XML_SINGLETON;
        else
            return XML_SINGLETON = newXmlInstance();
    }

    public Object parse(Object xmlEntity) {
        return superParse(xmlEntity);
    }

    public Object unparse(Object modelEntity) {
        return superUnparse(modelEntity);
    }

    public Object superParse(Object xmlEntity) {
        Object modelEntity = newInstance();

        int level = 0;
        BeanUtils.copyBeans(xmlEntity, modelEntity, level);

        return modelEntity;
    }

    public Object superUnparse(Object modelEntity) {
        Object xmlEntity = this.newXmlInstance();

        int level = 0;
        BeanUtils.copyBeans(modelEntity, xmlEntity, level);

        return xmlEntity;
    }
}
