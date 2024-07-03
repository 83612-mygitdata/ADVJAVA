package com.sunbeam.bean;

import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;
import com.sunbem.daos.CandidateDao;
import com.sunbem.daos.CandidateDaoImpl;
import com.sunbem.daos.UserDao;
import com.sunbem.daos.UserDaoImpl;

public class voteBean {
	private int candidateId;
	private int userId;
	int voted =0;
	
	public voteBean() {
		
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getVoted() {
		return voted;
	}

	public void setVoted(int voted) {
		this.voted = voted;
	}

	public void vote() {
		try{
			CandidateDao candDao = new CandidateDaoImpl();
			candDao.incrementVote(candidateId);
			
			UserDao userdao = new UserDaoImpl();
			
			voted = userdao.updateStatus(userId, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
