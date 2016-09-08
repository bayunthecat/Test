package com.lwd.platform.testing.service;

public interface CrudService<T> {

    T create(T t);

    T read(int id);

    T update(T t);

    T delete(T t);
}
