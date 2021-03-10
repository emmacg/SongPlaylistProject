
DROP TABLE IF EXISTS `songplaylist` CASCADE;
CREATE TABLE songplaylist (
id BIGINT AUTO_INCREMENT, 
artist_name VARCHAR(255),
song_name VARCHAR(255),
PRIMARY KEY (id)
);
