package com.nguyenhathanhdat.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nguyenhathanhdat.model.RoleModel;
import com.nguyenhathanhdat.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel users = new UserModel();
			users.setId(resultSet.getLong("id"));
			users.setUserName(resultSet.getString("userName"));
			users.setPassword(resultSet.getString("password"));
			users.setFullName(resultSet.getString("fullName"));
			users.setStatus(resultSet.getInt("status"));
			users.setFullName(resultSet.getString("roleId"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			users.setCreatedDate(resultSet.getTimestamp("createddate"));
			users.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				users.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				users.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return users;
		} catch (SQLException e) {
			return null;
		}
	}

}
