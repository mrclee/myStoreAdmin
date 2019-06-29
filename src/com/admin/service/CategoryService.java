package com.admin.service;

import com.admin.dao.CategoryDao;
import com.admin.domain.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {

	public List<Category> getAllCategory() throws SQLException {
		return CategoryDao.queryAllCategory();
	}

}
