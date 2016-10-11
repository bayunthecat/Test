package com.lwd.platform.testing.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryLogger {

    private static final Logger LOG = Logger.getLogger(RepositoryLogger.class);

    @Pointcut("execution(* com.lwd.platform.testing.repo.mysql.AbstractCrudDao.create(..)) && args(objectToPersist)")
    public void createInvoked(Object objectToPersist) {}

    @Pointcut("execution(* com.lwd.platform.testing.repo.mysql.AbstractCrudDao.read(..)) && args(objectToPersist, id)")
    public void readInvoked(Object objectToPersist, int id) {}

    @After("createInvoked(objectToPersist)")
    public void logCreation(Object objectToPersist) {
        LOG.info("Object persisted -> " + objectToPersist);
    }

    @After("readInvoked(objectToPersist, id)")
    public void logReading(Object objectToPersist, int id) {
        LOG.info("Object with id " + id + " read -> " + objectToPersist);
    }
}
