package com.example.SongPlaylistProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class SongPlaylist {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String artistName; 
	private String songName;
	
	
	public SongPlaylist(String artistName, String songName) {
		super();
		this.artistName = artistName;
		this.songName = songName;
	}
	
	
	public SongPlaylist(Long Id, String artistName, String songName) {
		super();
		this.Id = Id;
		this.artistName = artistName;
		this.songName = songName;
	}

	public SongPlaylist() {
		super();
		
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((artistName == null) ? 0 : artistName.hashCode());
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SongPlaylist other = (SongPlaylist) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (artistName == null) {
			if (other.artistName != null)
				return false;
		} else if (!artistName.equals(other.artistName))
			return false;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SongPlaylist [Id=" + Id + ", artistName=" + artistName + ", songName=" + songName + ", getId()="
				+ getId() + ", getArtistName()=" + getArtistName() + ", getSongName()=" + getSongName()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
