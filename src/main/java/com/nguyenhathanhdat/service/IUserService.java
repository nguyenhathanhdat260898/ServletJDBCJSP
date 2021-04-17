package com.nguyenhathanhdat.service;

import com.nguyenhathanhdat.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName,String password,Integer status);
}
