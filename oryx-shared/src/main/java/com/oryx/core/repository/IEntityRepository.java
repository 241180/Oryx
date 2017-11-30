package com.oryx.core.repository;

import java.util.UUID;

/**
 * Created by 241180 on 13/01/2017.
 */
public interface IEntityRepository<M> {
    public M findById(UUID id);

    public Iterable<M> findAll();
}
