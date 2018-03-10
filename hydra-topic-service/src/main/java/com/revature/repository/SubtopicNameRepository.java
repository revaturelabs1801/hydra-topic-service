package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.SubtopicName;

@Repository
public interface SubtopicNameRepository extends JpaRepository<SubtopicName, Integer> {
	public SubtopicName findByid(Integer id);
	public SubtopicName findByName(String name);
	public List<SubtopicName> findAll();
}