package com.te.musicproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.musicproject.bean.MusicFiles;
import com.te.musicproject.dao.MusicPlayerDao;

@Service
public class PlayASongImplementation implements  MusicService {
@Autowired 
MusicPlayerDao dao;
	@Override
	public List<MusicFiles> playAllSongs() {
		// TODO Auto-generated method stub
		return dao.playAllSongs();
	}

	@Override
	public List<MusicFiles> getSong(String song_title1) {
		// TODO Auto-generated method stub
		return dao.getSong(song_title1);
	}

	@Override
	public boolean addSong(MusicFiles infoBean) {
		// TODO Auto-generated method stub
		return dao.addSong(infoBean);
	}

	@Override
	public List<MusicFiles> deleteSong(int song_id) {
		// TODO Auto-generated method stub
		return dao.deleteSong(song_id);
	}

	@Override
	public List<MusicFiles> searchSong(String song) {
		// TODO Auto-generated method stub
		return dao.searchSong(song);
	}

	@Override
	public boolean editSong(int Song_ID) {
		// TODO Auto-generated method stub
		return dao.editSong(Song_ID);
	}
	


}
