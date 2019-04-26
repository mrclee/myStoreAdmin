package com.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.admin.dao.CategoryDao;
import com.admin.domain.Category;

public class CategoryService {

	public List<Category> getAllCategory() throws SQLException {
		return CategoryDao.queryAllCategory();
	}

}
