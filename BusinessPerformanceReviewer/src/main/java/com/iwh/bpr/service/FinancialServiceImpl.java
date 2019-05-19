package com.iwh.bpr.service;

import com.iwh.bpr.dao.FinancialDao;
import com.iwh.bpr.model.BalanceSheet;
import com.iwh.bpr.model.FinancialResults;
import com.iwh.bpr.model.ProfitLossNote;

public class FinancialServiceImpl implements FinancialService {

	private FinancialDao financialDao;

	public FinancialDao getFinancialDao() {
		return financialDao;
	}

	public void setFinancialDao(FinancialDao financialDao) {
		this.financialDao = financialDao;
	}

	@Override
	public void addBalanceSheetdata(BalanceSheet balancesheet) {
		financialDao.addBalanceSheetdata(balancesheet);
	}

	@Override
	public void addProfitLossNote(ProfitLossNote profitLossNote) {
		financialDao.addProfitLossNote(profitLossNote);
	}

	@Override
	public FinancialResults calculateFinanceResult(String compName) {
		return financialDao.calculateFinanceResult(compName);
	}

}
