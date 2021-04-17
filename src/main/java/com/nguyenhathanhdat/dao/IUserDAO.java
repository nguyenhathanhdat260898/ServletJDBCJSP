package com.nguyenhathanhdat.dao;

import com.nguyenhathanhdat.model.UserModel;
public interface IUserDAO extends GenericDAO<UserModel> {
	
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
