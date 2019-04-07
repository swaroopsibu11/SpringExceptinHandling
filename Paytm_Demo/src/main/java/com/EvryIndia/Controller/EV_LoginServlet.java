package com.EvryIndia.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EvryIndia.Service.BaseService;
import com.EvryIndia.Service.BaseServiceImpl;

public class EV_LoginServlet 
{
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.sendRedirect("login.jsp");
	 }

	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String loginId = request.getParameter("loginId");
	  String password = request.getParameter("password");
	  
	  System.out.println(loginId + " :: " + password);
	  String page = "login.jsp";
	  if(loginId.trim().length() >= 0 && loginId != null &&
	    password.trim().length() >= 0 && password != null) {
	   BaseService loginService = new BaseServiceImpl();
	   boolean flag = loginService.login(loginId, password);
	   if(flag) {
	    System.out.println("Login success!!!");
	    request.setAttribute("username", loginId);
	    request.setAttribute("msg", "Login Success.....");
	    page = "home.jsp";
	   } else {
	    request.setAttribute("msg", "Wrong Username or Password, Try again!!!");
	   }
	  } else {
	   request.setAttribute("msg", "Please enter username and password...");
	  }
	  request.getRequestDispatcher(page).include(request, response);
	 }
}
