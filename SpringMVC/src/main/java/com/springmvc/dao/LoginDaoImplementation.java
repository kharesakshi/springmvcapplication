package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Service;

@Service
public class LoginDaoImplementation {

	@Autowired
	private DataSource dataSource;
	
	public boolean validate(String userId,String password) throws SQLException {
		boolean s=false;
		
		PreparedStatement ps=dataSource.getConnection().prepareStatement("select * from users where userid='"+userId+"' and password='"+password+"'");
		ResultSet rs=ps.executeQuery();
		s=rs.next();
		return s;
	}
}
