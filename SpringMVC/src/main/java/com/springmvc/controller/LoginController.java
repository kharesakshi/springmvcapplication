package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmvc.dao.LoginDaoImplementation;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.SQLException;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDaoImplementation ld;
	
	@RequestMapping(value="/loginPage")
	public ModelAndView getView() {
		ModelAndView mav=new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
		public ModelAndView loginUser(HttpServletRequest request,HttpServletResponse response) throws SQLException{
			String userId=request.getParameter("username");
			String password=request.getParameter("password");
			
			if(ld.validate(userId, password)) {
				return new ModelAndView("home");
			}
			else {
				return new ModelAndView("login");
			}
		}
		


}
