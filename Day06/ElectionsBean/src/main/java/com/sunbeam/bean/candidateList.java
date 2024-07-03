package com.sunbeam.bean;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.Candidate;
import com.sunbem.daos.CandidateDao;
import com.sunbem.daos.CandidateDaoImpl;

public class candidateList {
	private List<Candidate> candidateList;

	public candidateList() {
		
		this.candidateList = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	public void fetchCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			candidateList = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
