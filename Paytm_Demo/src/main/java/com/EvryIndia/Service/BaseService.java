package com.EvryIndia.Service;

import com.EvryIndia.Model.EV_UserLogin;

public interface BaseService 
{
	public boolean login(String username, String password);

	public String registration(EV_UserLogin user);
}
