package com.revature.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.exception.CustomException;
import com.revature.model.CurriculumSubtopic;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.model.SubtopicType;
import com.revature.repository.SubtopicNameRepository;
import com.revature.repository.SubtopicRepository;
import com.revature.repository.SubtopicStatusRepository;
import com.revature.repository.SubtopicTypeRepository;

@Service
public class SubTopicService {
	
		@LoadBalanced
		@Bean
		public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder){
			return restTemplateBuilder.build();
		} 
	
		@Autowired
		private RestTemplate restTemplate;
	
	  @Autowired
	  SubtopicRepository subtopicRepository;

	  @Autowired
	  SubtopicNameRepository subtopicNameRepository;

	  @Autowired
	  SubtopicStatusRepository subtopicStatusRepository;

	  @Autowired
	  SubtopicTypeRepository subtopicTypeRepository;

	  public void addSubtopic(int subtopic, int batch) throws CustomException {
	    Subtopic s = new Subtopic();
	    SubtopicName st;
	    SubtopicStatus ss;
	    Date date = new Date();

	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	      date = dateFormat.parse("23/09/2017");
	    } catch (Exception e) {
	    	System.out.println("Error");
	      LogManager.getRootLogger().error(e);
	    }
	    long time = date.getTime();
	    Timestamp ts = new Timestamp(time);

	    //Need to do batch stuff
	   // b = batchRepository.findByid(batch);
	    st = subtopicNameRepository.findByid(subtopic);
	    ss = subtopicStatusRepository.findByid(1);

	    
	    //Need to do batch stuff
	    s.setBatch(batch);
	    s.setSubtopicName(st);
	    s.setStatus(ss);
	    s.setSubtopicDate(ts);

	    subtopicRepository.save(s);
	  }

		public List<Subtopic> getSubtopicByBatchId(int batchId) {
			return subtopicRepository.findByBatchid(batchId);
		}
		

		/**
		 * 
		 * @param topic
		 *            Persisting subtopic to database. To handle timezone offset, before
		 *            submission to DB, adding offset to date and updating date.
		 * 
		 * @author Samuel Louis-Pierre, Avant Mathur, (1712-dec10-java-Steve) Jordan
		 *         DeLong
		 */
		public Subtopic updateSubtopic(Subtopic subtopic) {
			Long newDate = subtopic.getSubtopicDate().getTime();
			subtopic.setSubtopicDate(new Timestamp(newDate));

			subtopicRepository.save(subtopic);
			return subtopic;
		}

		public SubtopicStatus getStatus(String name) {
			return subtopicStatusRepository.findByName(name);
		}
		
		  /**
		   * 
		   * @param int
		   *          type
		   * @return List of Subtopics by status
		   */
		  public List<Subtopic> getSubtopicsByStatus(SubtopicStatus status) {
			  System.out.println("Here");
		    return subtopicRepository.findSubtopicByStatus(status);
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
	    return subtopicRepository.countSubtopicsByBatchid(batchId);
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
	  public List<Subtopic> findByBatchId(int batchId) {
	    //return subtopicRepository.findByBatch(batchRepository.findByid(batchId), pageRequest);
		  return subtopicRepository.findByBatchid(batchId);
	  }
	  public List<Subtopic> findByBatchId(int batchId, Pageable pageRequest) {
		  return subtopicRepository.findByBatchid(batchId, pageRequest);
	  }

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
	   * @param String
	   *          name
	   * @return List of subtopic by SubtopicName
	   */
	  public SubtopicName getSubtopicByName(SubtopicName name) {
	    return subtopicRepository.findSubtopicBySubtopicName(name);
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
	   * @param int
	   *          type
	   * @return List of Subtopics
	   */
	  public List<SubtopicName> getSubtopicByType(int type) {
	    return subtopicNameRepository.findByTypeId(type);
	  }

	  /**
	   * 
	   * @param SubtopicName
	   *          subtopicName
	   * @author Brian McKalip
	 * @return 
	   */
	  public SubtopicName addOrUpdateSubtopicName(SubtopicName subtopicName) {
	   return subtopicNameRepository.save(subtopicName);
	  }
	  
	  /**
	   * Service to remove subtopic belonging to a batch.
	   * If exception then return false.
	   * @param subtopicId
	   * @return boolean
	   * 
	   * @author Sean Sung | (1712-dec10-java-Steve)
	   */
	  public boolean removeSubtopicFromBatch(int subtopicId) {
		  if(!subtopicRepository.existsById(subtopicId)) {
			  return false;
		  }
		  try {
		  	  //subtopicRepository.delete(subtopicId);
			  subtopicRepository.deleteById(subtopicId);
			  return true;
		  } catch(IllegalArgumentException e) {
			  return false;
		  } 
	  }
	  
	  /**
	   * Removes all subtopics from the given batch's calendar
	   * @author Jordan DeLong, Cristian Hermida, Charlie Harris / Batch 1712-dec10-java-steve
	   * @param batchId
	   * @return True if subtopics are successfully removed, false otherwise
	   * 
	   * Need to work on Batch
	   * 
	   */
	  @Transactional
	  public boolean removeAllSubtopicsFromBatch(int batchId) {
		  try {
			  int x=subtopicRepository.deleteByBatchid(batchId);
			  System.out.println(x);
			  if(x==0)
				  return false;
			  else		  
				  return true;
		  } catch(IllegalArgumentException e) {
			  return false;
		  } 
	  }

	  	public Subtopic updateSubtopicStatus(Subtopic subtopic) {
			return subtopicRepository.save(subtopic);
		}
	  	
	  	/**
	  	 * Returns a single subtopic for a batch, if any exist
	  	 * @author Jordan DeLong, Cristian Hermida, Charlie Harris / Batch 1712-dec10-java-steve
	  	 * @param batchId
	  	 * @return List<Subtopic>
	  	 */
		public List<Subtopic> findTop1ByBatchId(int batchId){
			return subtopicRepository.findTop1ByBatchid(batchId);
		}
		
		public List<Subtopic> saveSubtopics(List<Subtopic> subtopics) {
			//return subtopicRepository.save(subtopics);
			return subtopicRepository.saveAll(subtopics);
		}

		
	  	/**
	  	 * Maps curriculum subtopics into subtopics. Each subtopic date is determined by the start date of the batch offset by the week and day of the corresponding curriculum subtopic. 
	  	 * @author Jordan DeLong, Cristian Hermida, Charlie Harris / Batch 1712-dec10-java-steve
	  	 * @param map, batch
	  	 * @return List<Subtopic>
	  	 */
		public List<Subtopic> mapCurriculumSubtopicsToSubtopics(Map<Integer, List<CurriculumSubtopic>> map, int batchid){
			
			SubtopicStatus subStatus = subtopicStatusRepository.findByName("Pending");
			ArrayList<Subtopic> subtopics = new ArrayList<>();
			
			//spin up multiple threads that concurrently instantiate new subtopics from lists of curriculum subtopics and add each new subtopic instance to a list of subtopics that will be persisted once all threads have finished
			map.forEach((day, weeks) -> {
				Calendar cal = Calendar.getInstance();

			    Random rand = new Random(System.currentTimeMillis());
			    
				for(CurriculumSubtopic curriculumSubtopic: weeks){
					
					// a random starting hour between 9:00 am and 4:00 pm is assigned for each new subtopic
					// +5 hours are added to the min and max of range to compensate for production server timezone difference
				    int randomNum = rand.nextInt((21 - 14) + 1) + 14; // nextInt is normally exclusive of the top value, so add 1 to make it inclusive
				    
					Subtopic subtopic = new Subtopic();
					
					subtopic.setBatch(batchid);
					subtopic.setSubtopicName(curriculumSubtopic.getCurriculumSubtopicNameId());
					subtopic.setStatus(subStatus);
					
					//set date to the batch start date
					//Batch batch= RequestController.findBatchById(batchid);
					//System.out.println(batch);
					
					//cal.setTime(batch.getStartDate());
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					cal.setTime(timestamp);
					//set the time
					cal.set(Calendar.HOUR_OF_DAY, randomNum);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					
					//determine how many days offset from the start date the new subtopic will be
					//Need to do curriculum
					int week = curriculumSubtopic.getCurriculumSubtopicWeek();
					int absDay = (week-1)*7 + day - 1;
					
					//determine what the actual date on the calendar will be by adding the offset to the currently set calendar day (the batch start date)
					cal.add(Calendar.DAY_OF_WEEK, absDay);
					
					//set the subtopic date by converting the calculated date into milliseconds
					subtopic.setSubtopicDate(new Timestamp(cal.getTime().getTime()));
					
					//add the subtopic to a list of subtopics that will be persisted to the database
					subtopics.add(subtopic);
				}	
			});
			//return subtopicRepository.save(subtopics);
			return subtopicRepository.saveAll(subtopics);
			
			
		}

}
