package org.kvp_bld_sck.musicserver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kvp_bld_sck.musicserver.dao.ArtistDao;
import org.kvp_bld_sck.musicserver.dao.DaoFactory;
import org.kvp_bld_sck.musicserver.entity.Artist;

import java.util.List;


class ArtistDaoTests {

    private ArtistDao artistDao = DaoFactory.getFactory().getArtistDao();

    @BeforeEach
    void clearDB() {
        List<Artist> artists = artistDao.getAll();
        artists.forEach(artistDao::delete);
    }

    @Test
    void testSave() {
        Artist artist = new Artist("kvp");
        assertNotEquals(0, artistDao.save(artist));
    }

    @Test
    void testGetById() {
        Artist artist = new Artist("super kvp");
        artistDao.save(artist);
        Artist notOther = artistDao.get(artist.getId());
        assertEquals(notOther, artist);
    }

    @Test
    void testGetByName() {
        Artist artist = new Artist("blabla");
        artistDao.save(artist);
        Artist notOther = artistDao.get(artist.getName());
        assertEquals(notOther, artist);
    }

    @Test
    void testUpdate() {
        Artist artist = new Artist("antichrist kvp");
        artistDao.save(artist);
        artist.setName("rainbow kvp");
        artistDao.update(artist);
        Artist notOther = artistDao.get(artist.getId());
        assertEquals(notOther, artist);
    }

    @Test
    void testDelete() {
        Artist artist = new Artist("nagib kvp");
        artistDao.save(artist);
        long id = artist.getId();
        artistDao.delete(artist);
        Artist notExists = artistDao.get(id);
        assertEquals(null, notExists);
    }

    @Test
    void testGetAll() {
        Artist first = new Artist("kvp1");
        Artist second = new Artist("kvp2");
        Artist third = new Artist("kvp3");

        artistDao.save(first);
        artistDao.save(second);
        artistDao.save(third);

        List<Artist> artists = artistDao.getAll();
        assertTrue(artists.contains(first));
        assertTrue(artists.contains(second));
        assertTrue(artists.contains(third));
    }

}