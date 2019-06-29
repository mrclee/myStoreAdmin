package com.admin.dao;

import com.admin.domain.Admin;
import com.admin.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 数据操纵类
 * @author Administrator
 *
 */
public class AdminDao {

	public Admin getAdmin(String username, String password) throws SQLException {
		//获取数据源
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//sql
		String sql = "select * from T_admin where username = ? and password = ?";
		return qr.query(sql, new BeanHandler<Admin>(Admin.class),username,password);
	}
	
	
	public int insertAdmin(String username, String password) throws SQLException {
		//获取数据源
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//sql
		String sql = "insert into T_admin(username,password) values(?,?)";
		return qr.update(sql, username,password);
	}
}
