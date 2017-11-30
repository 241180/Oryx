package com.oryx.core.service;

import com.oryx.core.delegate.AbstractCrudSuperServiceDelegate;
import com.oryx.core.delegate.ICrudDelegate;
import com.oryx.core.factory.IFactory;
import com.oryx.core.model.AbstractEntity;
import com.oryx.remote.service.entry.factory.exchangeObject.crud.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public abstract class AbstractCrudServiceDelegate<E, M extends AbstractEntity> extends AbstractCrudSuperServiceDelegate<E, M> implements ICrudDelegate<E, M> {

    @Autowired
    private EntityFactory entityTokenFactory;

    @Override
    public IFactory getFactory() {
        return this.entityTokenFactory;
    }

    @Override
    public E findById(UUID id) throws InvocationTargetException, IllegalAccessException {
        return superFindById(id);
    }

    @Override
    public List<E> findByCriteria(E criteria) throws InvocationTargetException, IllegalAccessException {
        return superFindByCriteria(criteria);
    }

    @Override
    public List<E> findAll() throws InvocationTargetException, IllegalAccessException {
        return superGetAll();
    }

    @Override
    public E delete(UUID id) throws InvocationTargetException, IllegalAccessException {
        return superDelete(id);
    }

    @Override
    public E create(E entity) throws InvocationTargetException, IllegalAccessException {
        return superCreate(entity);
    }

    @Override
    public E update(E entity) throws InvocationTargetException, IllegalAccessException {
        return superUpdate(entity);
    }
}
