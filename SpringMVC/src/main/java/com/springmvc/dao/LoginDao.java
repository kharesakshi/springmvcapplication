package com.springmvc.dao;

import java.sql.SQLException;
public interface LoginDao {
	
	public boolean validate(String userId,String password) throws SQLException;
}
