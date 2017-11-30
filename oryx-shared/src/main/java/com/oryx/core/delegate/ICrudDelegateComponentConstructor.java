package com.oryx.core.delegate;

import com.oryx.core.model.AbstractEntity;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.core.repository.IEntityRepository;

import javax.persistence.EntityManager;

public interface ICrudDelegateComponentConstructor<M extends AbstractEntity> extends IDelegate {
    public EntityManager getEntityManager();

    public void setEntityManager(EntityManager entityManager);

    public ITypeByTokenProvider getTypeByTokenProvider();

    public IEntityRepository<M> getEntityRepository();
}
