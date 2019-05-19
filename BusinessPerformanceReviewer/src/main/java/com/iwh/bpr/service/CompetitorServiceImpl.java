package com.iwh.bpr.service;

import com.iwh.bpr.dao.CompetitorDao;

public class CompetitorServiceImpl implements CompetitorService {
	
	CompetitorDao competitorDao;

	public CompetitorDao getCompetitorDao() {
		return competitorDao;
	}

	public void setCompetitorDao(CompetitorDao competitorDao) {
		this.competitorDao = competitorDao;
	}

	@Override
	public String findCompetitors(String typOfService) {
		return competitorDao.findCompetitors(typOfService);
	}

	

}
