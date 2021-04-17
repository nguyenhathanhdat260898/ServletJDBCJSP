package com.nguyenhathanhdat.sort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sorter {

	private String sortName;
	private String sortBy;

	public Sorter(String sortName, String sortBy) {
		this.sortName = sortName;
		this.sortBy = sortBy;
	}
}
