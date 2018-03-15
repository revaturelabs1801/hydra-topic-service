package com.revature.model;

import java.sql.Timestamp;

import com.revature.logging.JSONify;

public class Batch {

	private Integer id;

	private String name;

	private Timestamp startDate;

	private Timestamp endDate;


	public Batch() {
		super();
	}

	public Batch(Integer id, String name, Timestamp startDate, Timestamp endDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Batch(String name, Timestamp startDate, Timestamp endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		JSONify jsonify = new JSONify();
		String json = "{" + jsonify.quotify("Batches") + ":{";
		json += jsonify.addKey("batchesID") + jsonify.addValue(id.toString());
		json += jsonify.addKey("batchesName") + jsonify.addValue(name);
		json += jsonify.addKey("batchesStartDate") + jsonify.addValue(startDate.toString());
		json += jsonify.addKey("batchesEndDate") + jsonify.addValue(endDate.toString());
		json += "}}";
		return json;
	}

}
