package com.nguyenhathanhdat.dao.impl;

import java.util.List;

import com.nguyenhathanhdat.dao.IUserDAO;
import com.nguyenhathanhdat.mapper.UserMapper;
import com.nguyenhathanhdat.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u  ");
		sql.append("INNER JOIN role AS r ON r.id=u.roleid ");
		sql.append("WHERE username = ? and password=? and status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName,password,status);
		return users.isEmpty() ? null : users.get(0);
	}

}
