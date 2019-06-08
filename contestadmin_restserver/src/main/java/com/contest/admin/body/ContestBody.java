package com.contest.admin.body;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.contest.admin.enums.ContestStatus;

public class ContestBody {
	private Long id;
	private String name;
	private ContestStatus status;
	
	private Timestamp createdTime;
	private Timestamp startTime;
	private Timestamp endTime;
	
	private List<ParticipantBody> participantList;
	
	private HashMap<Integer, QuestionBody> questionMap;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public HashMap<Integer, QuestionBody> getQuestionMap() {
		return questionMap;
	}

	public void setQuestionMap(HashMap<Integer, QuestionBody> questionMap) {
		this.questionMap = questionMap;
	}

	public ContestStatus getStatus() {
		return status;
	}

	public void setStatus(ContestStatus status) {
		this.status = status;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public List<ParticipantBody> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<ParticipantBody> participantList) {
		this.participantList = participantList;
	}

	
	
	
}
