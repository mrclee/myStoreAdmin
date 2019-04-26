package com.admin.test;

import java.sql.SQLException;

import org.junit.Test;

import com.admin.dao.CategoryDao;

public class CategoryDaoTest {
	
	@Test
	public void testQuery() throws SQLException{
		System.out.println(CategoryDao.queryAllCategory());
	}
}
