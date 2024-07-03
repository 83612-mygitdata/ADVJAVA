package com.sunbeam.bean;

import com.sunbeam.pojos.Candidate;
import com.sunbem.daos.CandidateDao;
import com.sunbem.daos.CandidateDaoImpl;

public class FindCandidateBean {
	private int id;
	private Candidate candidate;
	
	public FindCandidateBean() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void fetchCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			candidate = candDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
