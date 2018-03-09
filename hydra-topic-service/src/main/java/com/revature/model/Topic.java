package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "SUBTOPIC")
@Component
public class Topic {

	@Id
	@Column(name = "Subtopic_Id")
	@SequenceGenerator(name = "SUBTOPIC_SEQ", sequenceName = "SUBTOPIC_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBTOPIC_SEQ")
	private int subtopicId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SUBTOPIC_NAME_ID", referencedColumnName = "SUBTOPIC_NAME_ID")
	@Autowired
	private TopicName topicName;



	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SUBTOPIC_STATUS_ID", referencedColumnName = "STATUS_ID")
	@Autowired
	private TopicStatus status;

	@Column(name = "Subtopic_Date")
	private Timestamp subtopicDate;

	public Topic() {
		super();
	}

	public Topic(TopicName topicName, TopicStatus status, Timestamp subtopicDate) {
		super();
		this.topicName = topicName;

		this.status = status;
		this.subtopicDate = subtopicDate;
	}

	public Topic(int subtopicId, TopicName topicName, TopicStatus status,
			Timestamp subtopicDate) {
		super();
		this.subtopicId = subtopicId;
		this.topicName = topicName;

		this.status = status;
		this.subtopicDate = subtopicDate;
	}

	public int getSubtopicId() {
		return subtopicId;
	}

	public void setSubtopicId(int subtopicId) {
		this.subtopicId = subtopicId;
	}

	public TopicName getSubtopicName() {
		return topicName;
	}

	public void setSubtopicName(TopicName topicName) {
		this.topicName = topicName;
	}


	public TopicStatus getStatus() {
		return status;
	}

	public void setStatus(TopicStatus status) {
		this.status = status;
	}

	public Timestamp getSubtopicDate() {
		return subtopicDate;
	}

	public void setSubtopicDate(Timestamp subtopicDate) {
		this.subtopicDate = subtopicDate;
	}

	@Override
	public String toString() {
		return "Topic [subtopicId=" + subtopicId +", subtopicDate=" + subtopicDate + ", status=" + status +"]";
	}

}