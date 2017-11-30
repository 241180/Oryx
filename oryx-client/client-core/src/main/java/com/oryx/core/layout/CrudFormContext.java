package com.oryx.core.layout;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by smbarki on 07/08/2017.
 */
public class CrudFormContext {
    public final static Logger logger = Logger.getLogger(CrudFormContext.class);
    public final static String DISPLAYED_FIELDS = "DISPLAYED_FIELDS";
    public final static String HIDDEN_FIELDS = "HIDDEN_FIELDS";
    public final static String MANDATORY_FIELDS = "MANDATORY_FIELDS";
    public final static String READ_ONLY_FIELDS = "READ_ONLY_FIELDS";
    public final static String FILTER_FIELDS = "FILTER_FIELDS";

    public List<String> displayedFields;
    public List<String> hiddenFields;
    public List<String> mandatoryFields;
    public List<String> readOnlyFields;
    public List<String> filterFields;

    public CrudFormContext(List<String> displayedFields, List<String> hiddenFields, List<String> mandatoryFields, List<String> readOnlyFields, List<String> filterFields) {
        this.displayedFields = displayedFields;
        this.hiddenFields = hiddenFields;
        this.mandatoryFields = mandatoryFields;
        this.readOnlyFields = readOnlyFields;
        this.filterFields = filterFields;
    }

    public static List<String> getFieldValue(Object current, String FieldName) {
        String[] result;
        try {
            java.lang.reflect.Field field = current.getClass().getDeclaredField(FieldName);
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            result = (String[]) field.get(current);
            if (result != null) {
                return Arrays.asList(result);
            }
            field.setAccessible(isAccessible);
        } catch (NoSuchFieldException e) {
            logger.warn("No such field " + FieldName + " in " + current.getClass().getSimpleName());
        } catch (IllegalAccessException e) {
            logger.warn("Illegel access to" + FieldName + " in " + current.getClass().getSimpleName());
        }

        return null;
    }
}
