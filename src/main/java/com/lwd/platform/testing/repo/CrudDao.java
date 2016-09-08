package com.lwd.platform.testing.repo;

public interface CrudDao<T> {

    T create(T t);

    T read(T object, int id);

    T update(T t);

    T delete(T t);

}
