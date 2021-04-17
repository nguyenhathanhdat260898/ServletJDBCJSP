package com.nguyenhathanhdat.dao;

import java.util.List;

import com.nguyenhathanhdat.model.NewModel;
import com.nguyenhathanhdat.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel updateNew);

	NewModel findOne(Long id);

	void delete(long id);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
