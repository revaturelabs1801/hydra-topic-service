package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.exceptions.CustomException;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicType;
import com.revature.model.TopicName;
import com.revature.repository.SubtopicNameRepository;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;


@RestController
@RequestMapping("/api/v2/Topics/")
@CrossOrigin
class TopicController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	SubTopicService subserv;

	@Autowired
	SubtopicNameRepository sr;
	
	@GetMapping("/")
	public TopicName home(){
		System.out.println("Getting here");
		return new TopicName("New Topic");
	}
	
	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SubtopicName> getAllUsers() {
		System.out.println("Getting All");
		System.out.println(sr.findAll());
		return sr.findAll();
	}

	@PostMapping("/addSubtopic")
	public void addSubtopic(@RequestBody String jsonObj) /*throws CustomException*/ {

		Subtopic st = null;
		try {
			st = new ObjectMapper().readValue(jsonObj, Subtopic.class);
		} catch (IOException e) {
			System.out.println("Error");
			//throw new CustomException(e);
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
	  
	  /**
	   * @author Cristian Hermida, Charlie Harris / Batch 1712-dec10-java-steve
	   * @param request
	   * 			- I request must have to have the name of the topic.
	   * @return The added topic (if any) as a TopicName and HttpStatus
	   * 			- status of 201 CREATED if a Topic is created or updated.
	   * 			- status of 204 NO_CONTENT is a Topic is not created.
	   */
	  @PostMapping("add/{newTopicName}")
	  public ResponseEntity<TopicName> addTopicName(@PathVariable String newTopicName) {
	    TopicName topic = new TopicName();
	    topic.setName(newTopicName);
	    TopicName topicUpdate = topicService.addOrUpdateTopicName(topic);
	    if(topicUpdate != null) {
	    	return new ResponseEntity<TopicName>(topicUpdate, HttpStatus.CREATED);
	    }
	    else {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	  }
}
