package com.sujeet.TMApplication.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujeet.TMApplication.exception.TouristNotFoundException;
import com.sujeet.TMApplication.model.Tourist;
import com.sujeet.TMApplication.service.ITouristManagement;

@RestController
@RequestMapping("/tc")
public class TouristController {
	@Autowired
	private ITouristManagement service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		try {
			String msg = service.registerTourist(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in Registering", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findall")
	public ResponseEntity<?> fetchAllTourist() {
		try {
			List<Tourist> list = service.fetchAllTourist();
			return new ResponseEntity<List>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<?> fetchTourist(@PathVariable("id") Integer id) {
		try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<>(tourist, HttpStatus.OK);
		} catch (TouristNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
