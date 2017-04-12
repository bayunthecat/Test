package com.lwd.platform.testing.repo.mysql.hibernate;

import com.lwd.platform.testing.exception.repo.ModifyException;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.tools.IdInjectionStrategy;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractHibernateCrudDao<T> implements CrudDao<T> {

    @Autowired
    private IdInjectionStrategy idInjector;

    @Autowired
    private Session session;

    @Override
    public T create(T object) {
        session.persist(object);
        session.flush();
        return object;
    }

    @Override
    public T delete(T object) {
        checkModifyAllowed(object);
        session.delete(object);
        session.flush();
        return object;
    }

    @Override
    public T update(T object) {
        checkModifyAllowed(object);
        session.update(object);
        session.flush();
        return object;
    }

    @Override
    public T read(T object, int id) {
        session.load(object, id);
        return object;
    }

    private void checkModifyAllowed(T object) {
        if (object == null) {
            throw new ModifyException("Specified object is empty.");
        }
        if (idInjector.getId(object) == null) {
            throw new ModifyException(String.format("%s has no id specified", object));
        }
    }
}