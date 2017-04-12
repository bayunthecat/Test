package com.lwd.platform.testing.repo;

public interface CrudDao<T> {

    T create(T t);

    T read(int id);

    T update(T t);

    T delete(T t);

}
