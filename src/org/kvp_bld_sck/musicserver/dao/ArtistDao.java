package org.kvp_bld_sck.musicserver.dao;

import org.kvp_bld_sck.musicserver.entity.Artist;

public interface ArtistDao  extends Dao<Long, Artist>  {

    Artist get(String name);

}
