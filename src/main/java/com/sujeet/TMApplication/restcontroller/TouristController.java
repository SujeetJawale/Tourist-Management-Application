package com.sujeet.TMApplication.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujeet.TMApplication.model.Tourist;
import com.sujeet.TMApplication.service.ITouristManagement;

@RestController
@RequestMapping("/tc")
public class TouristController {
	@Autowired
	private ITouristManagement service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		String msg = service.registerTourist(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@GetMapping("/findall")
	public ResponseEntity<?> fetchAllTourist() {
		List<Tourist> list = service.fetchAllTourist();
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<?> fetchTourist(@PathVariable("id") Integer id) {
		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<>(tourist, HttpStatus.OK);
	}

	@PutMapping("/updatetourist")
	public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist) {
		String msg = service.updateTouristInfo(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

//	whenever you want ro upadate very minimal info only 1 collumn then go with patch
	@PatchMapping("/updatebudget/{id}/{budget}")
	public ResponseEntity<String> updateTouristInfo(@PathVariable("id") Integer id,
			@PathVariable("budget") Double budget) {
		String msg = service.updateTouristInfoById(id, budget);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/deletetourist/{id}")
	public ResponseEntity<String> updateTouristInfo(@PathVariable("id") Integer id) {
		String msg = service.deleteTouristById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
