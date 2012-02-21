package com.my.mdemo.web.util;

import java.util.List;

import com.my.mdemo.model.*;

public class PagedView<E> {

	private NavigationInfo navInfo = new NavigationInfo();

	private List<E> items;

	public NavigationInfo getNavInfo() {

		return navInfo;

	}

	public void setNavInfo(NavigationInfo navInfo) {
		this.navInfo = navInfo;

	}

	public List<E> getItems() {

		return items;

	}

	public void setItems(List<E> items) {

		this.items = items;

	}

	public Item getItem(int i) {

		return (Item) items.get(i);

	}

	public void setItem(int i, E Item) {

		this.items.add(i, Item);

	}

}
