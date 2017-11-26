package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.dao.ArtistDao;
import org.kvp_bld_sck.musicserver.entity.Artist;

public class ArtistDaoImpl extends DaoImpl<Long, Artist> implements ArtistDao {
    @Override
    protected Long getId(Artist artist) {
        return artist.getId();
    }

    @Override
    protected Class<Artist> getEntityClass() {
        return Artist.class;
    }
}
