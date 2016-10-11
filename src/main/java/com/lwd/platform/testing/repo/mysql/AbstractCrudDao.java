package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.exception.repo.ModifyException;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.tools.IdInjectionStrategy;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractCrudDao<T> implements CrudDao<T> {

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
        session.load(object, idInjector.getId(object));
        session.delete(object);
        session.flush();
        return object;
    }

    public T update(T object) {
        checkModifyAllowed(object);
        session.update(object);
        session.get(object.getClass(), idInjector.getId(object));
        session.flush();
        return object;
    }

    public T read(T object, int id) {
        session.load(object, id);
        return object;
    }

    private void checkModifyAllowed(T object) {
        if(idInjector.getId(object) == null) {
            throw new ModifyException(String.format("%s has no id specified", object));
        }
    }
}