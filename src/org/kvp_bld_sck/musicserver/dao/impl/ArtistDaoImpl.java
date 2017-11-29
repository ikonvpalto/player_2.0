package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.dao.ArtistDao;
import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.entity.Artist;

import java.util.List;

public class ArtistDaoImpl extends DaoImpl<Long, Artist> implements ArtistDao {
    @Override
    protected Long getId(Artist artist) {
        return artist.getId();
    }

    @Override
    protected Class<Artist> getEntityClass() {
        return Artist.class;
    }

    @Override
    public Artist get(String name) {
        List<Artist> artists = getByField("name", name);
        if (0 == artists.size())
                return null;
            else
                return artists.get(0);
//        try (EntityManagerSession session = new EntityManagerSession()) {
//            List<Artist> artists = session.getManager().createQuery("select a from Artist a where a.name = :name", Artist.class)
//                                                       .setParameter("name", name)
//                                                       .getResultList();
//            if (0 == artists.size())
//                return null;
//            else
//                return artists.get(0);
//        }
    }

}
