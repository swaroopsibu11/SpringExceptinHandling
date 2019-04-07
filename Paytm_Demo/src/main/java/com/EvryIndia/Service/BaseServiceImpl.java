package com.EvryIndia.Service;

import com.EvryIndia.Dao.BaseDao;
import com.EvryIndia.Dao.BaseDaoImpl;
import com.EvryIndia.Model.EV_UserLogin;

public class BaseServiceImpl implements BaseService 
{
	private BaseDao loginDao = new BaseDaoImpl();

	public boolean login(String loginId, String password) {
		return loginDao.login(loginId, password);
	}

	public String registration(EV_UserLogin user) {
		return loginDao.register(user);
	}

}
