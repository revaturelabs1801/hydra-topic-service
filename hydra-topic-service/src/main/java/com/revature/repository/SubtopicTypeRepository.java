package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.revature.model.SubtopicType;


@RepositoryRestResource
public interface SubtopicTypeRepository extends JpaRepository<SubtopicType, Integer> {
	public SubtopicType findByid(Integer type);
}
