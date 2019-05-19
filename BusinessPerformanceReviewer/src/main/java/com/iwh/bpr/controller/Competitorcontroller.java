package com.iwh.bpr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.iwh.bpr.model.CompanyInfo;
import com.iwh.bpr.service.CompetitorService;
import com.iwh.bpr.utilities.AppConstants;

@Controller
public class Competitorcontroller {
	@Autowired
	CompetitorService competitorService; 
	
	
	public CompetitorService getCompetitorService() {
		return competitorService;
	}


	public void setCompetitorService(CompetitorService competitorService) {
		this.competitorService = competitorService;
	}


	@RequestMapping(value = "findTopCompetitors")
	public void findCompetitors(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String responseJsonString = AppConstants.EMPTY_STRING;
		Gson gson = new Gson();
		String typeOfService = request.getParameter("query");

		
		
		String url = competitorService.findCompetitors(typeOfService);
		

		response.setContentType(AppConstants.CONTENT_TYPE_JSON);
		responseJsonString = gson.toJson(url);
		response.getWriter().println(responseJsonString);	}
	
	

}
