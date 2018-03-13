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

	@PostMapping("/{topicNameId}/{batch}/{weekNumber}")
	public void addTopic(@PathVariable int topicNameId, @PathVariable int batch, @PathVariable int weekNumber) {
		this.topicService.addTopic(topicNameId, batch, weekNumber);
	}

	@PostMapping("/getTopicByBatch/{batch}")
	public ResponseEntity<List<TopicWeek>> getTopicByBatch(@PathVariable Batch batch) {
		return new ResponseEntity<List<TopicWeek>>(this.topicService.getTopicByBatch(batch),HttpStatus.OK);
	}

	@PostMapping("/getTopicByBatchId/{batchId}")
	public ResponseEntity<List<TopicWeek>> getTopicByBatchId(@PathVariable int batchId) {
		return new ResponseEntity<List<TopicWeek>>(this.topicService.getTopicByBatchId(batchId), HttpStatus.OK);

	}

	@GetMapping("/getTopics")
	public ResponseEntity<List<TopicName>> getTopics() {
		return new ResponseEntity<List<TopicName>>(this.topicService.getTopics(), HttpStatus.OK);
	}

	@PostMapping("/addOrUpdate/{topic}")
	public void addOrUpdateTopicName(@PathVariable TopicName topic) {
		this.topicService.addOrUpdateTopicName(topic);

	}

	@RequestMapping(path = "/getTopicName/id", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TopicName> getTopicName(@RequestBody int id) {
		return new ResponseEntity<TopicName>(topicService.getTopicName(id),HttpStatus.OK);
	}

}
