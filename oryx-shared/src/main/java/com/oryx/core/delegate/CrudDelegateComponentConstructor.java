package com.oryx.core.delegate;

import com.oryx.core.factory.IFactory;
import com.oryx.core.model.AbstractEntity;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.core.repository.IEntityRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Field;

public abstract class CrudDelegateComponentConstructor<E, M extends AbstractEntity> //
        implements ICrudDelegateComponentConstructor<M> {

    private EntityManager entityManager;
    private ITypeByTokenProvider rQClassTypesCache;
    private IEntityRepository<M> repositoryCache;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract IFactory getFactory();

    @Override
    public ITypeByTokenProvider getTypeByTokenProvider() {
        if (this.rQClassTypesCache != null)
            return this.rQClassTypesCache;

        Field field = null;
        try {
            field = this.getClass().getDeclaredField("rQClassTypes");
            if (field != null) {
                boolean accessibe = field.isAccessible();
                field.setAccessible(true);
                this.rQClassTypesCache = (ITypeByTokenProvider) field.get(this);
                field.setAccessible(accessibe);
                return this.rQClassTypesCache;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return this.rQClassTypesCache;
    }

    @Override
    public IEntityRepository<M> getEntityRepository() {
        if (this.repositoryCache != null)
            return this.repositoryCache;

        Field field = null;
        try {
            field = this.getClass().getDeclaredField("repository");
            if (field != null) {
                boolean accessibe = field.isAccessible();
                field.setAccessible(true);
                this.repositoryCache = (IEntityRepository<M>) field.get(this);
                field.setAccessible(accessibe);
                return this.repositoryCache;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return this.repositoryCache;
    }
}
