package com.sujeet.TMApplication.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public String updateTouristInfo(Tourist tourist) {
		Integer id = tourist.getId();
		Optional<Tourist> tour = repo.findById(id);
		if (tour.isPresent()) {
			repo.save(tourist);
			return "tourist with id: " + id + " updated";
		} else {
			throw new TouristNotFoundException("Tourist not found");
		}
	}

	@Override
	public String updateTouristInfoById(Integer id, Double budget) {
		Optional<Tourist> tour = repo.findById(id);
		if (tour.isPresent()) {
			Tourist tourist = tour.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "tourist budget with id: " + id + " updated";
		} else {
			throw new TouristNotFoundException("Tourist not found");
		}
	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> tour = repo.findById(id);
		if (tour.isPresent()) {
			repo.deleteById(id);
			return "tourist with id: " + id + " deleted";
		} else {
			throw new TouristNotFoundException("Tourist not found");
		}
	}

}
