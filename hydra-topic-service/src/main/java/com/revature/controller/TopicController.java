package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.CustomException;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicType;
import com.revature.model.TopicName;
import com.revature.repository.SubtopicNameRepository;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;


@RestController
@RequestMapping("/api/v2/Topics/")
class TopicController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	SubTopicService subserv;

	@Autowired
	SubtopicNameRepository sr;
	
	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SubtopicName> getAllUsers() {
		return sr.findAll();
	}

	@PostMapping("/addSubtopic")
	public void addSubtopic(@RequestBody String jsonObj) throws CustomException {

		Subtopic st = null;
		try {
			st = new ObjectMapper().readValue(jsonObj, Subtopic.class);
		} catch (IOException e) {
			throw new CustomException(e);
		}

		subserv.updateSubtopic(st);
	}
	
	  @PostMapping("/Add")
	  public void addTopicName(HttpServletRequest request) {
		  System.out.println("i ghatee this");
	    TopicName topic = new TopicName();
	    topic.setName(request.getParameter("name"));
	    topicService.addOrUpdateTopicName(topic);
	  }
	  
	  @PostMapping("/addSubtopicName")
	  public void addSubTopicName(HttpServletRequest request) {
	    SubtopicType type = subserv.getSubtopicType(Integer.parseInt(request.getParameter("typeId")));
	    TopicName topic = topicService.getTopicName(Integer.parseInt(request.getParameter("topicId")));
	    SubtopicName subtopic = new SubtopicName(request.getParameter("subtopicName"), topic, type);
	    subserv.addOrUpdateSubtopicName(subtopic);
	  }
}