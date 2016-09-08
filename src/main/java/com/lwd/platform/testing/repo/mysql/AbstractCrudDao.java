package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.exception.repo.UpdateException;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.tools.IdInjectionStrategy;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

abstract class AbstractCrudDao<T> implements CrudDao<T> {

    private Logger LOG = Logger.getLogger(AbstractCrudDao.class);

    private SessionFactory sessionFactory;

    @Autowired
    private IdInjectionStrategy idInjector;

    AbstractCrudDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T create(T object) {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(object);
        idInjector.injectId(object, id);
        session.close();
        return object;
    }

    @Override
    public T delete(T object) {
        Session session = sessionFactory.openSession();
        session.load(object, idInjector.getId(object));
        session.delete(object);
        session.flush();
        session.close();
        return object;
    }

    public T update(T object) {
        checkUpdateAllowed(object);
        Session session = sessionFactory.openSession();
        session.update(object);
        session.flush();
        session.close();
        return object;
    }

    public T read(T object, int id) {
        Session session = sessionFactory.openSession();
        session.load(object, id);
        return object;
    }

    private void checkUpdateAllowed(T object) {
        if(idInjector.getId(object) == null) {
            throw new UpdateException(String.format("%s has no id specified", object));
        }
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}