package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.revature.model.Batch;

@RestController
@RequestMapping(value = "")
public class RequestController {
	@Autowired
	private static RestTemplate restTemplate;

	/*public static Batch findBatchById(int batchId) {
		Batch batch = restTemplate.getForObject("http://batch-service/batch/" + batchId, Batch.class);
		return batch;
	}*/

}
