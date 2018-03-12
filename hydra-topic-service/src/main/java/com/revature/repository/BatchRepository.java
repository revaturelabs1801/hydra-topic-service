package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Batch;



public interface BatchRepository extends JpaRepository<Batch, Integer> {
	public Batch findByid(Integer id);

}
