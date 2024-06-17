package com.sujeet.TMApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujeet.TMApplication.dao.ITouristRepo;
import com.sujeet.TMApplication.exception.TouristNotFoundException;
import com.sujeet.TMApplication.model.Tourist;

@Service
public class TouristManagementImpl implements ITouristManagement {

	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		Integer id = repo.save(tourist).getId();
		return "Tourist is Registered with Id:" + id;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list = repo.findAll();
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new TouristNotFoundException("Tourist Not Found"));
	}

}
