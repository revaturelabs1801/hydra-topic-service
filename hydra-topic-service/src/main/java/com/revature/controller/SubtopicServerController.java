package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.NoSubtopicException;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;



@RestController
@RequestMapping("api/v2/subtopicService")
public class SubtopicServerController {
	

	@Autowired
	TopicService topicService;

	@Autowired
	SubTopicService subTopicService;
	
	
/*	@PostMapping("addsubtopic")
	  public <Subtopic> addSubtopic(@RequestBody Subtopic st) {
	    st = subTopicService.updateSubtopic(st);
	    return  <Subtopic>(st, HttpStatus.CREATED);
	  }*/
	
	
	/*
	 * Works, gets all subtopics associated with a batch
	 */
	@GetMapping("/getSubtopicByBatchId/{batchId}")
	public  List<Subtopic> getSubtopicByBatch(@PathVariable int batchId) throws NoSubtopicException{
		return subTopicService.findByBatchId(batchId);
	}
	
	//Need to fix database thing
	@GetMapping("/getStatus/{name}")
	public SubtopicStatus getStatus(@PathVariable String name) throws NoSubtopicException{
		System.out.println(name);
		SubtopicStatus s=subTopicService.getStatus(name);
		System.out.println(s);
		return s;
	}
	
	//Do we need this?
	@GetMapping("getNumberofSubtopics")
	public  Long getNumberOfSubtopics(@RequestBody int batchId)throws NoSubtopicException{
		return subTopicService.getNumberOfSubtopics(batchId);
	}
	
	/*
	 * Works
	 * Gets all SubtopicNames
	 */
	@GetMapping("getAllSubtopicNames")
	public  List<SubtopicName> getAllSubtopics() throws NoSubtopicException{
		return  subTopicService.getAllSubtopics();
	}
	
	/*
	 * Works
	 * Gets all Subtopics
	 */
	@GetMapping("getAllSubtopics")
	public  List<Subtopic> getSubtopics() throws NoSubtopicException{
		return subTopicService.getSubtopics();
	}
	
	//Do we need this?
	@GetMapping("getSubtopicByName/{name}")
	public  SubtopicName getSubtopicName(@PathVariable String name) throws NoSubtopicException{
		return subTopicService.getSubtopicName(name);
	}
	
	//Works
	@GetMapping("getSubtopicByType/{type}")
	public  List<SubtopicName> getSubtopicType(@PathVariable int type) throws NoSubtopicException{
		return  subTopicService.getSubtopicByType(type);
	}
	
	//Don't know how to test
	@GetMapping("addOrUpdateSubtopicName")
	public  SubtopicName addOrUpdateSubtopicName(@PathVariable SubtopicName subtopicName) throws NoSubtopicException{
		return subTopicService.addOrUpdateSubtopicName(subtopicName);
	}

	//Works
	@GetMapping("removeSubtopicFromBatch/{subtopicId}")
	public  Boolean removeSubtopicFromBatch(@PathVariable int subtopicId) throws NoSubtopicException{
		System.out.println(subtopicId);
		return  subTopicService.removeSubtopicFromBatch(subtopicId);
	}
	
	//Working on it
	@GetMapping("removeAllSubtopicsFromBatch")
	public  Boolean removeAllSubtopicsFromBatch(@RequestBody int batchId) throws NoSubtopicException{
		return subTopicService.removeAllSubtopicsFromBatch(batchId);
	}
	
	//Working on it
	@GetMapping("updateSubtopicStatus")
	public  Subtopic updateSubtopicStatus(@RequestBody Subtopic subtopic) throws NoSubtopicException{
		return subTopicService.updateSubtopicStatus(subtopic);
	}

	//Works
	@GetMapping("findTop1ByBatchId/{batchId}")
	public  List<Subtopic> findTop1ByBatchId(@PathVariable int batchId) throws NoSubtopicException{
		System.out.println("Test");
		return subTopicService.findTop1ByBatchId(batchId);
	}
	
	//Not ure how to test
	@GetMapping("saveSubtopics")
	public  List<Subtopic> saveSubtopics(@RequestBody List<Subtopic> subtopics) throws NoSubtopicException{
		return subTopicService.saveSubtopics(subtopics);
	}
	
	//Working on it
	/*@GetMapping("mapCurriculumSubtopicsToSubtopics")
	public  <List<Subtopic>> mapCurriculumSubtopicstoSubtopics(@RequestBody Map<Integer, List<CurriculumSubtopic>> map, @RequestBody Batch batch ){
		return  <List<Subtopic>> (subTopicService.mapCurriculumSubtopicsToSubtopics(map, batch);
	}*/
}



