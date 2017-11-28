package org.kvp_bld_sck.musicserver.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Getter @Setter
    private long id;

    @Column(name = "title")
//    @Getter @Setter
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @Getter @Setter
    private Artist artist;

    @OneToMany(cascade = CascadeType.ALL)
//    @Getter @Setter
    private List<Track> tracks;

    public Album() {}

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }

    public Album(long id, String title, Artist artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public Album(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
