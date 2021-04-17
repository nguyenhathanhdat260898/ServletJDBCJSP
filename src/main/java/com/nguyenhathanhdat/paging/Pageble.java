package com.nguyenhathanhdat.paging;

import com.nguyenhathanhdat.sort.Sorter;

public interface Pageble {

	Integer getPage();

	Integer getOffset();

	Integer getLimit();

	Sorter getSorter();
}
