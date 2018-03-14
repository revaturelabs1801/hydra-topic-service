package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.controller.RequestController;
import com.revature.model.TopicName;
import com.revature.model.TopicWeek;
import com.revature.repository.TopicNameRepository;
import com.revature.repository.TopicWeekRepository;

@Service
public class TopicService {

	@Autowired
	TopicWeekRepository topicWeekRepository;


	@Autowired
	TopicNameRepository topicNameRepository;

	public void addTopic(int topicNameId, int batch, int weekNumber) {
		TopicWeek topic = new TopicWeek();
		TopicName topicName;

		topicName = topicNameRepository.findByid(topicNameId);

		topic.setBatch(batch);
		topic.setTopic(topicName);
		topic.setWeekNumber(weekNumber);

		topicWeekRepository.save(topic);
	}


	public List<TopicWeek> getTopicByBatchId(int batchId) {
		return topicWeekRepository.findByBatchid(batchId);
	}

	public List<TopicName> getTopics() {
		return topicNameRepository.findAll();
	}


	public TopicName addOrUpdateTopicName(TopicName topic) {
		return topicNameRepository.save(topic);
	}


	public TopicName getTopicName(int id) {
		return topicNameRepository.findByid(id);
	}

}
