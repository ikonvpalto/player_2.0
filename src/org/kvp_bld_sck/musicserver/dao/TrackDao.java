package org.kvp_bld_sck.musicserver.dao;

import org.kvp_bld_sck.musicserver.entity.Album;
import org.kvp_bld_sck.musicserver.entity.Track;

import java.util.List;

public interface TrackDao extends Dao<Long, Track> {

    List<Track> get(Album album);
    List<Track> get(String title);

}
