package com.example.SongPlaylistProject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
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

		SongPlaylist newSongPlaylist = new SongPlaylist("Artist Name", "Song Name");
		SongPlaylist savedSongPlaylist = new SongPlaylist(1L, "Artist Name", "Song Name");

		Mockito.when(this.repo.save(newSongPlaylist)).thenReturn(savedSongPlaylist);

		assertThat(this.service.createSongPlaylist(newSongPlaylist)).isEqualTo(savedSongPlaylist);

		verify(this.repo, Mockito.times(1)).save(newSongPlaylist);

	}

	@Test
	void findByIDTest() {
		Long id = 1L; 
		Optional<SongPlaylist> optionalSongPlaylist = Optional.of(new SongPlaylist(id, "Artist Name", "Song Name"));
		SongPlaylist newSongPlaylist = new SongPlaylist(id, "Artist Name", "Song Name");
		Mockito.when(this.repo.findById(id)).thenReturn(optionalSongPlaylist);
		assertThat(this.service.getSongPlaylistById(id)).isEqualTo(newSongPlaylist);	
		verify(this.repo, times(1)).findById(id);
	}

	@Test
	void testUpdate() {

		Long id = 1L;
		SongPlaylist newSongPlaylist = new SongPlaylist("Artist Name", "Song Name");
		Optional<SongPlaylist> optionalSongPlaylist = Optional.of(new SongPlaylist(id, null, null));
		SongPlaylist updatedSongPlaylist = new SongPlaylist(id, newSongPlaylist.getArtistName(),
				newSongPlaylist.getSongName());

		Mockito.when(this.repo.findById(id)).thenReturn(optionalSongPlaylist);
		Mockito.when(this.repo.save(updatedSongPlaylist)).thenReturn(updatedSongPlaylist);

		assertThat(this.service.updateSongPlaylist(id, newSongPlaylist)).isEqualTo(updatedSongPlaylist);
		
		verify(this.repo, times(1)).findById(id);
	}

	@Test
	void testRemove() {
		Long id = 1L;
		Mockito.when(this.repo.existsById(id)).thenReturn(true, false);

		assertThat(this.service.removeSongPlaylist(id)).isTrue();

		verify(this.repo, times(1)).deleteById(id);
		verify(this.repo, times(1)).existsById(id);


	}

	@Test
	void readSongPlaylistTest() {
		List<SongPlaylist> readingSongPlaylist = new ArrayList<>(); 
		readingSongPlaylist.add(new SongPlaylist("Artist", "Song"));
		Mockito.when(repo.findAll()).thenReturn(readingSongPlaylist);

		assertThat(this.service.read()).isEqualTo(readingSongPlaylist);

		verify(this.repo, times(1)).findAll();
	}

}
