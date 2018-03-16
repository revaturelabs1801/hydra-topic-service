package com.revature.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.CustomException;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicStatus;
import com.revature.model.TopicName;
import com.revature.model.TopicWeek;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

@RestController
@RequestMapping("calendar/")
@CrossOrigin
public class CalendarController {
	@Autowired
	SubTopicService subtopicService;

	@Autowired
	TopicService topicService;

	/**
	 * 
	 * This uses pagination. Will return a list of subtopics depending on what page
	 * and how many per page of subtopics you want. The page number and size is
	 * determined by the parameters.
	 * 
	 * Depending on how the FullCalendar API is setup to take pages of json data,
	 * this method may need to change.
	 * 
	 * @param request
	 *            - Parameters: batchId (int), pageNumber (int), pageSize (int, > 0)
	 * @return List<Stubtopic> , HttpStatus.OK (200) if successful, BAD REQUEST
	 *         (400) if missing parameters
	 * 
	 * @author: Michael Garza Gary LaMountain (batch unknown), Charlie Harris
	 *          (1712-dec10-java-Steve)
	 */
	@GetMapping("subtopicspagination/{batchId}/{pageNumber}/{pageSize}")
	public List<Subtopic> getSubtopicsByBatchPagination(@PathVariable Integer batchId,
			@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {

		if (batchId == null || pageNumber == null || pageSize == null || pageSize <= 0) {
			//throw new CustomException("TODO SEND BAD REQUEST");
		}

		List<Subtopic> subtopicLst = subtopicService.findByBatchId(batchId, new PageRequest(pageNumber, pageSize));
		if (subtopicLst.isEmpty()) {
			//throw new CustomException("TODO SEND NO CONTENT");
		}
		return subtopicLst;
	}

	/**
	 * Gets a list of subtopics for a given batch
	 * 
	 * @param request
	 *            -Parameters: batchId (int)
	 * @return List of subtopics for the batch with the given id OK (200) if
	 *         successful, BAD REQUEST (400) if missing parameters
	 * @author Charlie Harris (1712-dec10-java-Steve)
	 */
	@GetMapping("subtopics/{batchId}")
	public List<Subtopic> getSubtopicsByBatch(@PathVariable Integer batchId) {
		if (batchId == null) {
			//throw new CustomException("TODO SEND BAD REQUEST");
		}

		List<Subtopic> subtopicLst = subtopicService.getSubtopicByBatchId(batchId);
		if (subtopicLst.isEmpty()) {
			//throw new CustomException("TODO SEND NO CONTENT");
		}
		return subtopicLst;
	}

	/**
	 * Counts the number of Subtopics by matching their ids with the batchId.
	 * 
	 * @param request
	 *            -Parameters: batchId (int)
	 * @return number(Long) of Subtopics, OK (200) if successful, BAD REQUEST (400)
	 *         if missing parameters
	 * @author Michael Garza (batch unknown), Gary LaMountain (batch unknown),
	 *         Charlie Harris (1712-dec10-java-Steve)
	 */
	@GetMapping("getnumberofsubtopics/{batchId}")
	public Long getNumberOfSubTopicsByBatch(@PathVariable Integer batchId) {
		if (batchId == null) {
			//throw new CustomException("TODO SEND BAD REQUEST");
		}

		return subtopicService.getNumberOfSubtopics(batchId);
	}

	/**
	 * Gets a list of topics for a given batch
	 * 
	 * @param request
	 *            - Parameters: - batchId (int)
	 * @return List of topics for the batch with the given id, HttpStatus.OK (200)
	 *         if successful, BAD REQUEST (400) if missing parameters
	 * @author Charlie Harris (1712-dec10-java-Steve)
	 */
	@GetMapping("topics/{batchId}")
	public List<TopicWeek> getTopicsByBatchPag(@PathVariable Integer batchId) {
		if (batchId == null) {
			//throw new CustomException("TODO SEND BAD REQUEST");
		}

		List<TopicWeek> topicLst = topicService.getTopicByBatchId(batchId);
		if (topicLst.isEmpty()) {
			//throw new CustomException("TODO SEND NO CONTENT");
		}
		return topicLst;
	}

	/**
	 * Updates the date for the given subtopic in the given batch
	 * 
	 * @param request
	 *            Parameters: subtopicId (int), batchId (int), date (long/date)
	 * @return OK (200) if update occurs, NO CONTENT (204) if requested
	 *         batch/subtopic does not exist, BAD REQUEST (400) if missing
	 *         parameters
	 * @author (1712-dec10-java-Steve) Charlie Harris, Jordan DeLong
	 */
	@PostMapping("dateupdate/{subtopicId}/{batchId}/{date}")
	public boolean changeTopicDate(@PathVariable Integer subtopicId, @PathVariable Integer batchId, @PathVariable Long date) {
		if (subtopicId == null || batchId == null || date == null) {
			//throw new CustomException("TODO SEND BAD REQUEST");
		}

		List<Subtopic> topics = subtopicService.getSubtopicByBatchId(batchId);
		for (Subtopic sub : topics) {
			if (sub.getSubtopicId() == subtopicId) {
				sub.setSubtopicDate(new Timestamp(date));
				subtopicService.updateSubtopic(sub);
				return true;
			}
		}
		//throw new CustomException("TODO SEND NO CONTENT");
		return false;
	}

	/**
	 * Updates the status of the given subtopic in the given batch
	 * 
	 * @param request
	 *            Parameters: subtopicId (int), batchId (int), status (string)
	 * @return OK (200) if update occurs, NO CONTENT (204) if requested
	 *         batch/subtopic does not exist, BAD REQUEST (400) if missing
	 *         parameters
	 * @author Charlie Harris (1712-dec10-java-Steve)
	 */
	@GetMapping("statusupdate/{subtopicId}/{batchId}/{status}")
	public boolean updateTopicStatus(@PathVariable Integer subtopicId, @PathVariable Integer batchId, @PathVariable String status) {
		if (subtopicId == null || batchId == null || status == null) {
			//throw new CustomException("TODO SEND BAD REQUEST");
		}

		SubtopicStatus subtopicStatus = subtopicService.getStatus(status);
		List<Subtopic> topics = subtopicService.getSubtopicByBatchId(batchId);
		for (Subtopic sub : topics) {
			if (sub.getSubtopicId() == subtopicId) {
				sub.setStatus(subtopicStatus);
				subtopicService.updateSubtopic(sub);
				return true; 
			}
		}
		//throw new CustomException("TODO SEND NO CONTENT");
		return false;
	}

	/**
	 * Adds new topics from [topicsFromStub]
	 * 
	 * @param topicsFromStub
	 *            JSON array of TopicName objects, each TopicName should contain at
	 *            least a [name] field
	 * @return CREATED (201) if a topic was added, OK (200) if the request was
	 *         completed successfully but no topics were added
	 * @author Charlie Harris (1712-dec10-java-Steve)
	 */
	@PostMapping("addtopics")
	public boolean addTopics(@RequestBody List<TopicName> topicsFromStub, HttpSession session) {
		boolean topicAdded = false;
		List<TopicName> allTopicsInBAM = topicService.getTopics();
		for (TopicName newTopic : topicsFromStub) {
			boolean found = false;
			for (TopicName curTopic : allTopicsInBAM) {
				if (curTopic.getName().equals(newTopic.getName())) {
					found = true;
					break;
				}
			}
			if (!found) {
				topicService.addOrUpdateTopicName(newTopic);
				topicAdded = true;
			}
		}
		if (topicAdded) {
			//return new ResponseEntity<>(HttpStatus.CREATED);
			return true;
		}
		//return new ResponseEntity<>(HttpStatus.OK);
		return false;
	}
}
