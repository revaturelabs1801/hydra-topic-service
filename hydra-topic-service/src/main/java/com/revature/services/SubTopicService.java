package com.revature.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.revature.model.Batch;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.model.SubtopicType;
import com.revature.repository.BatchRepository;
import com.revature.repository.SubtopicNameRepository;
import com.revature.repository.SubtopicRepository;
import com.revature.repository.SubtopicStatusRepository;
import com.revature.repository.SubtopicTypeRepository;

@Service
public class SubTopicService {
	
	@Autowired
	  SubtopicRepository subtopicRepository;

	  /*@Autowired
	  BatchRepository batchRepository;*/

	  @Autowired
	  SubtopicNameRepository subtopicNameRepository;

	  @Autowired
	  SubtopicStatusRepository subtopicStatusRepository;

	  @Autowired
	  SubtopicTypeRepository subtopicTypeRepository;

	  public void addSubtopic(int subtopic, int batch) /*throws CustomException*/ {
	    Subtopic s = new Subtopic();
	    Batch b;
	    SubtopicName st;
	    SubtopicStatus ss;
	    Date date = new Date();

	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	      date = dateFormat.parse("23/09/2017");
	    } catch (Exception e) {
	    	System.out.println("Error");
	      //LogManager.getRootLogger().error(e);
	    }
	    long time = date.getTime();
	    Timestamp ts = new Timestamp(time);

	    //Need to do batch stuff
	   // b = batchRepository.findByid(batch);
	    st = subtopicNameRepository.findByid(subtopic);
	    ss = subtopicStatusRepository.findByid(1);

	    
	    //Need to do batch stuff
	    //s.setBatch(b);
	    s.setSubtopicName(st);
	    s.setStatus(ss);
	    s.setSubtopicDate(ts);

	    subtopicRepository.save(s);
	  }

		public List<Subtopic> getSubtopicByBatch(Batch batch) {
			return subtopicRepository.findByBatch(batch);
		}

		/*public List<Subtopic> getSubtopicByBatchId(int batchId) {
			return subtopicRepository.findByBatch(batchRepository.findByid(batchId));
		}*/

	  /**
	   * 
	   * @param topic
	   *          Persisting subtopic to database.
	   *          To handle timezone offset, before submission to DB,
	   *          adding offset to date and updating date.
	   * 
	   * @author Samuel Louis-Pierre, Avant Mathur
	   */
	  public void updateSubtopic(Subtopic subtopic) {
	    Long newDate = subtopic.getSubtopicDate().getTime() + 46800000;
	    subtopic.setSubtopicDate(new Timestamp(newDate));

	    subtopicRepository.save(subtopic);
	  }

		public SubtopicStatus getStatus(String name) {
			return subtopicStatusRepository.findByName(name);
		}

	  /**
	   * Service method to return the number of Subtopics by matching their ids with
	   * the batchId.
	   * 
	   * @param batchId(int)
	   * @return number(long) of Subtopics
	   * 
	   * @author Michael Garza, Gary LaMountain
	   */
	  public Long getNumberOfSubtopics(int batchId) {
	    return subtopicRepository.countSubtopicsByBatchId(batchId);
	  }

	  public List<SubtopicName> getAllSubtopics() {
	    return subtopicNameRepository.findAll();
	  }

	  public List<Subtopic> getSubtopics() {
		 
	    return subtopicRepository.findAll();
	    
	  }

	  /**
	   * Service method to return the pages of json information to the FullCalendar
	   * API.
	   * This is hard coded until the FullCalendar API is set up for getting pages
	   * of
	   * json sub-topics.
	   * 
	   * @param batchId
	   * @param pageRequest
	   * @return
	   * 
	   *         Authors: Michael Garza
	   *         Gary LaMountain
	   */
	  /*public List<Subtopic> findByBatchId(int batchId, PageRequest pageRequest) {
	    return subtopicRepository.findByBatch(batchRepository.findByid(batchId), pageRequest);
	  }*/

	  /**
	   * 
	   * @param String
	   *          name
	   * @return SubtopicName
	   */
	  public SubtopicName getSubtopicName(String name) {
	    return subtopicNameRepository.findByName(name);
	  }

	  /**
	   * 
	   * @param int
	   *          type
	   * @return SubtopicType
	   */
	  public SubtopicType getSubtopicType(int type) {
	    return subtopicTypeRepository.findByid(type);
	  }

	  /**
	   * 
	   * @param SubtopicName
	   *          subtopicName
	   * @author Brian McKalip
	   */
	  public void addOrUpdateSubtopicName(SubtopicName subtopicName) {
	    subtopicNameRepository.save(subtopicName);
	  }

}
