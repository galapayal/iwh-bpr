package com.iwh.bpr.dao;

import com.iwh.bpr.model.BalanceSheet;
import com.iwh.bpr.model.FinancialResults;
import com.iwh.bpr.model.ProfitLossNote;

public interface FinancialDao {
	public void addBalanceSheetdata(BalanceSheet balancesheet);

	public void addProfitLossNote(ProfitLossNote profitLossNote);
	
	public FinancialResults calculateFinanceResult(String compName);
}
