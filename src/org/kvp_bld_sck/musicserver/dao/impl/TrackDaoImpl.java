package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.dao.TrackDao;
import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.entity.Track;

import java.util.List;

public class TrackDaoImpl extends DaoImpl<Long, Track> implements TrackDao {
    @Override
    public List<Track> get(Album album) {
        return getByField("album.id", album.getId());
//        try (EntityManagerSession session = new EntityManagerSession()) {
//            return session.getManager().createQuery("select t from Track t where t.album.id = :id", Track.class)
//                                       .setParameter("id", album.getId())
//                                       .getResultList();
//        }
    }

    @Override
    public List<Track> get(String title) {
        return getByField("title", title);
//        try (EntityManagerSession session = new EntityManagerSession()) {
//            return session.getManager().createQuery("select t from Track t where t.title = :title", Track.class)
//                                       .setParameter("title", title)
//                                       .getResultList();
//        }
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
