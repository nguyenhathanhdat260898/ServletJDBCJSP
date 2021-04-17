package com.nguyenhathanhdat.dao;

import java.util.List;

import com.nguyenhathanhdat.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> fillAll();

	CategoryModel findOne(long id);

	CategoryModel findOneByCode(String code);
}
