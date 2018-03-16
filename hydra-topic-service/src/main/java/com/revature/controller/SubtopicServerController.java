package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
	/*
	 * Works, gets all subtopics associated with a batch
	 */
	@GetMapping("/getSubtopicByBatchId/{batchId}")
	public  List<Subtopic> getSubtopicByBatch(@PathVariable int batchId){
		return subTopicService.findByBatchId(batchId);
	}
	
	//Need to fix database thing
	@GetMapping("/getStatus/{name}")
	public SubtopicStatus getStatus(@PathVariable String name) {
		return subTopicService.getStatus(name);
	}
	
	//Do we need this?
	@GetMapping("getNumberofSubtopics/{batchId}")
	public  Long getNumberOfSubtopics(@PathVariable int batchId){
		return subTopicService.getNumberOfSubtopics(batchId);
	}
	
	/*
	 * Works
	 * Gets all SubtopicNames
	 */
	@GetMapping("getAllSubtopicNames")
	public  List<SubtopicName> getAllSubtopics(){
		return  subTopicService.getAllSubtopics();
	}
	
	/*
	 * Works
	 * Gets all Subtopics
	 */
	@GetMapping("getAllSubtopics")
	public  List<Subtopic> getSubtopics(){
		return subTopicService.getSubtopics();
	}
	
	//Do we need this?
	@GetMapping("getSubtopicByName/{name}")
	public  SubtopicName getSubtopicName(@PathVariable String name){
		return subTopicService.getSubtopicName(name);
	}
	
	//Works
	@GetMapping("getSubtopicByType/{type}")
	public  List<SubtopicName> getSubtopicType(@PathVariable int type){
		return  subTopicService.getSubtopicByType(type);
	}
	
	//Don't know how to test
	@PostMapping("addOrUpdateSubtopicName")
	public  SubtopicName addOrUpdateSubtopicName(@RequestBody SubtopicName subtopicName){
		return subTopicService.addOrUpdateSubtopicName(subtopicName);
	}

	//Works
	@GetMapping("removeSubtopicFromBatch/{subtopicId}")
	public  Boolean removeSubtopicFromBatch(@PathVariable int subtopicId){
		return  subTopicService.removeSubtopicFromBatch(subtopicId);
	}
	
	//Working on it
	@PostMapping("removeAllSubtopicsFromBatch")
	public  Boolean removeAllSubtopicsFromBatch(@RequestBody int batchId){
		return subTopicService.removeAllSubtopicsFromBatch(batchId);
	}
	
	//Working on it
	@PostMapping("updateSubtopicStatus")
	public  Subtopic updateSubtopicStatus(@RequestBody Subtopic subtopic){
		return subTopicService.updateSubtopicStatus(subtopic);
	}

	//Works
	@GetMapping("findTop1ByBatchId/{batchId}")
	public  List<Subtopic> findTop1ByBatchId(@PathVariable int batchId){
		return subTopicService.findTop1ByBatchId(batchId);
	}
	
	//Not sure how to test
	@PostMapping("saveSubtopics")
	public  List<Subtopic> saveSubtopics(@RequestBody List<Subtopic> subtopics){
		return subTopicService.saveSubtopics(subtopics);
	}
	
	//Working on it
	/*@GetMapping("mapCurriculumSubtopicsToSubtopics")
	public  <List<Subtopic>> mapCurriculumSubtopicstoSubtopics(@RequestBody Map<Integer, List<CurriculumSubtopic>> map, @RequestBody Batch batch ){
		return  <List<Subtopic>> (subTopicService.mapCurriculumSubtopicsToSubtopics(map, batch);
	}*/
}



