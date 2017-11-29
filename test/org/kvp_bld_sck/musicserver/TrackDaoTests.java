package org.kvp_bld_sck.musicserver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kvp_bld_sck.musicserver.dao.AlbumDao;
import org.kvp_bld_sck.musicserver.dao.ArtistDao;
import org.kvp_bld_sck.musicserver.dao.DaoFactory;
import org.kvp_bld_sck.musicserver.dao.TrackDao;
import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.entity.Artist;
import org.kvp_bld_sck.musicserver.entity.Track;

import java.util.List;
import java.util.logging.Logger;

public class TrackDaoTests {

    private TrackDao trackDao = DaoFactory.getFactory().getTrackDao();
    private AlbumDao albumDao = DaoFactory.getFactory().getAlbumDao();
    private ArtistDao artistDao = DaoFactory.getFactory().getArtistDao();

    @BeforeEach
    void clearDB() {
        List<Track> tracks = trackDao.getAll();
        tracks.forEach(trackDao::delete);
    }

    @Test
    public void testSave() {
        Artist artist = new Artist("vah artist");
        Album album = new Album("vah album", artist);
        Track track = new Track("vah track", album);

        artistDao.save(artist);
        albumDao.save(album);
        long id = trackDao.save(track);
        assertNotEquals(0, id);
    }

    @Test
    public void testGetByTitle() {
        Artist artist = new Artist("vahvah artist");
        Album album = new Album("vahvah album", artist);
        Track track = new Track("vahvah track", album);

        artistDao.save(artist);
        albumDao.save(album);
        trackDao.save(track);
        List<Track> tracks = trackDao.get(track.getTitle());
        assertEquals(1, tracks.size());
        assertEquals(tracks.get(0), track);
    }

    @Test
    public void testGetByAlbum() {
        Artist artist = new Artist("vahvah artist");
        Album album = new Album("vahvah album", artist);
        Track first = new Track("vahvah track", album);
        Track second = new Track("supervah track", album);
        Album bad = new Album("bad album", artist);
        Track third = new Track("not vah track", bad);

        artistDao.save(artist);
        albumDao.save(album);
        albumDao.save(bad);
        first.setId(trackDao.save(first));
        second.setId(trackDao.save(second));
        third.setId(trackDao.save(third));
        List<Track> tracks = trackDao.get(album);
        assertTrue(tracks.contains(first));
        assertTrue(tracks.contains(second));
        assertTrue(!tracks.contains(third));
    }

}