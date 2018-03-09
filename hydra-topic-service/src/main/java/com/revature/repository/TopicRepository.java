package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.bean.Subtopic;
import com.revature.bean.Topic;



@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	List<Topic> findAll();
	//List<Subtopic> findAll();
	
	

}
