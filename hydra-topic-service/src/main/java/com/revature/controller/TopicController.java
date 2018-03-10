package com.revature.controller;

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
	  
		@GetMapping("/getFc2")
		public TopicName getFc(){
			System.out.println("hit /getFc2");
			TopicName t=new TopicName("Test");
			
			//FlashCard fc = restTemplate.getForObject("http://flashcard-service-2/fc2", FlashCard.class);
			return t;
		}
		


}
