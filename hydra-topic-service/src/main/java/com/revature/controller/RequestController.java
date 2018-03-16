package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.revature.model.Batch;


@RestController
@RequestMapping(value = "")
public class RequestController {
	@Autowired
	private static RestTemplate restTemplate;

	public static Batch findBatchById(int batchId) {
		System.out.println("Here");
		Batch batch = restTemplate.getForObject("http://localhost:21038/getBatchById/50" /*+ batchId*/, Batch.class);
		System.out.println(batch);
		return batch;
	}

}
