package com.revature.model;

import com.revature.logging.JSONify;

public class Curriculum {


	private Integer id;
	
	private String curriculumName;
	
	private int curriculumVersion;
	
	private String curriculumdateCreated;
	
	private int curriculumNumberOfWeeks;
	
	public Curriculum(){
		//Empty Because No Args
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public int getCurriculumVersion() {
		return curriculumVersion;
	}

	public void setCurriculumVersion(int curriculumVersion) {
		this.curriculumVersion = curriculumVersion;
	}

	public String getCurriculumdateCreated() {
		return curriculumdateCreated;
	}

	public void setCurriculumdateCreated(String curriculumdateCreated) {
		this.curriculumdateCreated = curriculumdateCreated;
	}

	public int getCurriculumNumberOfWeeks() {
		return curriculumNumberOfWeeks;
	}

	public void setCurriculumNumberOfWeeks(int curriculumNumberOfWeeks) {
		this.curriculumNumberOfWeeks = curriculumNumberOfWeeks;
	}


	@Override
	public String toString() {
		JSONify jsonify = new JSONify();
		String json = "{" + jsonify.quotify("Curriculum") + ":{";
		json += jsonify.addKey("curriculumID") + jsonify.addValue(id.toString());
		json += jsonify.addKey("curriculumName") + jsonify.addValue(curriculumName);
		json += jsonify.addKey("curriculumVersion") + jsonify.addValue(String.valueOf(curriculumVersion));
		json += jsonify.addKey("curriculumDateCreated") + jsonify.addValue(curriculumdateCreated);
		json += jsonify.addKey("curriculumNumberOfWeeks") + jsonify.addValue(String.valueOf(curriculumNumberOfWeeks));
		json += "}}";
		
		return json;
}
	
}
