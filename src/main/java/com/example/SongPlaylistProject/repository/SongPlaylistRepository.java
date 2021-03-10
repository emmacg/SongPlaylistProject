package com.example.SongPlaylistProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SongPlaylistProject.domain.SongPlaylist;

@Repository
public interface SongPlaylistRepository extends JpaRepository<SongPlaylist, Long>{
	SongPlaylist findByArtistName(String artistName);
}
