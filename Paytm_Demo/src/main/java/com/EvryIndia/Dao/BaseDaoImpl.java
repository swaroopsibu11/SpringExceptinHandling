package com.EvryIndia.Dao;

import org.hibernate.Session;

import com.EvryIndia.DbUtil.EV_Paytm_Util;
import com.EvryIndia.Model.EV_UserLogin;

public class BaseDaoImpl implements BaseDao
{

	public boolean login(String username, String password) 
	{
		Session session = EV_Paytm_Util.getSession();
		  if (session != null) {
		   try {
			   EV_UserLogin user = (EV_UserLogin) session.get(EV_UserLogin.class, username);
		    if (password.equals(user.getPassword())) {
		     System.out.println("User: " + user.toString());
		     return true;
		    }
		   } catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		      + exception.getMessage());
		    return false;
		   }

		  } else {
		   System.out.println("DB server down.....");
		  }
		  return false;

	}

	public String register(EV_UserLogin user) 
	{
		String msg = "Registration unsuccessful, try again.....";
		  Session session = EV_Paytm_Util.getSession();
		  if (session != null) {
		   try {
		    if (user != null) {
		     String username = (String) session.save(user);
		     session.beginTransaction().commit();
		     msg = "User " + username
		       + " created successfully, please login...";
		    }
		   } catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		      + exception.getMessage());
		   }

		  } else {
		   System.out.println("DB server down.....");
		  }
		  System.out.println("msg:" + msg);
		  return msg;
	}

}
