package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Batch;
import com.revature.model.TopicName;
import com.revature.model.TopicWeek;
import com.revature.services.TopicService;

@RestController
@RequestMapping("api/v2/topicService")
public class TopicServerController {
	@Autowired
	private TopicService topicService;

	//This should theoretically work, but not sure how to test
	@PostMapping("/{topicNameId}/{batch}/{weekNumber}")
	public void addTopic(@PathVariable int topicNameId, @PathVariable int batch, @PathVariable int weekNumber) {
		this.topicService.addTopic(topicNameId, batch, weekNumber);
	}

	//This should theoretically work, but not sure how to test
	@PostMapping("/getTopicByBatch/{batch}")
	public ResponseEntity<List<TopicWeek>> getTopicByBatch(@PathVariable Batch batch) {
		return new ResponseEntity<List<TopicWeek>>(this.topicService.getTopicByBatch(batch),HttpStatus.OK);
	}

	//This works
	@PostMapping("/getTopicByBatchId/{batchId}")
	public @ResponseBody ResponseEntity<List<TopicWeek>> getTopicByBatchId(@PathVariable int batchId) {
		List<TopicWeek> t=this.topicService.getTopicByBatchId(batchId);
		//System.out.println(t);
		return new ResponseEntity<List<TopicWeek>>(t,HttpStatus.OK);

	}

	//This works
	@GetMapping("/getTopics")
	public ResponseEntity<List<TopicName>> getTopics() {
		return new ResponseEntity<List<TopicName>>(this.topicService.getTopics(), HttpStatus.OK);
	}

	
	//This should theoretically work, but not sure how to test
	@PostMapping("/addOrUpdate/{topic}")
	public void addOrUpdateTopicName(@PathVariable TopicName topic) {
		this.topicService.addOrUpdateTopicName(topic);

	}
	
	//Working, changed to get mapping
	@GetMapping("/getTopicName/{id}")
	public ResponseEntity<TopicName> getTopicName(@PathVariable int id) {
		TopicName t=topicService.getTopicName(id);
		System.out.println(t);
		return new ResponseEntity<TopicName>(t,HttpStatus.OK);
	}

}
