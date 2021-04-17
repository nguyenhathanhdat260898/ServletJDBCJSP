package com.nguyenhathanhdat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel extends BaseModel<UserModel> {

	private String userName;
	private String password;
	private String fullName;
	private int status;
	private long roleId;
	private RoleModel role = new RoleModel();

}
