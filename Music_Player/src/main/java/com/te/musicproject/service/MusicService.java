package com.te.musicproject.service;

import java.util.List;

import com.te.musicproject.bean.MusicFiles;

public interface MusicService {
public List<MusicFiles> playAllSongs();
	
	public List<MusicFiles> getSong(String song_title1);
	
	public boolean addSong(MusicFiles infoBean);
	
	public boolean editSong(int song_ID);
	public List<MusicFiles> deleteSong(int song_ID);
	public List<MusicFiles> searchSong(String song);
}
