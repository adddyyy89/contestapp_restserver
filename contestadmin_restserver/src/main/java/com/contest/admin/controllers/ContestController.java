package com.contest.admin.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contest.admin.body.ContestBody;
import com.contest.admin.body.CreateContestRequest;
import com.contest.admin.body.QuestionBody;
import com.contest.admin.services.IContestService;

@RestController
public class ContestController {

	@Autowired
	IContestService contestService;

	@RequestMapping(name = "create", method = RequestMethod.POST, consumes = "application/json")
	public ContestBody create(@RequestBody(required = true) CreateContestRequest createContestRequest) {

		// Create a new contest
		return contestService.create(createContestRequest.contestName, createContestRequest.startTime);

	}

	public Boolean start(Long contestId) {

		// Start contest
		return contestService.start(contestId);
	}

	public ContestBody update(Long contestId, HashMap<Integer, QuestionBody> questionMap) {

		// Find contest

		// Update the contest with provided question set

		// Save

		// Return updated contest body
		return null;
	}

	public Boolean end(Long contestId) {

		// Find contest

		// If contest is running, then stop

		// Save

		// Return status
		return false;

	}
}
