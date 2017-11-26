package org.kvp_bld_sck.musicserver.dao;

import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.entity.Artist;

import java.util.List;

public interface AlbumDao extends Dao<Long, Album> {

    List<Album> get(Artist artist);

}
