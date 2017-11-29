DROP SCHEMA IF EXISTS music;
CREATE SCHEMA music;

USE music;

CREATE TABLE artist (
  artist_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
  PRIMARY KEY (artist_id),
  UNIQUE (name)
);

CREATE TABLE album (
  album_id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(50),
  artist_id int NOT NULL,
  PRIMARY KEY (album_id),
  FOREIGN KEY (artist_id) REFERENCES artist(artist_id),
  UNIQUE (title, artist_id)
);

CREATE TABLE track (
  track_id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(50),
  album_id INT NOT NULL,
  PRIMARY KEY (track_id),
  FOREIGN KEY (album_id) REFERENCES album(album_id),
  UNIQUE (title, album_id)
);