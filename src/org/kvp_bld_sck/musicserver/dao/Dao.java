package org.kvp_bld_sck.musicserver.dao;

import java.util.List;

public interface Dao<IdType, Entity> {

    IdType save(Entity entity);
    Entity get(IdType id);
    List<Entity> getAll();
    void update(Entity entity);
    void delete(Entity entity);

}
