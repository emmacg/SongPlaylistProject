package com.example.SongPlaylistProject.rest;

	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

	import java.util.List;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
	import org.springframework.http.MediaType;
	import org.springframework.test.context.ActiveProfiles;
	import org.springframework.test.context.jdbc.Sql;
	import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.RequestBuilder;
	import org.springframework.test.web.servlet.ResultMatcher;

import com.example.SongPlaylistProject.domain.SongPlaylist;
import com.fasterxml.jackson.databind.ObjectMapper;

	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@AutoConfigureMockMvc
	@Sql(scripts= {"classpath:SongPlaylist-Schema.sql", "classpath:SongPlaylist-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@ActiveProfiles("test")
	public class TestController {
		
		@Autowired
		private MockMvc mockMVC;
		
		@Autowired
		private ObjectMapper mapper;
		
		
		@Test
		
		public void testCreateSongPlaylist() throws Exception {
			
			SongPlaylist newSongPlaylist = new SongPlaylist("Artist", "Song");
			String jsonSongPlaylist = this.mapper.writeValueAsString(newSongPlaylist); 
			RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(jsonSongPlaylist);
			SongPlaylist returnSongPlaylist = new SongPlaylist(2L, "Artist", "Song");
			String returnJsonSongPlaylist = this.mapper.writeValueAsString(returnSongPlaylist); 
			ResultMatcher matchingSongPlaylist = content().json(returnJsonSongPlaylist);
			ResultMatcher matchStatus = status().isOk(); 
			this.mockMVC.perform(mockRequest).andExpect(matchingSongPlaylist).andExpect(matchStatus);
			
		}
		@Test
		
		public void readTest() throws Exception {
			SongPlaylist testSongPlaylist = new SongPlaylist(1L, "Artist", "Song");
			List<SongPlaylist> allSongPlaylists = List.of(testSongPlaylist);
			String testSongPlaylistAsJSON = this.mapper.writeValueAsString(allSongPlaylists);

			RequestBuilder mockRequest = get("/read");

			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(testSongPlaylistAsJSON);

			this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		
		public void testUpdateSongPlaylist() throws Exception {
			
			SongPlaylist newSongPlaylist = new SongPlaylist("Artist", "Song");
			String jsonSongPlaylist = this.mapper.writeValueAsString(newSongPlaylist); 
			RequestBuilder mockRequest = put("/update").contentType(MediaType.APPLICATION_JSON).content(jsonSongPlaylist);
			SongPlaylist returnSongPlaylist = new SongPlaylist(1L, "Artist", "Song");
			String returnJsonSongPlaylist = this.mapper.writeValueAsString(returnSongPlaylist); 
			ResultMatcher matchingSongPlaylist = content().json(returnJsonSongPlaylist);
			ResultMatcher matchStatus = status().isOk(); 
			this.mockMVC.perform(mockRequest).andExpect(matchingSongPlaylist).andExpect(matchStatus);
			
		}
		@Test
		
		public void testDeleteSongPlaylist() throws Exception {
			

			RequestBuilder mockRequest = delete("/removeSongPlaylist/1").contentType(MediaType.APPLICATION_JSON);
			
			ResultMatcher matchStatus = status().isOk(); 
		
			this.mockMVC.perform(mockRequest).andExpect(matchStatus);
			
		}
		@Test
		
		public void testReadSongPlaylist() throws Exception {
			
			SongPlaylist testSongPlaylist = new SongPlaylist(1L, "Artist", "Song");
			String testSongPlaylistAsJSON = this.mapper.writeValueAsString(testSongPlaylist);

			RequestBuilder mockRequest = get("/getSongPlaylist/1");

			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(testSongPlaylistAsJSON);

			this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
		}

	}


