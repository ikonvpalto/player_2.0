package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.dao.TrackDao;
import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.entity.Track;

import java.util.List;

public class TrackDaoImpl extends DaoImpl<Long, Track> implements TrackDao {
    @Override
    public List<Track> get(Album album) {
        try (EntityManagerSession session = new EntityManagerSession()) {
            return session.getManager().createQuery("select t from Track t where t.album.id = :id", Track.class)
                                       .setParameter("id", album.getId())
                                       .getResultList();
        }
    }

    @Override
    protected Long getId(Track track) {
        return track.getId();
    }

    @Override
    protected Class<Track> getEntityClass() {
        return Track.class;
    }

}
