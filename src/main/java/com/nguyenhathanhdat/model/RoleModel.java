package com.nguyenhathanhdat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleModel extends BaseModel<RoleModel> {
	private String name;
	private String code;
}
