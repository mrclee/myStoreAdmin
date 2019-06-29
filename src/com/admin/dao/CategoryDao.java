package com.admin.dao;

import com.admin.domain.Category;
import com.admin.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {

	public static List<Category> queryAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from t_category";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

}
