package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.TopicName;


 
@Repository
public interface TopicNameRepository extends JpaRepository<TopicName, Integer> {
	public TopicName findByid(Integer id);
}