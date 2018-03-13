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

import com.revature.model.Batch;
import com.revature.model.CurriculumSubtopic;
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
	
	
	//Not sure how to test
	@GetMapping("/getSubtopicByBatch")
	public ResponseEntity <List<Subtopic>> getSubtopicByBatch(@RequestBody Batch batch){
		return new ResponseEntity<List<Subtopic>> (subTopicService.getSubtopicByBatch(batch),HttpStatus.OK);
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
	
	//Works
	@GetMapping("getAllSubTopics")
	public ResponseEntity <List<SubtopicName>> getAllSubtopics(){
		return new ResponseEntity<List<SubtopicName>> (subTopicService.getAllSubtopics(),HttpStatus.OK);
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
	
	//Working on it
	@GetMapping("addOrUpdateSubtopicName")
	public ResponseEntity <SubtopicName> addOrUpdateSubtopicName(@RequestBody SubtopicName subtopicName){
		return new ResponseEntity<SubtopicName> (subTopicService.addOrUpdateSubtopicName(subtopicName),HttpStatus.OK);
	}
	
	//Working on it
	@GetMapping("removeSubtopicFromBatch")
	public ResponseEntity <Boolean> removeSubtopicFromBatch(@RequestBody int subtopicId){
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

	//Working on it
	@GetMapping("findTop1ByBatchId")
	public ResponseEntity <List<Subtopic>> findTop1ByBatchId(@RequestBody int batchId){
		return new ResponseEntity<List<Subtopic>> (subTopicService.findTop1ByBatchId(batchId),HttpStatus.OK);
	}
	
	//Working on it
	@GetMapping("saveSubtopics")
	public ResponseEntity <List<Subtopic>> saveSubtopics(@RequestBody List<Subtopic> subtopics){
		return new ResponseEntity<List<Subtopic>> (subTopicService.saveSubtopics(subtopics),HttpStatus.OK);
	}
	
	//Working on it
	@GetMapping("mapCurriculumSubtopicsToSubtopics")
	public ResponseEntity <List<Subtopic>> mapCurriculumSubtopicstoSubtopics(@RequestBody Map<Integer, List<CurriculumSubtopic>> map, @RequestBody Batch batch ){
		return new ResponseEntity<List<Subtopic>> (subTopicService.mapCurriculumSubtopicsToSubtopics(map, batch),HttpStatus.OK);
	}
}



