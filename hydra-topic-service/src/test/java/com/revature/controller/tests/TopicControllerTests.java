package com.revature.controller.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.TopicController;
import com.revature.exception.CustomException;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicType;
import com.revature.model.TopicName;
import com.revature.repository.SubtopicNameRepository;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;


public class TopicControllerTests {
	
	TopicController topicController;

	TopicService mockTopicService;
	SubTopicService mockSubTopicService;
	SubtopicNameRepository mockSubTopicNameRepository;
	HttpServletRequest mockRequest;

	@Before
	public void before() {
		mockTopicService = mock(TopicService.class);
		mockSubTopicService = mock(SubTopicService.class);
		mockSubTopicNameRepository = mock(SubtopicNameRepository.class);
		mockRequest = mock(HttpServletRequest.class);
		
		topicController = new TopicController(mockTopicService, mockSubTopicService, mockSubTopicNameRepository);
	}

//	@Test
//	public void home_returnsNewTopicAsTopicName() {
//		// Setup
//		TopicName topicName;
//
//		// Execute
//		topicName = topicController.home();
//
//		// Test
//		assertEquals(topicName.getName(), "New Topic");
//	}
	

	@Test
	public void getAllUsers_returnsSubTopicRepositoryFindAll() {
		// Setup
		List<SubtopicName> list = new ArrayList<SubtopicName>();
		when(mockSubTopicNameRepository.findAll()).thenReturn(list);
		
		// Execute
		List<SubtopicName> returnList = topicController.getAllUsers();

		// Test
		assertEquals(returnList, list);
	}

	@Test
	public void addSubtopic_callsUpdateSubtopic() throws JsonProcessingException, CustomException {
		// Setup
		Subtopic argumentObj = new Subtopic(1, null, 1, null, null);
		String argumentJson = new ObjectMapper().writeValueAsString(argumentObj);
		List<SubtopicName> list = new ArrayList<SubtopicName>();
		
		when(mockSubTopicNameRepository.findAll()).thenReturn(list);
		
		// Execute
		topicController.addSubtopic(argumentJson);

		// Test
		verify(mockSubTopicService, times(1)).updateSubtopic(any(Subtopic.class));
	}
	
	@Test
	public void addTopicName_callsTopicServiceAddOrUpdateTopicName(){
		// Setup
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<SubtopicName> list = new ArrayList<SubtopicName>();
		
		when(mockSubTopicNameRepository.findAll()).thenReturn(list);
		when(mockRequest.getParameter("name")).thenReturn("Fred");
		
		// Execute
		topicController.addTopicName(request);

		// Test
		verify(mockTopicService, times(1)).addOrUpdateTopicName(any(TopicName.class));
	}

	@Test
	public void addSubTopicName_callsSubTopicRepositoryAddOrUpdateSubtopicName(){
		// Setup
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<SubtopicName> list = new ArrayList<SubtopicName>();
		
		when(mockSubTopicNameRepository.findAll()).thenReturn(list);
		when(mockRequest.getParameter("typeId")).thenReturn("1");
		when(mockSubTopicService.getSubtopicType(1)).thenReturn(new SubtopicType());
		when(mockRequest.getParameter("topicId")).thenReturn("1");
		when(mockTopicService.getTopicName(1)).thenReturn(new TopicName());
		when(mockRequest.getParameter("subtopicName")).thenReturn("SubtopicName");
		
		// Execute
		topicController.addSubTopicName(request);

		// Test
		verify(mockSubTopicService, times(1)).addOrUpdateSubtopicName(any(SubtopicName.class));
	}
}