package com.my.mdemo.web.util;

public class NavigationInfo {

	// current page -- 
	private int currentPage;

	// number of objects per page
	private int pageSize;

	// total number of rows meeting the query criteria
	private int rowCount;

	// number of index (navigation) links to be displayed
	private int maxDisplayedIndexes;

	public NavigationInfo() {

		currentPage = 1;

		rowCount = 0;

		maxDisplayedIndexes = 3;

		pageSize = 3;

	}

	public int getCurrentPage() {

		return currentPage;

	}

	public void setCurrentPage(int currentPage) {

		if (currentPage < 1)

			this.currentPage = 1;

		else if (currentPage > getPageCount())

			this.currentPage = getPageCount();

		else

			this.currentPage = currentPage;

	}

	public int getPageSize() {

		return pageSize;

	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;

	}

	public int getRowCount() {

		return rowCount;

	}

	public void setRowCount(int rowCount) {

		this.rowCount = rowCount;

	}

	public int getmaxDisplayedIndexes() {

		return maxDisplayedIndexes;

	}

	public void setmaxDisplayedIndexes(int maxDisplayedIndexes) {

		this.maxDisplayedIndexes = maxDisplayedIndexes;

	}

	public int getPageCount() {

		// if rowCount = 10 and each page should contain 3 object
		// Then pageCount = 4. 10/3 = 3.33, but the ceiling is 4 
		return (int) Math.ceil((double) rowCount / pageSize);

	}

	public int getPrevIndex() {

		int prev = currentPage - 1;

		return prev < 1 ? 1 : prev;

	}

	public int getNextIndex() {

		int lastIndex = getPageCount();

		int next = currentPage + 1;

		return next > lastIndex ? lastIndex : next;

	}

	public boolean isFirstPage() {

		return 1 == currentPage;

	}

	public boolean isLastPage() {

		return getPageCount() == currentPage;

	}

	public int[] getIndexList() {

		int[] range = getIndexRange();

		int[] ilist = new int[range[1] - range[0] + 1];

		for (int i = 0; i < ilist.length; i++) {

			ilist[i] = range[0] + i;

		}

		return ilist;

	}

	public int[] getIndexRange() {

		int end = currentPage + maxDisplayedIndexes -1;
		if( end > getPageCount())
			end = getPageCount();
		
		int start = currentPage - maxDisplayedIndexes;
		if(start < 1)
			start = 1;
	
		return new int[] {start, end};
	}
}
