package org.kvp_bld_sck.musicserver.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSession implements AutoCloseable {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    private EntityManager manager;

    public EntityManagerSession() {
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }

    public EntityManager getManager() {
        return manager;
    }

    @Override
    public void close() {
        manager.getTransaction().commit();
        manager.close();
    }
}
