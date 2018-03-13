package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.model.Batch;


@RepositoryRestResource
public interface BatchRepository extends JpaRepository<Batch, Integer> {
	public Batch findByid(Integer id);

}
