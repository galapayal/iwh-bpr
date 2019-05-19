package com.iwh.bpr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.iwh.bpr.model.CompanyInfo;
import com.iwh.bpr.service.AuthenticationService;
import com.iwh.bpr.utilities.AppConstants;

@Controller
public class Authenticationcontroller {

	@Autowired
	private AuthenticationService authenticationService;

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@RequestMapping(value = "doLogin",method = RequestMethod.POST)
	public void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String responseJsonString = AppConstants.EMPTY_STRING;
		Gson gson = new Gson();

		CompanyInfo companyInfo  = new CompanyInfo();
		companyInfo.setUsername(request.getParameter("username"));
		companyInfo.setPassword(request.getParameter("password"));

		
		
		companyInfo = authenticationService.authenticateuser(companyInfo);

		

		request.getSession().setAttribute(AppConstants.USER, companyInfo);
		System.out.println(request.getSession().getAttribute(AppConstants.USER));
		response.setContentType(AppConstants.CONTENT_TYPE_JSON);
		responseJsonString = gson.toJson(companyInfo);
		response.getWriter().println(responseJsonString);
	}
	
	@RequestMapping(value = "doLogOut",method = RequestMethod.POST)
	public void processLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String responseJsonString = AppConstants.EMPTY_STRING;

		request.getSession().removeAttribute(AppConstants.USER);
		
		
		response.getWriter().println(responseJsonString);
	}
	@RequestMapping(value = "addUser", produces = "application/json")
	public void processUserDetails(@RequestBody CompanyInfo companyInfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String responseJsonString = AppConstants.EMPTY_STRING;
		Gson gson = new Gson();

	

		
		
		authenticationService.addCompanyInfo(companyInfo);

		

		request.getSession().setAttribute(AppConstants.USER, companyInfo);
		response.setContentType(AppConstants.CONTENT_TYPE_JSON);
		responseJsonString = gson.toJson(companyInfo);
		response.getWriter().println(responseJsonString);
	}
}
