package com.te.musicproject.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="musicfiles")
@Entity
public class MusicFiles implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int Song_ID;
	@Column
	private String Song_Title;
	@Column
	private String Artist_Name;
	@Column
	private String Song_Location;
	@Column
	private String Description;
	

}
