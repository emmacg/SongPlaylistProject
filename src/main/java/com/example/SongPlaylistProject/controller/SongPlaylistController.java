package com.example.SongPlaylistProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SongPlaylistProject.domain.SongPlaylist;
import com.example.SongPlaylistProject.service.SongPlaylistService;

@CrossOrigin
@RestController
public class SongPlaylistController {
	private SongPlaylistService service; 
	
	public SongPlaylistController(SongPlaylistService service) {
		super(); 
		this.service = service; 
		
	}

	@PostMapping("/create") 
	public ResponseEntity<SongPlaylist> createSongPlaylist(@RequestBody SongPlaylist songplaylist) {
		return new ResponseEntity<SongPlaylist>(this.service.createSongPlaylist(songplaylist), HttpStatus.CREATED); 
		
	}
	
	@GetMapping("/read")

	public ResponseEntity <List<SongPlaylist>> read() {
		return ResponseEntity.ok(this.service.read());
	
	}
	
	@PutMapping("/updateSongPlaylist/{id}")
	public SongPlaylist updateSongPlaylist(@PathVariable Long Id, @RequestBody SongPlaylist newSongPlaylist) {
		return this.service.updateSongPlaylist(Id, newSongPlaylist);
	}
	
	@GetMapping("/getSongPlaylist/{id}")
	public SongPlaylist getSongPlaylistById(@PathVariable Long Id) {
		return this.service.getSongPlaylistById(Id);
		
	}

	@DeleteMapping("/removeSongPlaylist/{id}")
	public boolean removeSongPlaylist(@PathVariable Long Id) {
		return this.service.removeSongPlaylist(Id);

}
}
