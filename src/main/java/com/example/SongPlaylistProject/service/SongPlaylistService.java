package com.example.SongPlaylistProject.service;

import java.util.List;

import com.example.SongPlaylistProject.domain.SongPlaylist;

public interface SongPlaylistService {


	SongPlaylist getSongPlaylistById(Long Id);

	SongPlaylist updateSongPlaylist(Long Id, SongPlaylist newSongPlaylist);

	List<SongPlaylist> read();

	SongPlaylist createSongPlaylist(SongPlaylist songplaylist);

	boolean removeSongPlaylist(Long Id);


}
