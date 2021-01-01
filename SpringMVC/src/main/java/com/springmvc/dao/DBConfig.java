package com.springmvc.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmd.setUrl("jdbc:mysql://localhost:3308/login");
		dmd.setUsername("root");
		dmd.setPassword("stars19");

		return dmd;
	}

}
