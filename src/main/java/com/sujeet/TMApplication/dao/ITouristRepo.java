package com.sujeet.TMApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujeet.TMApplication.model.Tourist;

@Repository
public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
