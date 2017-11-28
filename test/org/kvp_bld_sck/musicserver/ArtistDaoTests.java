package org.kvp_bld_sck.musicserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.kvp_bld_sck.musicserver.dao.ArtistDao;
import org.kvp_bld_sck.musicserver.dao.DaoFactory;
import org.kvp_bld_sck.musicserver.entity.Artist;


class ArtistDaoTests {


    @Test
    void testSave() {
        Artist artist = new Artist("kvp");
        ArtistDao artistDao = DaoFactory.getFactory().getArtistDao();
        assertEquals(1, (long) artistDao.save(artist));
    }

}