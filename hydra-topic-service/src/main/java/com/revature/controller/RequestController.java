package com.revature.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Batch;
import com.revature.repository.SubtopicRepository;

@RestController
@RequestMapping(value = "")
public class RequestController {
	@Autowired
	private RestTemplate restTemplate;

	@Resource
	private SubtopicRepository subtopicRepository;

	public Batch findBatchById(int batchId) {
		Batch batch = this.restTemplate.getForObject("http://batch-service/batch/" + batchId, Batch.class);
		return batch;
	}

}
