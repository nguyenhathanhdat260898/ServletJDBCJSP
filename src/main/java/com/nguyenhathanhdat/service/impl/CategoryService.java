package com.nguyenhathanhdat.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.nguyenhathanhdat.dao.ICategoryDAO;
import com.nguyenhathanhdat.model.CategoryModel;
import com.nguyenhathanhdat.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO iCategoryDAO;

	@Override
	public List<CategoryModel> fillAll() {
		// TODO Auto-generated method stub
		return iCategoryDAO.fillAll();
	}

}
