package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.service.CrudService;

public abstract class AbstractCrudService<T> implements CrudService<T>{

    @Override
    public T create(T t) {
        return getCrudDao().create(t);
    }

    @Override
    public abstract T read(int id);

    @Override
    public T update(T t) {
        return getCrudDao().update(t);
    }

    @Override
    public T delete(T t) {
        return getCrudDao().delete(t);
    }

    protected abstract CrudDao<T> getCrudDao();
}
