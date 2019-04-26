package com.admin.service;


import com.admin.dao.AdminDao;
import com.admin.domain.Admin;

/**
 * 管理员业务
 * @author tq
 */
public class AdminService {

	/**
	 * 登陆业务方法
	 * @param username
	 * @param password
	 * @return Admin
	 * @throws Exception 
	 */
	public Admin login(String username, String password) throws Exception {
		//调用dao层获取管理员数据的方法
		Admin admin = new AdminDao().getAdmin(username,password);
		//登录校验
		//若获取的数据不为空，说明存在该管理员，返回
		if(admin != null){
			return admin;
		}else{
			//否则，抛出异常
			if(username==""){
				throw new Exception("用户名不能为空！");
			}else if(password==""){
				throw new Exception("密码不能为空！");
			}else{
				throw new Exception("用户名或密码错误！");
			}
		}
	}
	
	public boolean regist(String username, String password) throws Exception {
		int count = new AdminDao().insertAdmin(username, password);
		if(count > 0){
			 return true;
		}
		 return false;
	}
}
