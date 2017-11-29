package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.dao.Dao;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class DaoImpl<IdType, Entity> implements Dao<IdType, Entity> {
    protected abstract IdType getId(Entity entity);

    protected abstract Class<Entity> getEntityClass();

    @Override
    public IdType save(Entity entity) {
        try (EntityManagerSession session = new EntityManagerSession()) {
            session.getManager().persist(entity);
            return getId(entity);
        }
    }

    @Override
    public Entity get(IdType id) {
        try (EntityManagerSession session = new EntityManagerSession()) {
            return session.getManager().find(getEntityClass(), id);
        }
    }

    @Override
    public List<Entity> getAll() {
        try (EntityManagerSession session = new EntityManagerSession()) {
            return session.getManager().createQuery("select e from " + getEntityClass().getName() + " e", getEntityClass())
                                       .getResultList();
        }
    }

    @Override
    public void update(Entity entity) {
        try (EntityManagerSession session = new EntityManagerSession()) {
            session.getManager().merge(entity);
        }
    }

    @Override
    public void delete(Entity entity) {
        try (EntityManagerSession session = new EntityManagerSession()) {
            Entity removed = session.getManager().merge(entity);
            session.getManager().remove(removed);
        }
    }

    List<Entity> getByField(String fieldName, Object fieldValue) {
        fieldName = "e." + fieldName;
        StringBuilder query = new StringBuilder()
                .append("select e from ")
                .append(getEntityClass().getName())
                .append(" e where ")
                .append(fieldName)
                .append(" = :fieldValue");

        try (EntityManagerSession session = new EntityManagerSession()) {
            return session.getManager()
                    .createQuery(query.toString(), getEntityClass())
                    .setParameter("fieldValue", fieldValue)
                    .getResultList();
        }
    }
}
