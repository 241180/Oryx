package com.oryx.core.persistence;

import org.apache.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.TypedQuery;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 241180 on 06/03/2017.
 */
public class TQuery<M, X> {
    final static Logger logger = Logger.getLogger(TQuery.class);

    private String tableName;
    private String entityName;

    private StringBuilder query;
    private TypedQuery<M> tQuery;
    private List<M> tResult;

    public TQuery<M, X> setCtiteria(X criteria, Class<M> clazz) {
        if (entityName == null)
            return null;

        if (criteria == null)
            return null;

        if (clazz == null)
            return null;

        //SELECT * FROM table
        this.query = new StringBuilder("FROM ")
                .append(entityName);

        //WHERE a=? AND b=? AND ...
        int criteriaCount = 0;
        for (Field field : criteria.getClass().getDeclaredFields()) {
            if (field.getType() == String.class
                    || field.getType() == Boolean.class
                    || field.getType() == Date.class
                    || field.getType() == XMLGregorianCalendar.class
                    || field.getType() == Integer.class
                    || field.getType() == Long.class
                    || (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum())) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                Object value = null;

                try {
                    value = field.get(criteria);
                    if (value != null && field.getType() == XMLGregorianCalendar.class) {
                        Date date = ((XMLGregorianCalendar) value).toGregorianCalendar().getTime();
                        value = new java.sql.Date(date.getTime());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (value != null && field.getType() == String.class && ((String) value).isEmpty()) {
                    value = null;
                }

                if (value != null) {
                    String columnName = null;
                    try {
                        Column column = clazz.getDeclaredField(field.getName()).getAnnotation(Column.class);
                        columnName = column != null ? column.name() : null;
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }

                    if (columnName == null) {
                        try {
                            JoinColumn column = clazz.getDeclaredField(field.getName().replace("Id", "")).getAnnotation(JoinColumn.class);
                            columnName = column != null ? column.name() : null;
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }

                    if (columnName != null) {
                        if (criteriaCount > 0) {
                            query.append(" AND ");
                        } else
                            query.append(" WHERE ");


                        query.append(columnName);

                        if (field.getType() == XMLGregorianCalendar.class) {
                            query.append(" BETWEEN \'")
                                    .append(value).append(" 00:00:00.00")
                                    .append("\'")
                                    .append(" AND ")
                                    .append("\'")
                                    .append(value).append(" 23:59:59.999")
                                    .append("\'");
                        } else if (field.getType() == Integer.class) {
                            query.append(" = \'")
                                    .append(value)
                                    .append("\'");
                        } else if (field.getType() == UUID.class) { // && columnName.endsWith("_ID")) {
                            query.append(" = UNHEX(\'")
                                    .append(((String) value).replace("-", ""))
                                    .append("\')");
                        } else if (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum()) {
                            query.append(" = \'")
                                    .append(value)
                                    .append("\'");
                        } else if (field.getType() == String.class) {
                            if (value.equals("NOVAL")) {
                                query.append(" IS NULL");
                            } else if (((String) value).startsWith("%") || ((String) value).endsWith("%")) {
                                query.append(" LIKE \'")
                                        .append(value)
                                        .append("\'");
                            } else {
                                query.append(" = \'")
                                        .append(value)
                                        .append("\'");
                            }
                        } else {
                            query.append(" LIKE \'%")
                                    .append(value)
                                    .append("%\'");
                        }

                        criteriaCount++;
                    }
                }
                field.setAccessible(accessible);
            }
        }

        logger.info("SQL QUERY BUILT: SELECT * " + query.toString());
        return this;
    }

    public List<M> execute(final EntityManager entityManager, Class<M> clazz) {
        if (entityManager == null)
            return null;

        if (clazz == null)
            return null;

        //Query creation
        tQuery = entityManager.createQuery(query.toString(), clazz);

        if (this.tQuery != null) {
            tResult = this.tQuery.getResultList();
            logger.info("SQL QUERY EXECUTED: SELECT * " + query.toString());
            logger.info("SQL QUERY RESULT: " + (tResult != null ? tResult.size() : "0") + "entities retrieved");
        } else {
            tResult = null;
        }

        return tResult;
    }


    public String getTableName() {
        return tableName;
    }

    public TQuery<M, X> setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public TQuery<M, X> setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public List<M> gettResult() {
        return tResult;
    }
}
