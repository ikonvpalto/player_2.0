package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.dao.AlbumDao;
import org.kvp_bld_sck.musicserver.entity.Artist;

import java.util.List;

public class AlbumDaoImpl extends DaoImpl<Long, Album> implements AlbumDao {
    @Override
    public List<Album> get(Artist artist) {
        return getByField("artist.id", artist.getId());
//        try (EntityManagerSession session = new EntityManagerSession()) {
//            return session.getManager().createQuery("select a from Album a where a.artist.id = :id", Album.class)
//                    .setParameter("id", artist.getId())
//                    .getResultList();
//        }
    }

    @Override
    public List<Album> get(String title) {
        return getByField("title", title);
//        try (EntityManagerSession session = new EntityManagerSession()) {
//            return session.getManager().createQuery("select a from Album a where a.title = :title", Album.class)
//                    .setParameter("title", title)
//                    .getResultList();
//        }
    }

    @Override
    protected Long getId(Album album) {
        return album.getId();
    }

    @Override
    protected Class<Album> getEntityClass() {
        return Album.class;
    }
}
