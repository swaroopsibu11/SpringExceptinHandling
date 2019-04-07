package com.EvryIndia.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EvryIndia.Dao.BaseDao;
import com.EvryIndia.Dao.BaseDaoImpl;
import com.EvryIndia.Model.EV_UserLogin;

public class EV_RegisterServlet 
{
	private static final long serialVersionUID = 1L;
    
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.sendRedirect("userRegistration.jsp");
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String msg = "Password and Conform Passwords must be same";
	  String page = "userRegistration.jsp";
	  if(request.getParameter("password").equals(request.getParameter("confPassword"))){
	   EV_UserLogin user = new EV_UserLogin();
	   user.setUserId(request.getParameter("userId"));  
	   user.setFirstName(request.getParameter("firstName"));
	   user.setLastName(request.getParameter("lastName"));
	   user.setLoginId(request.getParameter("loginId"));
	   user.setPassword(request.getParameter("password"));
	   
	   System.out.println(user.toString());
	   BaseDao baseDao = new BaseDaoImpl();
	   msg = baseDao.register(user);
	   page = "login.jsp";
	  } 
	  request.setAttribute("msg2", msg);
	  request.getRequestDispatcher(page).include(request, response);
	 }
}
