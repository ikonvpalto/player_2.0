package org.kvp_bld_sck.musicserver.dao;

import org.kvp_bld_sck.musicserver.dao.impl.AlbumDaoImpl;
import org.kvp_bld_sck.musicserver.dao.impl.ArtistDaoImpl;
import org.kvp_bld_sck.musicserver.dao.impl.TrackDaoImpl;

public class DaoFactory {

    private AlbumDao albumDao = new AlbumDaoImpl();
    private ArtistDao artistDao = new ArtistDaoImpl();
    private TrackDao trackDao = new TrackDaoImpl();

    public AlbumDao getAlbumDao() {
        return albumDao;
    }

    public ArtistDao getArtistDao() {
        return artistDao;
    }

    public TrackDao getTrackDao() {
        return trackDao;
    }


    private DaoFactory() {}
    private static DaoFactory factory;
    public static DaoFactory getFactory() {
        if (null == factory)
            factory = new DaoFactory();
        return factory;
    }
}
