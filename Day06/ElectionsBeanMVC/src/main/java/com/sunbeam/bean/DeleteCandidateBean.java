package com.sunbeam.bean;

import com.sunbem.daos.CandidateDao;
import com.sunbem.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	private int id;
	int count;
	
	public DeleteCandidateBean() {
		this.count=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void delete() {
		try {
			
			CandidateDao candDao = new CandidateDaoImpl();
			
			count=candDao.deleteById(id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
