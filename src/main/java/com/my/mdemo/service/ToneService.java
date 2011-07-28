package com.my.mdemo.service;

import java.util.List;

import com.my.mdemo.dao.ToneDao;
import com.my.mdemo.model.Tone;

public class ToneService {

	private ToneDao toneDao;

	public void setToneDao(ToneDao toneDao) {
		this.toneDao = toneDao;
	}
	
	public List<Tone> getTonesOfCategory(int catId, int maxResults, int startRow) {
		return toneDao.getTonesOfCategory(catId, maxResults, startRow);
	}
	
	public Integer getTonesOfCategoryCount(int catId) {
		return toneDao.getTonesOfCategoryCount(catId);
	}
}
