package com.oryx.core.delegate;

import com.oryx.core.factory.IFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

/**
 * Created by 241180 on 13/01/2017.
 */
public interface ICrudSuperService<E> {
    public abstract IFactory getFactory();

    public abstract E superFindById(UUID id) throws InvocationTargetException, IllegalAccessException;

    public abstract List<E> superFindByCriteria(E criteria) throws InvocationTargetException, IllegalAccessException;

    public abstract List<E> superGetAll() throws InvocationTargetException, IllegalAccessException;

    public abstract E superDelete(UUID id) throws InvocationTargetException, IllegalAccessException;

    public abstract E superCreate(E entity) throws InvocationTargetException, IllegalAccessException;

    public abstract E superUpdate(E entity) throws InvocationTargetException, IllegalAccessException;
}
