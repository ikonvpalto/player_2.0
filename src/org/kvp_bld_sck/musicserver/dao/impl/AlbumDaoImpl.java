package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.dao.AlbumDao;
import org.kvp_bld_sck.musicserver.entity.Artist;

import java.util.List;
import java.util.Map;

public class AlbumDaoImpl extends DaoImpl<Long, Album> implements AlbumDao {
    @Override
    public List<Album> get(Artist artist) {
        return getByField("artist.id", artist.getId());
    }

    @Override
    public Album get(Artist artist, String title) {
        try (EntityManagerSession session = new EntityManagerSession()) {
            List<Album> result = session.getManager()
                    .createQuery("select a from Album a where a.artist.id = :id and a.title = :title", Album.class)
                    .setParameter("id", artist.getId())
                    .setParameter("title", title)
                    .getResultList();
            if (0 == result.size())
                return null;
            else
                return result.get(0);
        }
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
