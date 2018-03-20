package com.revature.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.model.Batch;
import com.revature.model.CurriculumSubtopic;
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
	
	//Works
	@GetMapping("/getSubtopicsByStatus/{name}")
	public List<Subtopic> getStatus(@PathVariable String name) {
		SubtopicStatus s=subTopicService.getStatus(name);
		return subTopicService.getSubtopicsByStatus(s);
	}
	

	@GetMapping("getNumberofSubtopics/{batchId}")
	public Long getNumberOfSubtopics(@PathVariable int batchId){
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

	@GetMapping("mapCurriculumSubtopicsToSubtopics/{batchid}")
	public List<Subtopic> mapCurriculumSubtopicstoSubtopics(@RequestBody Map<Integer, List<CurriculumSubtopic>> map, @PathVariable int batchid ){
		return subTopicService.mapCurriculumSubtopicsToSubtopics(map, batchid);
	}

}



