package com.my.mdemo.dao;

import java.util.List;

import com.my.mdemo.model.Tone;

public interface ToneDao {

	List<Tone> getTonesOfCategory(int catId, final int fetchSize, final int startPos);
	int getTonesOfCategoryCount(int catId);
	
}
