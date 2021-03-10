package com.example.SongPlaylistProject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.SongPlaylistProject.domain.SongPlaylist;
import com.example.SongPlaylistProject.repository.SongPlaylistRepository;


@SpringBootTest
	@ActiveProfiles("test")
	public class SongPlaylistServiceTest {

		@Autowired
		private SongPlaylistServiceDB service;
		
		@MockBean
		
		private SongPlaylistRepository repo;
		
		@Test
		void testCreate() {
			
			SongPlaylist newSongPlaylist = new SongPlaylist();
			SongPlaylist savedSongPlaylist = new SongPlaylist();		
					
			Mockito.when(this.repo.save(newSongPlaylist)).thenReturn(savedSongPlaylist);
			
			assertThat(this.service.createSongPlaylist(newSongPlaylist)).isEqualTo(savedSongPlaylist);
		}
		
		@Test
		void testUpdate() {
		
		Long id = 1L;
		SongPlaylist newSongPlaylist = new SongPlaylist("Artist Name", "Song Name");
		Optional<SongPlaylist> optionalSongPlaylist = Optional.of(new SongPlaylist(id, null, null));
		SongPlaylist updatedSongPlaylist = new SongPlaylist(id, newSongPlaylist.getArtistName(), newSongPlaylist.getSongName());
		
		Mockito.when(this.repo.findById(id)).thenReturn(optionalSongPlaylist);
		Mockito.when(this.repo.save(updatedSongPlaylist)).thenReturn(updatedSongPlaylist);

		assertThat(this.service.updateSongPlaylist(id, newSongPlaylist)).isEqualTo(updatedSongPlaylist);
	 }
		
		@Test
		void testRemove() {
			 
			
			
		}
	}


	

