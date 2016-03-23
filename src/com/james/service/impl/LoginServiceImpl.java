package com.james.service.impl;

import com.james.dao.LoginDAO;
import com.james.dao.impl.LoginDAOImpl;
import com.james.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private LoginDAO loginDao = new LoginDAOImpl();
	
	/**
	 * 验证账户密码
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean isAuth(String username, String password,String who) {
		return loginDao.isAuth(username, password,who);
	}

	

}
