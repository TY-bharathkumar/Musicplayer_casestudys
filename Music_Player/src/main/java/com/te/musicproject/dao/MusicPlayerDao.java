package com.te.musicproject.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.te.musicproject.bean.MusicFiles;



@Repository
public interface MusicPlayerDao{
public List<MusicFiles> playAllSongs();
	
	public List<MusicFiles> getSong(String song_title1);
	
	public boolean addSong(MusicFiles bean);

	
	public List<MusicFiles>deleteSong(int song_id);
	public List<MusicFiles> searchSong(String song);

	boolean editSong(int Song_ID);
}
