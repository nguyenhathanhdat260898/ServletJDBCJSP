package com.nguyenhathanhdat.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewModel extends BaseModel<NewModel> {

	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content; 
	private long categoryId;
	private String categoryCode;
}
