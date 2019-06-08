package com.contest.admin.body;

import java.util.HashMap;

public class QuestionBody {
	private Long id;
	private String title;
	private String description;
	private HashMap<Integer, AnswerBody> answers;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public HashMap<Integer, AnswerBody> getAnswers() {
		return answers;
	}
	public void setAnswers(HashMap<Integer, AnswerBody> answers) {
		this.answers = answers;
	}
	
	
}
