package org.kvp_bld_sck.musicserver.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "track")
public class Track implements Serializable {

    @Id
    @Column(name = "track_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    public Track() {}

    public Track(String title, Album album) {
        this.title = title;
        this.album = album;
    }

    public Track(long id, String title, Album album) {
        this.id = id;
        this.title = title;
        this.album = album;
    }

    public Track(long id) {
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if ((null == obj) || !(obj instanceof Track))
            return false;
        Track other = (Track) obj;
        if ((0 < id) && (0 < other.getId()))
            return id == other.getId();
        boolean titleEquals = ((null != title) && (null != other.getTitle()) && (title.equals(other.title)));
        return titleEquals;
    }
}
