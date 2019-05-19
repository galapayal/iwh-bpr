package com.iwh.bpr.service;

import com.iwh.bpr.dao.AuthenticationDao;
import com.iwh.bpr.model.CompanyInfo;

public class AuthenticationServiceImpl implements AuthenticationService{

	private AuthenticationDao authenticationdao;
	
	
	public AuthenticationDao getAuthenticationdao() {
		return authenticationdao;
	}

	public void setAuthenticationdao(AuthenticationDao authenticationdao) {
		this.authenticationdao = authenticationdao;
	}

	@Override
	public CompanyInfo authenticateuser(CompanyInfo companyInfo) {
		return authenticationdao.authenticateuser(companyInfo);
		
	}

	

	@Override
	public void addCompanyInfo(CompanyInfo details) {

		 authenticationdao.addCompanyInfo(details);
	}


	
}
