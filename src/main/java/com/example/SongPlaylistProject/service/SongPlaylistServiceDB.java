package com.example.SongPlaylistProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SongPlaylistProject.domain.SongPlaylist;
import com.example.SongPlaylistProject.repository.SongPlaylistRepository;

@Service
public class SongPlaylistServiceDB implements SongPlaylistService {
	
	private SongPlaylistRepository repo;
	

	public SongPlaylistServiceDB(SongPlaylistRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public List<SongPlaylist> read() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}


	@Override
	public SongPlaylist getSongPlaylistById(Long Id) {
		Optional<SongPlaylist> GetById = this.repo.findById(Id);
		return GetById.orElse(null);
				
	}
	
	@Override
	public boolean removeSongPlaylist(Long Id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(Id);
		return this.repo.existsById(Id);
	}
	

	@Override
	public SongPlaylist updateSongPlaylist(Long id, SongPlaylist newSongPlaylist) {
		SongPlaylist existing = this.getSongPlaylistById(id);

		existing.setArtistName(newSongPlaylist.getArtistName());
		existing.setSongName(newSongPlaylist.getSongName());
		
		SongPlaylist updated = this.repo.save(existing);

		return updated;
	
	}



	@Override
	public SongPlaylist createSongPlaylist(SongPlaylist songplaylist) {
		SongPlaylist saved = this.repo.save(songplaylist);
		return saved;
	}
}
