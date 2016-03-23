package com.james.dao;

public interface LoginDAO {
	/**
	 * 验证
	 * @param username
	 * @param password
	 * @param who
	 * @return
	 */
	public boolean isAuth(String username, String password,String who);

}
