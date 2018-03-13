package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

@RestController
@RequestMapping(value = "/api/v2/SubtopicResponse")
public class SubtopicResponseController {
	
	@Autowired
	TopicService topicService;

	@Autowired
	SubTopicService subTopicService;


}
