package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Batch;
import com.revature.model.TopicWeek;


 
@Repository
public interface TopicWeekRepository extends JpaRepository<TopicWeek, Integer> {
	List<TopicWeek> findByBatch(Batch batch);
}