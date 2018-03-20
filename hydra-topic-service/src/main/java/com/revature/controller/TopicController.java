
/*package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.TopicName;
import com.revature.services.TopicService;


@RestController
//@RequestMapping(value = "/api/v2/Topic/")
public class TopicController {


		/*
		 * Dummy rest call
		 *//*
		@GetMapping("/")
		public TopicName home(){
			System.out.println("Getting here");
			return new TopicName("New Topic");
		}
		
		
		  @Autowired
		  TopicService topicService;
		
	  @RequestMapping(value = "Add", method = RequestMethod.POST)
	  public void addTopicName(HttpServletRequest request) {
	    TopicName topic = new TopicName();
	    topic.setName(request.getParameter("name"));
	    topicService.addOrUpdateTopicName(topic);
	  }
	  
		/*
		 * Dummy rest call
		 *//*
		@GetMapping("/getFc2")
		public TopicName getFc(){
			System.out.println("hit /getFc2");
			TopicName t=new TopicName("Test");
			
			//FlashCard fc = restTemplate.getForObject("http://flashcard-service-2/fc2", FlashCard.class);
			return t;
		}
		


}*/

package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	SubTopicService subserv;

	@Autowired
	SubtopicNameRepository sr;
	
	public TopicController() {
		super();
	}

	public TopicController(TopicService topicService, SubTopicService subserv, SubtopicNameRepository sr) {
		super();
		this.topicService = topicService;
		this.subserv = subserv;
		this.sr = sr;
	}

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
}
