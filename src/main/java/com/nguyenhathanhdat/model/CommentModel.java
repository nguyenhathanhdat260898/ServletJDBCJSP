package com.nguyenhathanhdat.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentModel extends BaseModel<CommentModel> {
	private String content;
	private long user_id;
	private long new_id;

}
