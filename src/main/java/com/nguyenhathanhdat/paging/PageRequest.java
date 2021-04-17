package com.nguyenhathanhdat.paging;

import com.nguyenhathanhdat.sort.Sorter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest implements Pageble {

	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;

	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getOffset() {
		Integer offset = (this.page - 1) * this.maxPageItem;
		if (this.page != null && this.maxPageItem != null) {
			return offset;
		} else {
			return null;
		}
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sorter getSorter() {
		if (this.sorter != null) {
			return this.sorter;
		}
		return null;
	}

}
