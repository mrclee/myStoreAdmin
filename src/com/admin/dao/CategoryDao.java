package com.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.admin.domain.Category;
import com.admin.utils.JdbcUtil;

public class CategoryDao {

	public static List<Category> queryAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from T_category";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

}
