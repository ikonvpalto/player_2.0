package org.kvp_bld_sck.musicserver.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "track")
public class Track implements Serializable {

    @Id
    @Column(name = "track_id")
    @GeneratedValue
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
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

}
