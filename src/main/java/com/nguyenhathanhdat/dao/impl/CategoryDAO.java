package com.nguyenhathanhdat.dao.impl;

import java.util.List;

import com.nguyenhathanhdat.dao.ICategoryDAO;
import com.nguyenhathanhdat.mapper.CategoryMapper;
import com.nguyenhathanhdat.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {


	@Override
	public CategoryModel findOne(long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
	}

	@Override
	public List<CategoryModel> fillAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}
