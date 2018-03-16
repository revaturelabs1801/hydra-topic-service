package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.model.TopicName;
import com.revature.model.TopicWeek;
import com.revature.services.TopicService;

@RestController
@RequestMapping("api/v2/topicService")
public class TopicServerController {
	@Autowired
	private TopicService topicService;

	//This should theoretically work, but not sure how to test
	//Ask Matt about return type
	@PostMapping("/{topicNameId}/{batch}/{weekNumber}")
	public void addTopic(@PathVariable int topicNameId, @PathVariable int batch, @PathVariable int weekNumber) {
		this.topicService.addTopic(topicNameId, batch, weekNumber);
	}

	//need to work on this
	/*@PostMapping("/getTopicByBatch/{batch}")
	public <List<TopicWeek>> getTopicByBatch(@PathVariable Batch batch) {
		return new <List<TopicWeek>>(this.topicService.getTopicByBatch(batch),HttpStatus.OK);
	}*/

	//This works
	@PostMapping("/getTopicByBatchId/{batchId}")
	public List<TopicWeek> getTopicByBatchId(@PathVariable int batchId) {
		return this.topicService.getTopicByBatchId(batchId);

	}

	//This works
	@GetMapping("/getTopics")
	public List<TopicName> getTopics() {
		return this.topicService.getTopics();
	}

	
	//This should theoretically work, but not sure how to test
	//Ask Matt/Sal about return type
	@PostMapping("/addOrUpdate/{topic}")
	public void addOrUpdateTopicName(@PathVariable TopicName topic) {
		this.topicService.addOrUpdateTopicName(topic);

	}
	
	//Working, changed to get mapping
	@GetMapping("/getTopicName/{id}")
	public TopicName getTopicName(@PathVariable int id) {
		return topicService.getTopicName(id);
	}

}
