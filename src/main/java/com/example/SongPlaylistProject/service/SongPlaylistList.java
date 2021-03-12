package com.example.SongPlaylistProject.service;

import java.util.List;

import com.example.SongPlaylistProject.domain.SongPlaylist;

public class SongPlaylistList implements SongPlaylistService {


		
		private List<SongPlaylist> songplaylists;

		public SongPlaylistList(List<SongPlaylist> songplaylists) {
			super();
			this.songplaylists = songplaylists;
		}

		@Override
		public SongPlaylist createSongPlaylist(SongPlaylist songplaylist) {
			this.songplaylists.add(songplaylist);
			SongPlaylist added = this.songplaylists.get(this.songplaylists.size() - 1);
			return added;
		}


		@Override
		public SongPlaylist getSongPlaylistById(Long id) {
			return this.songplaylists.get(id.intValue());
		}

		
		@Override
		public boolean removeSongPlaylist(Long id) {
			// TODO Auto-generated method stub
			SongPlaylist songplaylist = this.songplaylists.get(id.intValue());
			this.songplaylists.remove(id.intValue());
			return !this.songplaylists.contains(songplaylist);

	}

		@Override
		public SongPlaylist updateSongPlaylist(Long id, SongPlaylist newSongPlaylist) {
			this.removeSongPlaylist(id);
			this.songplaylists.add(id.intValue(), newSongPlaylist);
			return this.songplaylists.get(id.intValue());
		}

		@Override
		public List<SongPlaylist> read() {
			return this.songplaylists;
		}
	
}
