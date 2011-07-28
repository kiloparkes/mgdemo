package com.my.mdemo.web.util;

import java.util.List;

import com.my.mdemo.model.*;

public class PagedView {

	private NavigationInfo navInfo = new NavigationInfo();

	private List<Tone> tones;

	public NavigationInfo getNavInfo() {

		return navInfo;

	}

	public void setNavInfo(NavigationInfo navInfo) {
		this.navInfo = navInfo;

	}

	public List<Tone> getTones() {

		return tones;

	}

	public void setTones(List<Tone> Tones) {

		this.tones = Tones;

	}

	public Tone getTone(int i) {

		return (Tone) tones.get(i);

	}

	public void setTone(int i, Tone Tone) {

		this.tones.add(i, Tone);

	}

}
