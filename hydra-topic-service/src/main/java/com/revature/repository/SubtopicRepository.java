package com.revature.repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;


@RepositoryRestResource
public interface SubtopicRepository extends JpaRepository<Subtopic, Integer>{

	/**
	 * Counts the number of subtopics in the database by matching it with the
	 * batchid.
	 * 
	 * 
	 * @param batchId
	 * @return number of Subtopics
	 * 
	 * 
	 */
	Long countSubtopicsByBatchid(int batchId);
	/**
	 * Finds one subtopic in the batch
	 * @param batchId
	 * @return
	 */
	List<Subtopic> findTop1ByBatchid(int batchId);

	List<Subtopic> findByBatchid(int batchId);
	List<Subtopic> findByBatchid(int batchId, Pageable page);
	void deleteByBatchid(int batchId);
	List<Subtopic> findSubtopicByStatus(SubtopicStatus status);
	SubtopicName findSubtopicBySubtopicName(SubtopicName name);


}