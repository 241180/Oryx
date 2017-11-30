package com.oryx.core.delegate;

import com.oryx.core.model.AbstractEntity;
import com.oryx.core.persistence.TQuery;
import com.oryx.core.provider.IEntityMethodProvider;
import com.oryx.core.provider.IEntityRepositoryMethodProvider;
import com.oryx.core.provider.ITypeByTokenProvider;
import org.apache.log4j.Logger;

import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractCrudSuperServiceDelegate<E, M extends AbstractEntity> extends CrudDelegateComponentConstructor<E, M> implements ICrudSuperService<E> {

    final static Logger logger = Logger.getLogger(AbstractCrudSuperServiceDelegate.class);

    @Override
    public E superFindById(UUID id) throws InvocationTargetException, IllegalAccessException {
        M beanModel = getEntityRepository().findById(id);
        E bean = null;
        beanModel.afterSelect();
        bean = (E) IEntityMethodProvider.UNPARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, beanModel);

        return bean;
    }

    @Override
    public List<E> superGetAll() throws InvocationTargetException, IllegalAccessException {
        Iterable<M> beanModels = getEntityRepository().findAll();
        List<E> beans = new ArrayList<>();

        if (beanModels != null && beanModels.iterator().hasNext()) {
            for (M beanModel : beanModels) {
                beanModel.afterSelect();
                E bean = null;
                bean = (E) IEntityMethodProvider.UNPARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, beanModel);
                beans.add(bean);
            }
        }

        return beans;
    }

    @Override
    public E superDelete(UUID id) throws InvocationTargetException, IllegalAccessException {
        E bean = null;
        M beanModel = getEntityRepository().findById(id);

        if (beanModel != null) {
            beanModel.beforeDelete();
            Integer result = (Integer) IEntityRepositoryMethodProvider.DELETE_METHOD(getEntityRepository().getClass(), Serializable.class).invoke(getEntityRepository(), id);
            beanModel.afterDelete();
            bean = (E) IEntityMethodProvider.UNPARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, beanModel);
        }

        return bean;
    }

    @Override
    public E superCreate(E entity) throws InvocationTargetException, IllegalAccessException {
        M beanModel = (M) getFactory().create(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.ENTITY));
        E bean = null;

        beanModel = (M) IEntityMethodProvider.PARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, entity);
        beanModel.beforeSave();
        beanModel = (M) IEntityRepositoryMethodProvider.SAVE_METHOD(getEntityRepository().getClass(), Object.class).invoke(getEntityRepository(), beanModel);
        bean = (E) IEntityMethodProvider.UNPARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, beanModel);

        return bean;
    }

    @Override
    public E superUpdate(E entity) throws InvocationTargetException, IllegalAccessException {
        M beanModel = (M) getFactory().create(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.ENTITY));
        E bean = null;

        beanModel = (M) IEntityMethodProvider.PARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, entity);
        beanModel.beforeUpdate();
        beanModel = (M) IEntityRepositoryMethodProvider.SAVE_METHOD(getEntityRepository().getClass(), Object.class).invoke(getEntityRepository(), beanModel);
        bean = (E) IEntityMethodProvider.UNPARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, beanModel);

        return bean;
    }

    @Override
    public List<E> superFindByCriteria(E criteria) throws InvocationTargetException, IllegalAccessException {
        Class<M> clazz = getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.ENTITY);

        TQuery<M, E> query = new TQuery<M, E>()
                .setTableName(((Table) clazz.getAnnotation(Table.class)).name())
                .setEntityName(clazz.getSimpleName())
                .setCtiteria(criteria, clazz);

        Iterable<M> beanModels = query.execute(getEntityManager(), clazz);
        List<E> beans = new ArrayList<>();


        if (beanModels != null && beanModels.iterator().hasNext()) {
            for (M beanModel : beanModels) {
                beanModel.afterSelect();
                E bean = null;
                bean = (E) IEntityMethodProvider.UNPARSE_METHOD(beanModel.getClass(), Object.class).invoke(beanModel, beanModel);
                beanModel.afterSelect();
                beans.add(bean);
            }
        }

        return beans;
    }
}
