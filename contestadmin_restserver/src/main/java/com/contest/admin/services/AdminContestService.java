package com.contest.admin.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.contest.admin.body.ContestBody;
import com.contest.admin.enums.ContestStatus;

@Service
public class AdminContestService implements IContestService {

	private static Long nextID = (long) 1;
	private static HashMap<Long, ContestBody> contestMap = new HashMap<>();

	public AdminContestService() {

	}

	public ContestBody create(String contestName, long startTime) {

		System.out.println("Admin Contest Service: create method initiated");
		
		ContestBody contest = new ContestBody();

		contest.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		contest.setId(nextID);
		contest.setName(contestName);
		contest.setParticipantList(new ArrayList<>());
		contest.setQuestionMap(new HashMap<>());
		contest.setStartTime(new Timestamp(startTime));
		contest.setStatus(ContestStatus.CREATED);
		contestMap.put(contest.getId(), contest);

		nextID++;
		
		System.out.println("Admin Contest Service: create method completed");

		return contest;
	}

	@Override
	public Boolean start(Long contestId) {
		ContestBody contest = null;
		if (contestMap.containsKey(contestId)) {
			contest = contestMap.get(contestId);
			contest.setStatus(ContestStatus.RUNNING);
		} else {
			return false;
		}

		return true;
	}

	@Override
	public Boolean update(Long contestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean end(Long contestId) {
		// TODO Auto-generated method stub
		return null;
	}

}
