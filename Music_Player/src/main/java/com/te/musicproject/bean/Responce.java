package com.te.musicproject.bean;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;



@Data
@JsonRootName("response")
@JsonPropertyOrder({ "status", "msg" })
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Responce implements Serializable{


	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;

	private String msg;



}