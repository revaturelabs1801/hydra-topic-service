package com.revature.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.model.Batch;
import com.revature.model.CurriculumSubtopic;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.model.SubtopicType;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

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
	
	@GetMapping("getSubtopicByBatch")
	public ResponseEntity <List<Subtopic>> getSubtopicByBatch(@RequestBody Batch batch){
		return new ResponseEntity<List<Subtopic>> (subTopicService.getSubtopicByBatch(batch),HttpStatus.OK);
	}
	
	@GetMapping("getStatus")
	public ResponseEntity <SubtopicStatus> getStatus(@RequestBody String name){
		return new ResponseEntity<SubtopicStatus> (subTopicService.getStatus(name),HttpStatus.OK);
	}
	
	@GetMapping("getNumberofSubtopics")
	public ResponseEntity <Long> getNumberOfSubtopics(@RequestBody int batchId){
		return new ResponseEntity<Long> (subTopicService.getNumberOfSubtopics(batchId),HttpStatus.OK);
	}
	
	@GetMapping("getAllSubTopics")
	public ResponseEntity <List<SubtopicName>> getAllSubtopics(){
		return new ResponseEntity<List<SubtopicName>> (subTopicService.getAllSubtopics(),HttpStatus.OK);
	}
	
	@GetMapping("getSubtopics")
	public ResponseEntity <List<Subtopic>> getSubtopics(){
		return new ResponseEntity<List<Subtopic>> (subTopicService.getSubtopics(),HttpStatus.OK);
	}
	
	@GetMapping("getSubtopicName")
	public ResponseEntity <SubtopicName> getSubtopicName(@RequestBody String name){
		return new ResponseEntity<SubtopicName> (subTopicService.getSubtopicName(name),HttpStatus.OK);
	}
	
	@GetMapping("getSubtopicType")
	public ResponseEntity <SubtopicType> getSubtopicType(@RequestBody int type){
		return new ResponseEntity<SubtopicType> (subTopicService.getSubtopicType(type),HttpStatus.OK);
	}
	
	@GetMapping("addOrUpdateSubtopicName")
	public ResponseEntity <SubtopicName> addOrUpdateSubtopicName(@RequestBody SubtopicName subtopicName){
		return new ResponseEntity<SubtopicName> (subTopicService.addOrUpdateSubtopicName(subtopicName),HttpStatus.OK);
	}
	
	@GetMapping("removeSubtopicFromBatch")
	public ResponseEntity <Boolean> removeSubtopicFromBatch(@RequestBody int subtopicId){
		return new ResponseEntity<Boolean> (subTopicService.removeSubtopicFromBatch(subtopicId),HttpStatus.OK);
	}
	
	@GetMapping("removeAllSubtopicsFromBatch")
	public ResponseEntity <Boolean> removeAllSubtopicsFromBatch(@RequestBody int batchId){
		return new ResponseEntity<Boolean> (subTopicService.removeAllSubtopicsFromBatch(batchId),HttpStatus.OK);
	}
	
	@GetMapping("updateSubtopicStatus")
	public ResponseEntity <Subtopic> updateSubtopicStatus(@RequestBody Subtopic subtopic){
		return new ResponseEntity<Subtopic> (subTopicService.updateSubtopicStatus(subtopic),HttpStatus.OK);
	}

	@GetMapping("findTop1ByBatchId")
	public ResponseEntity <List<Subtopic>> findTop1ByBatchId(@RequestBody int batchId){
		return new ResponseEntity<List<Subtopic>> (subTopicService.findTop1ByBatchId(batchId),HttpStatus.OK);
	}
	
	@GetMapping("saveSubtopics")
	public ResponseEntity <List<Subtopic>> saveSubtopics(@RequestBody List<Subtopic> subtopics){
		return new ResponseEntity<List<Subtopic>> (subTopicService.saveSubtopics(subtopics),HttpStatus.OK);
	}
	
	@GetMapping("mapCurriculumSubtopicsToSubtopics")
	public ResponseEntity <List<Subtopic>> mapCurriculumSubtopicstoSubtopics(@RequestBody Map<Integer, List<CurriculumSubtopic>> map, @RequestBody Batch batch ){
		return new ResponseEntity<List<Subtopic>> (subTopicService.mapCurriculumSubtopicsToSubtopics(map, batch),HttpStatus.OK);
	}
}



