package com.contest.admin.services;

import com.contest.admin.body.ContestBody;

public interface IContestService {
	public ContestBody create(String contestName, long startTime);
	public Boolean start(Long contestId);
	public Boolean update(Long contestId);
	public Boolean end(Long contestId);
}
