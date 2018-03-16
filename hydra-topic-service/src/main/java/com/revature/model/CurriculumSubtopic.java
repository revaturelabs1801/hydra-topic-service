package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.logging.JSONify;
import com.revature.model.SubtopicName;


public class CurriculumSubtopic {
	

	private int curriculumSubtopicId;
	

	private SubtopicName curriculumSubtopicNameId;

	private Curriculum curriculum;

	private int curriculumSubtopicWeek;
	
	private int curriculumSubtopicDay;
	
	public CurriculumSubtopic() {
		//Empty Because No Args
	}

	public CurriculumSubtopic(int curriculumSubtopicId, SubtopicName curriculumSubtopicNameId,
		Curriculum curriculumSubtopicCurriculumID, int curriculumSubtopicWeek, int curriculumSubtopicDay) {
		super();
		this.curriculumSubtopicId = curriculumSubtopicId;
		this.curriculumSubtopicNameId = curriculumSubtopicNameId;
		this.curriculum = curriculumSubtopicCurriculumID;
		this.curriculumSubtopicWeek = curriculumSubtopicWeek;
		this.curriculumSubtopicDay = curriculumSubtopicDay;
	}

	public int getCurriculumSubtopicId() {
		return curriculumSubtopicId;
	}

	public void setCurriculumSubtopicId(int curriculumSubtopicId) {
		this.curriculumSubtopicId = curriculumSubtopicId;
	}

	public SubtopicName getCurriculumSubtopicNameId() {
		return curriculumSubtopicNameId;
	}

	public void setCurriculumSubtopicNameId(SubtopicName curriculumSubtopicNameId) {
		this.curriculumSubtopicNameId = curriculumSubtopicNameId;
	}

	@JsonIgnore
	public Curriculum getCurriculumSubtopicCurriculumID() {
		return curriculum;
	}

	public void setCurriculumSubtopicCurriculumID(Curriculum curriculumSubtopicCurriculumID) {
		this.curriculum = curriculumSubtopicCurriculumID;
	}

	public int getCurriculumSubtopicWeek() {
		return curriculumSubtopicWeek;
	}

	public void setCurriculumSubtopicWeek(int curriculumSubtopicWeek) {
		this.curriculumSubtopicWeek = curriculumSubtopicWeek;
	}

	public int getCurriculumSubtopicDay() {
		return curriculumSubtopicDay;
	}

	public void setCurriculumSubtopicDay(int curriculumSubtopicDay) {
		this.curriculumSubtopicDay = curriculumSubtopicDay;
	}

	@Override
	public String toString() {
		JSONify jsonify = new JSONify();
		String json = "{" + jsonify.quotify("CurriculumSubtopic") + ":{";
		json += jsonify.addKey("curriculumSubtopicID") + jsonify.addValue(String.valueOf(curriculumSubtopicId));
		json += jsonify.addKey("curriculumSubtopicNameID") + curriculumSubtopicNameId + ",";
		json += jsonify.addKey("curriculumSubtopicCurriculumID") + curriculum + ",";
		json += jsonify.addKey("curriculumSubtopicWeek") + jsonify.addValue(String.valueOf(curriculumSubtopicWeek));
		json += jsonify.addKey("curriculumSubtopicDay") + jsonify.addEndValue(String.valueOf(curriculumSubtopicDay));
		json += "}}";
		
		return json;
	}
}
