package com.revature.services.tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Batch;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.repository.SubtopicNameRepository;
import com.revature.repository.SubtopicRepository;
import com.revature.repository.SubtopicStatusRepository;
import com.revature.repository.SubtopicTypeRepository;
import com.revature.services.SubTopicService;

public class SubTopicServiceTests {
	private SubTopicService subTopicService;

	private SubtopicRepository mockSubtopicRepository;
	private SubtopicNameRepository mockSubtopicNameRepository;
	private SubtopicStatusRepository mockSubtopicStatusRepository;
	private SubtopicTypeRepository mockSubtopicTypeRepository;

	@Before
	public void before() {
		mockSubtopicRepository = mock(SubtopicRepository.class);
		mockSubtopicNameRepository = mock(SubtopicNameRepository.class);
		mockSubtopicStatusRepository = mock(SubtopicStatusRepository.class);
		mockSubtopicTypeRepository = mock(SubtopicTypeRepository.class);

		subTopicService = new SubTopicService(mockSubtopicRepository, mockSubtopicNameRepository,
				mockSubtopicStatusRepository, mockSubtopicTypeRepository);
	}

	@Test
	public void addSubtopic_callsSubTopicRepositorySave() {
		// Setup
		when(mockSubtopicNameRepository.findByid(1)).thenReturn(new SubtopicName());
		when(mockSubtopicStatusRepository.findByid(1)).thenReturn(new SubtopicStatus());

		// Execute
		subTopicService.addSubtopic(1, 1);

		// Test
		verify(mockSubtopicRepository, times(1)).save(any(Subtopic.class));
	}

	@Test
	public void getSubtopicByBatch_callsSubTopicRepositoryFindByBatch() {
		// Setup
		Batch batch = new Batch();

		// Execute
		subTopicService.getSubtopicByBatch(batch);

		verify(mockSubtopicRepository, times(1)).findByBatch(batch);
	}

	@Test
	public void updateSubtopic_callsSubTopicRepositorySave() {
		// Setup
		Subtopic subtopic = new Subtopic();
		subtopic.setSubtopicDate(new Timestamp(1234));

		// Execute
		subTopicService.updateSubtopic(subtopic);

		verify(mockSubtopicRepository, times(1)).save(any(Subtopic.class));
	}

	@Test
	public void getStatus_callsSubTopicStatusRepositoryFindByName() {
		// Setup
		String string = "test";

		// Execute
		subTopicService.getStatus(string);

		verify(mockSubtopicStatusRepository, times(1)).findByName(any(String.class));
	}

	@Test
	public void getNumberOfSubtopics_callsSubTopicRepositoryCountSubtopicsByBatchId() {
		// Setup
		int integer = 3;

		// Execute
		subTopicService.getNumberOfSubtopics(integer);

		verify(mockSubtopicRepository, times(1)).countSubtopicsByBatchId(3);
	}

	@Test
	public void getAllSubtopics_callsSubTopicNameRepositoryFindAll() {
		// Execute
		subTopicService.getAllSubtopics();

		verify(mockSubtopicNameRepository, times(1)).findAll();
	}

	@Test
	public void getSubtopics_callsSubTopicRepositoryFindAll() {
		// Execute
		subTopicService.getSubtopics();

		verify(mockSubtopicRepository, times(1)).findAll();
	}

	@Test
	public void getSubtopicName_callsSubTopicNameRepositoryFindByName() {
		// Setup
		String string = "test";

		// Execute
		subTopicService.getSubtopicName(string);

		verify(mockSubtopicNameRepository, times(1)).findByName("test");
	}

	@Test
	public void getSubtopicType_callsSubTopicTypeRepositoryFindById() {
		// Setup
		int type = 3;

		// Execute
		subTopicService.getSubtopicType(type);

		verify(mockSubtopicTypeRepository, times(1)).findByid(type);
	}

	@Test
	public void addOrUpdateSubtopicName_callsSubTopicNameRepositorySave() {
		// Setup
		SubtopicName name = new SubtopicName();

		// Execute
		subTopicService.addOrUpdateSubtopicName(name);

		verify(mockSubtopicNameRepository, times(1)).save(name);
	}
}
