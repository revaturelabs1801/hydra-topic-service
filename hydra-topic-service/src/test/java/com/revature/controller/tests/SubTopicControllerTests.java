package com.revature.controller.tests;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import com.revature.controller.SubTopicController;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

public class SubTopicControllerTests {

	TopicService mockTopicService;
	SubTopicService mockSubTopicService;
	
	SubTopicController subTopicController;
	
	@Before
	public void before() {
		mockTopicService = mock(TopicService.class);
		mockSubTopicService = mock(SubTopicService.class);
		
		subTopicController = new SubTopicController(mockTopicService, mockSubTopicService);
	}
	
	
}
