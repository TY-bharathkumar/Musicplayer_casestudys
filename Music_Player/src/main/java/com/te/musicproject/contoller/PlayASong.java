package com.te.musicproject.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.te.musicproject.bean.MusicFiles;
import com.te.musicproject.bean.Responce;
import com.te.musicproject.service.MusicService;
@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class PlayASong {
	@Autowired
	MusicService service;

	@GetMapping(path="/playall",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<MusicFiles> getAllSongs(){
		List<MusicFiles> list=service.playAllSongs();
		return list;
	}

	@GetMapping(path="/searchsong/{song}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<MusicFiles> serachSong(@PathVariable String song){
		List<MusicFiles> songList=service.searchSong(song);
		Responce responce=new Responce();
		if(songList!=null) {
			responce.setStatusCode(200);
			responce.setMsg("Songs are present in the database");
		}else {
			responce.setMsg("Data is not present");
			responce.setStatusCode(404);
		}
		return songList;
	}

	@GetMapping(path="/getsong/{SongTitle}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<MusicFiles> getSong(String SongTitle){
		List<MusicFiles> getSongs=service.getSong(SongTitle);	
		return getSongs;
	}

	@GetMapping(path="/edit/{Song_ID}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public boolean editSong(int Song_ID) {
		boolean editSongs=service.editSong(Song_ID);
		Responce re=new Responce();
		if(Song_ID!=0) {
			re.setMsg("Song is Found");
			re.setStatusCode(200);
		}else {
			re.setMsg("detailes not found");
			re.setStatusCode(404);
		}
		return editSongs;
	}
	@GetMapping(path="/addsongs",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public boolean addSongs(MusicFiles bean){
		boolean list=service.addSong(bean);
		return list;

	}
}
