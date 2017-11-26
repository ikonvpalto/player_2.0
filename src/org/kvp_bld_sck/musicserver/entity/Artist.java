package org.kvp_bld_sck.musicserver.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "artist")
public class Artist implements Serializable {

    @Id
    @Column(name = "artist_id")
    @GeneratedValue
    private long id;

    @Column(name = "title", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Album> albums;

    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }

    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
