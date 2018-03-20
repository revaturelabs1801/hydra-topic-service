package com.revature.services.tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Batch;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.model.TopicName;
import com.revature.model.TopicWeek;
import com.revature.repository.TopicNameRepository;
import com.revature.repository.TopicWeekRepository;
import com.revature.services.TopicService;

public class TopicServiceTests {
	TopicWeekRepository mockTopicWeekRepository;
	TopicNameRepository mockTopicNameRepository;
	TopicService topicService;

	@Before
	public void before() {
		mockTopicWeekRepository = mock(TopicWeekRepository.class);
		mockTopicNameRepository = mock(TopicNameRepository.class);
		
		topicService = new TopicService(mockTopicWeekRepository, mockTopicNameRepository);
	}
	
	@Test
	public void addTopic_callsTopicWeekRepositorySave() {
		// Setup
		when(mockTopicNameRepository.findByid(1)).thenReturn(new TopicName());

		// Execute
		topicService.addTopic(1, 1, 1);

		// Test
		verify(mockTopicWeekRepository, times(1)).save(any(TopicWeek.class));
	}
	
	@Test
	public void getTopicByBatch_callsTopicWeekRepositoryFindByBatch() {
		// Setup
		Batch batch = new Batch();

		// Execute
		topicService.getTopicByBatch(batch);

		// Test
		verify(mockTopicWeekRepository, times(1)).findByBatch(batch);
	}
	
	@Test
	public void getTopics_callsTopicNameRepositoryFindAll() {
		// Setup
		Batch batch = new Batch();

		// Execute
		topicService.getTopics();

		// Test
		verify(mockTopicNameRepository, times(1)).findAll();
	}
	
	@Test
	public void addOrUpdateTopicName_callsTopicNameRepositorySave() {
		// Setup
		TopicName topic = new TopicName();

		// Execute
		topicService.addOrUpdateTopicName(topic);

		// Test
		verify(mockTopicNameRepository, times(1)).save(topic);
	}

	@Test
	public void getTopicName_callsTopicNameRepositoryFindById() {
		// Setup
		Integer argument = 1;

		// Execute
		topicService.getTopicName(argument);

		// Test
		verify(mockTopicNameRepository, times(1)).findByid(argument);
	}
}
