package com.my.mdemo.web.util;

public class NavigationInfo {

	private int currentPage;

	private int pageSize;

	private int rowCount;

	private int maxIndices;

	public NavigationInfo() {

		currentPage = 0;

		rowCount = 0;

		maxIndices = 5;

		pageSize = 3;

	}

	public int getCurrentPage() {

		return currentPage;

	}

	public void setCurrentPage(int currentPage) {

		if (currentPage < 0)

			this.currentPage = 0;

		else if (currentPage > getPageCount() - 1)

			this.currentPage = getPageCount() - 1;

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

	public int getMaxIndices() {

		return maxIndices;

	}

	public void setMaxIndices(int maxIndices) {

		this.maxIndices = maxIndices;

	}

	public int getPageCount() {

		return (int) Math.ceil((double) rowCount / pageSize);

	}

	public int getPrevIndex() {

		int prev = currentPage - 1;

		return prev < 0 ? 0 : prev;

	}

	public int getNextIndex() {

		int lastIndex = getPageCount() - 1;

		int next = currentPage + 1;

		return next > lastIndex ? lastIndex : next;

	}

	public boolean isFirstPage() {

		return 0 == currentPage;

	}

	public boolean isLastPage() {

		return (getPageCount() - 1) == currentPage;

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

		// determine the standard window

		int start = currentPage - maxIndices / 2;

		int end = start + maxIndices - 1;

		// shift to right if start underflows 0

		if (start < 0) {

			end -= start; // end – -start = end + start = shift right

			start = 0;

		}

		// now maybe the window overflows pageCount – so shift to left again

		int lastIndex = getPageCount() - 1;

		if (end > (lastIndex)) {

			start -= (end - lastIndex);

			end = lastIndex;

		}

		// we have finalized end, now if start < 0 then truncate it

		if (start < 0)
			start = 0;
		return new int[] {start, end};
	}
}
