package com.te.musicplayer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class Entityconfig {
	public LocalEntityManagerFactoryBean getMusic(){
		LocalEntityManagerFactoryBean factoryBean =new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("MusicPlayer");
		return factoryBean;
	}
}
