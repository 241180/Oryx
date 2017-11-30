package com.oryx.core.delegate;


import com.oryx.core.model.AbstractEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public interface ICrudDelegate<E, M extends AbstractEntity> extends ICrudDelegateComponentConstructor<M> {
    public E findById(UUID id) throws InvocationTargetException, IllegalAccessException;

    public List<E> findByCriteria(E criteria) throws InvocationTargetException, IllegalAccessException;

    public List<E> findAll() throws InvocationTargetException, IllegalAccessException;

    public E delete(UUID id) throws InvocationTargetException, IllegalAccessException;

    public E create(E entity) throws Exception;

    public E update(E entity) throws InvocationTargetException, IllegalAccessException;
}
