package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Batch;
import com.revature.model.TopicName;
import com.revature.model.TopicWeek;
import com.revature.repository.TopicNameRepository;
import com.revature.repository.TopicWeekRepository;



@Service
public class TopicService {

	  @Autowired
	  TopicWeekRepository topicWeekRepository;

	 /*@Autowired
	  BatchRepository batchRepistory;*/

	  @Autowired
	  TopicNameRepository topicNameRepository;

	  public void addTopic(int topicNameId, int batch, int weekNumber) {
	    TopicWeek topic = new TopicWeek();
	    Batch b;
	    TopicName topicName;

	    //b = batchRepistory.findById(batch);
	    topicName = topicNameRepository.findByid(topicNameId);

	    //topic.setBatch(b);
	    topic.setTopic(topicName);
	    topic.setWeekNumber(weekNumber);

	    topicWeekRepository.save(topic);
	  }

	  public List<TopicWeek> getTopicByBatch(Batch batch) {
	    return topicWeekRepository.findByBatch(batch);
	  }

	  /*public List<TopicWeek> getTopicByBatchId(int batchId) {
	    return topicWeekRepository.findByBatch(batchRepistory.findById(batchId));
	  }*/

	  public List<TopicName> getTopics() {
	    return topicNameRepository.findAll();
	  }

	  public void addOrUpdateTopicName(TopicName topic) {
	    topicNameRepository.save(topic);
	  }

	  public TopicName getTopicName(int id) {
	    return topicNameRepository.findByid(id);
	  }

	
}
