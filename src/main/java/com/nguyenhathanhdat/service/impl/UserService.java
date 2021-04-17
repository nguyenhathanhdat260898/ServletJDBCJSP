package com.nguyenhathanhdat.service.impl;

import javax.inject.Inject;

import com.nguyenhathanhdat.dao.IUserDAO;
import com.nguyenhathanhdat.model.UserModel;
import com.nguyenhathanhdat.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
