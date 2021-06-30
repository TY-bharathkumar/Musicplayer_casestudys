package com.te.musicproject.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.musicproject.bean.MusicFiles;
@Repository
public class MusicDaoimple implements MusicPlayerDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<MusicFiles> playAllSongs() {
		List<MusicFiles> list=null;
		try {
			EntityManager manager=factory.createEntityManager();
			Query query=manager.createQuery("from MusicFiles");
			list=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<MusicFiles> searchSong(String song) {
		List<MusicFiles> list = null;
		try {
			EntityManager manager=factory.createEntityManager();
			Query query=manager.createQuery("from MusicFiles where Song_Title=:song");
			query.setParameter("song", song);
			list=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<MusicFiles> deleteSong(int song_id) {
		List<MusicFiles> list=null;
		MusicFiles m=new MusicFiles();
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {

			transaction.begin();
			Query query=manager.createQuery("delete from MusicFiles where Song_ID=:songs");
			query.setParameter(song_id,"songs");
			list=query.getResultList();
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public List<MusicFiles> getSong(String song_title1) {
		EntityManager manager =factory.createEntityManager();
		List<MusicFiles> list=null;
		try {
			Query query=manager.createQuery("from MusicFiles where Song_Title=:song_title");
			query.setParameter("song_title", song_title1);
			list=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addSong(MusicFiles bean) {
		EntityManager manager =factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		MusicFiles files=new MusicFiles();
		try {
			transaction.begin();
			Query query=manager.createQuery("Insert into MusicFiles(Song_ID,Song_Title,Artist_Name,Song_Location,Description) values=(?,?,?,?,?)");
			query.setParameter(1, files.getSong_ID());
			query.setParameter(2, files.getSong_Title());
			query.setParameter(3, files.getArtist_Name());
			query.setParameter(4, files.getSong_Location());
			query.setParameter(5, files.getDescription());
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public boolean editSong(int Song_ID) {
		EntityManager manager =factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		try {
			transaction.begin();
			Query query=manager.createQuery("From MusicFiles where Song_ID=:id");
			query.setParameter(Song_ID, "id");
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return true;
	}



}
