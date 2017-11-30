package com.oryx.core.model;

/**
 * Created by 241180 on 26/01/2017.
 */
public interface Entity {
    public Object instance();

    public Object newInstance();

    public Object newXmlInstance();

    public Object superParse(Object xmlEntity);

    public Object superUnparse(Object modelEntity);

    public void beforeSave();

    public void afterSelect();
}
