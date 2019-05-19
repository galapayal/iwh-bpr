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
import com.iwh.bpr.model.BalanceSheet;
import com.iwh.bpr.model.FinancialResults;
import com.iwh.bpr.model.ProfitLossNote;
import com.iwh.bpr.service.FinancialService;
import com.iwh.bpr.utilities.AppConstants;

@Controller
public class FinancialController {

	@Autowired
	private FinancialService financialService;

	public FinancialService getFinancialService() {
		return financialService;
	}

	public void setFinancialService(FinancialService financialService) {
		this.financialService = financialService;
	}

	@RequestMapping(value = "addBalanceSheet", method = RequestMethod.POST)
	public void processLogin(@RequestBody BalanceSheet balanceSheet, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String responseJsonString = AppConstants.EMPTY_STRING;
		Gson gson = new Gson();

		financialService.addBalanceSheetdata(balanceSheet);

		response.setContentType(AppConstants.CONTENT_TYPE_JSON);
		responseJsonString = gson.toJson(balanceSheet);
		response.getWriter().println(responseJsonString);
	}

	@RequestMapping(value = "addProftLossnote", method = RequestMethod.POST)
	public void processLogin(@RequestBody ProfitLossNote profitLossNote, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String responseJsonString = AppConstants.EMPTY_STRING;
		Gson gson = new Gson();

		financialService.addProfitLossNote(profitLossNote);
		
		response.setContentType(AppConstants.CONTENT_TYPE_JSON);
		responseJsonString = gson.toJson(profitLossNote);
		response.getWriter().println(responseJsonString);
	}
	
	@RequestMapping(value = "calculateFinanceResult")
	public void processFinanceData(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String responseJsonString = AppConstants.EMPTY_STRING;
		Gson gson = new Gson();

		String comName = request.getParameter("compName");
		FinancialResults financialResults = financialService.calculateFinanceResult(comName);
		response.setContentType(AppConstants.CONTENT_TYPE_JSON);
		responseJsonString = gson.toJson(financialResults);
		response.getWriter().println(responseJsonString);
	}

}
