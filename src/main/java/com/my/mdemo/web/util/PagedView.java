package com.my.mdemo.web.util;

import java.util.List;

import com.my.mdemo.model.*;

public class PagedView<E> {

	private NavigationInfo navInfo = new NavigationInfo();

	private List<E> tones;

	public NavigationInfo getNavInfo() {

		return navInfo;

	}

	public void setNavInfo(NavigationInfo navInfo) {
		this.navInfo = navInfo;

	}

	public List<E> getTones() {

		return tones;

	}

	public void setTones(List<E> Tones) {

		this.tones = Tones;

	}

	public Tone getTone(int i) {

		return (Tone) tones.get(i);

	}

	public void setTone(int i, E Tone) {

		this.tones.add(i, Tone);

	}

}
