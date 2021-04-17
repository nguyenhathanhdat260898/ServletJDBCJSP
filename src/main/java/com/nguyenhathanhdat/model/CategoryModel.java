package com.nguyenhathanhdat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryModel extends BaseModel<CategoryModel> {
 
	private String name;
	private String code;
}
