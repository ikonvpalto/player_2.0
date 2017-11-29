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
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "album")
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

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if ((null == obj) || !(obj instanceof Album))
            return false;
        Album other = (Album) obj;
        if ((0 < id) && (0 < other.getId()))
            return id == other.getId();
        boolean titleEquals = ((null != title) && (null != other.getTitle()) && (title.equals(other.title)));
        return titleEquals;
    }
}
