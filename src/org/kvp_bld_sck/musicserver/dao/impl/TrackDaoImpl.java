package org.kvp_bld_sck.musicserver.dao.impl;

import org.kvp_bld_sck.musicserver.dao.TrackDao;
import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.entity.Track;

import java.util.List;
import java.util.Map;

public class TrackDaoImpl extends DaoImpl<Long, Track> implements TrackDao {
    @Override
    public List<Track> get(Album album) {
        return getByField("album.id", album.getId());
    }

    @Override
    public Track get(Album album, String title) {
        try (EntityManagerSession session = new EntityManagerSession()) {
            List<Track> result = session.getManager()
                    .createQuery("select t from Track t where t.album.id = :id and t.title = :title", Track.class)
                    .setParameter("id", album.getId())
                    .setParameter("title", title)
                    .getResultList();
            if (0 == result.size())
                return null;
            else
                return result.get(0);
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
