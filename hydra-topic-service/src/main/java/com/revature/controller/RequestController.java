package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Batch;


@RestController

@RequestMapping("api/v2/batchtopic")

public class RequestController {

	@Autowired

	private static RestTemplate restTemplate;



	@PostMapping("/getBatch/{batchId}")
	public static Batch findBatchById(@PathVariable int batchId) {
		Batch b=restTemplate.getForObject("http://HYDRA-BATCH-SERVICE/api/v2/Batch/byid/50" /*+ batchId*/, Batch.class);
		System.out.println(b);
		return b;

	}
	
}
