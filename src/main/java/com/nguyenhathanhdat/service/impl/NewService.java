package com.nguyenhathanhdat.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.nguyenhathanhdat.dao.ICategoryDAO;
import com.nguyenhathanhdat.dao.INewDAO;
import com.nguyenhathanhdat.model.CategoryModel;
import com.nguyenhathanhdat.model.NewModel;
import com.nguyenhathanhdat.paging.Pageble;
import com.nguyenhathanhdat.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDao.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(Long id) {
		// TODO Auto-generated method stub
		return newDao.findOne(id);
	}

}
