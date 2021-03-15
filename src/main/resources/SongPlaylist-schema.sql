
DROP TABLE IF EXISTS `song_playlist` CASCADE;
CREATE TABLE song_playlist (
id BIGINT AUTO_INCREMENT, 
artist_name VARCHAR(255),
song_name VARCHAR(255),
PRIMARY KEY (id)
);
