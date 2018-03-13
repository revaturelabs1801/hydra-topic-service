package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.revature.model.Batch;
import com.revature.model.TopicWeek;


 
@RepositoryRestResource
public interface TopicWeekRepository extends JpaRepository<TopicWeek, Integer> {
	List<TopicWeek> findByBatch(Batch batch);

	List<TopicWeek> findByBatchId(int batchId);
}