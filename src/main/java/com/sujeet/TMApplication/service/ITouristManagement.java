package com.sujeet.TMApplication.service;

import java.util.List;

import com.sujeet.TMApplication.model.Tourist;

public interface ITouristManagement {
	public String registerTourist(Tourist tourist);

	public List<Tourist> fetchAllTourist();

	public Tourist fetchTouristById(Integer id);

	public String updateTouristInfo(Tourist tourist);

	public String updateTouristInfoById(Integer id, Double budget);

	public String deleteTouristById(Integer id);
}
