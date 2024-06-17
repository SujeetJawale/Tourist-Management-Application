package com.sujeet.TMApplication.service;

import java.util.List;

import com.sujeet.TMApplication.model.Tourist;

public interface ITouristManagement {
	public String registerTourist(Tourist tourist);

	public List<Tourist> fetchAllTourist();

	public Tourist fetchTouristById(Integer id);
}
