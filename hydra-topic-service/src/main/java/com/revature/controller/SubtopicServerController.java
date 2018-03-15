package com.revature.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.model.SubtopicType;
import com.revature.model.TopicName;
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
	  public ResponseEntity<Subtopic> addSubtopic(@RequestBody Subtopic st) {
	    st = subTopicService.updateSubtopic(st);
	    return new ResponseEntity<Subtopic>(st, HttpStatus.CREATED);
	  }*/
	
	
	/*
	 * Works, gets all subtopics associated with a batch
	 */
	@GetMapping("/getSubtopicByBatchId/{batchId}")
	public ResponseEntity <List<Subtopic>> getSubtopicByBatch(@PathVariable int batchId){
		return new ResponseEntity<List<Subtopic>> (subTopicService.findByBatchId(batchId),HttpStatus.OK);
	}
	
	//Need to fix database thing
	@GetMapping("/getStatus/{name}")
	public ResponseEntity<SubtopicStatus> getStatus(@PathVariable String name) {
		System.out.println(name);
		SubtopicStatus s=subTopicService.getStatus(name);
		System.out.println(s);
		return new ResponseEntity<SubtopicStatus>(s,HttpStatus.OK);
	}
	
	//Do we need this?
	@GetMapping("getNumberofSubtopics")
	public ResponseEntity <Long> getNumberOfSubtopics(@RequestBody int batchId){
		return new ResponseEntity<Long> (subTopicService.getNumberOfSubtopics(batchId),HttpStatus.OK);
	}
	
	/*
	 * Works
	 * Gets all SubtopicNames
	 */
	@GetMapping("getAllSubtopicNames")
	public ResponseEntity <List<SubtopicName>> getAllSubtopics(){
		return new ResponseEntity<List<SubtopicName>> (subTopicService.getAllSubtopics(),HttpStatus.OK);
	}
	
	/*
	 * Works
	 * Gets all Subtopics
	 */
	@GetMapping("getAllSubtopics")
	public ResponseEntity <List<Subtopic>> getSubtopics(){
		return new ResponseEntity<List<Subtopic>> (subTopicService.getSubtopics(),HttpStatus.OK);
	}
	
	//Do we need this?
	@GetMapping("getSubtopicByName/{name}")
	public ResponseEntity <SubtopicName> getSubtopicName(@PathVariable String name){
		return new ResponseEntity<SubtopicName> (subTopicService.getSubtopicName(name),HttpStatus.OK);
	}
	
	//Works
	@GetMapping("getSubtopicByType/{type}")
	public ResponseEntity <List<SubtopicName>> getSubtopicType(@PathVariable int type){
		return new ResponseEntity<List<SubtopicName>> (subTopicService.getSubtopicByType(type),HttpStatus.OK);
	}
	
	//Don't know how to test
	@GetMapping("addOrUpdateSubtopicName")
	public ResponseEntity <SubtopicName> addOrUpdateSubtopicName(@PathVariable SubtopicName subtopicName){
		return new ResponseEntity<SubtopicName> (subTopicService.addOrUpdateSubtopicName(subtopicName),HttpStatus.OK);
	}

	//Works
	@GetMapping("removeSubtopicFromBatch/{subtopicId}")
	public ResponseEntity <Boolean> removeSubtopicFromBatch(@PathVariable int subtopicId){
		System.out.println(subtopicId);
		return new ResponseEntity<Boolean> (subTopicService.removeSubtopicFromBatch(subtopicId),HttpStatus.OK);
	}
	
	//Working on it
	@GetMapping("removeAllSubtopicsFromBatch")
	public ResponseEntity <Boolean> removeAllSubtopicsFromBatch(@RequestBody int batchId){
		return new ResponseEntity<Boolean> (subTopicService.removeAllSubtopicsFromBatch(batchId),HttpStatus.OK);
	}
	
	//Working on it
	@GetMapping("updateSubtopicStatus")
	public ResponseEntity <Subtopic> updateSubtopicStatus(@RequestBody Subtopic subtopic){
		return new ResponseEntity<Subtopic> (subTopicService.updateSubtopicStatus(subtopic),HttpStatus.OK);
	}

	//Works
	@GetMapping("findTop1ByBatchId/{batchId}")
	public ResponseEntity <List<Subtopic>> findTop1ByBatchId(@PathVariable int batchId){
		System.out.println("Test");
		return new ResponseEntity<List<Subtopic>> (subTopicService.findTop1ByBatchId(batchId),HttpStatus.OK);
	}
	
	//Not ure how to test
	@GetMapping("saveSubtopics")
	public ResponseEntity <List<Subtopic>> saveSubtopics(@RequestBody List<Subtopic> subtopics){
		return new ResponseEntity<List<Subtopic>> (subTopicService.saveSubtopics(subtopics),HttpStatus.OK);
	}
	
	//Working on it
	/*@GetMapping("mapCurriculumSubtopicsToSubtopics")
	public ResponseEntity <List<Subtopic>> mapCurriculumSubtopicstoSubtopics(@RequestBody Map<Integer, List<CurriculumSubtopic>> map, @RequestBody Batch batch ){
		return new ResponseEntity<List<Subtopic>> (subTopicService.mapCurriculumSubtopicsToSubtopics(map, batch),HttpStatus.OK);
	}*/
}



