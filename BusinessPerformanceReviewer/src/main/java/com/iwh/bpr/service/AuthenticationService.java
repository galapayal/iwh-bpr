package com.iwh.bpr.service;

import com.iwh.bpr.model.CompanyInfo;

public interface AuthenticationService {

	public CompanyInfo authenticateuser(CompanyInfo companyInfo);
	
	
	public void addCompanyInfo(CompanyInfo details);
}
