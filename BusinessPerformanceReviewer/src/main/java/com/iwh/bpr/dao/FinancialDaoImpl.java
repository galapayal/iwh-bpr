package com.iwh.bpr.dao;

import java.util.ArrayList;
import java.util.List;

import com.iwh.bpr.connection.Collections;
import com.iwh.bpr.connection.MongoConnection;
import com.iwh.bpr.model.BalanceSheet;
import com.iwh.bpr.model.CompanyInfo.ComapnyDetails;
import com.iwh.bpr.model.FinancialResults;
import com.iwh.bpr.model.ProfitLossNote;
import com.iwh.bpr.utilities.AppConstants;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class FinancialDaoImpl implements FinancialDao {

	MongoCollection<BalanceSheet> mongoBalanceSheetCollection = MongoConnection.INSTANCE.getMongoDataBase()
			.getCollection(String.valueOf(Collections.balanceSheet), BalanceSheet.class);

	MongoCollection<ProfitLossNote> mongoProfitLossNoteCollection = MongoConnection.INSTANCE.getMongoDataBase()
			.getCollection(String.valueOf(Collections.profitLossNote), ProfitLossNote.class);

	/*
	 * This method is used to insert balance sheet data to database, which will
	 * be process further for Financial Performance Analysis
	 */
	@Override
	public void addBalanceSheetdata(BalanceSheet balancesheet) {
		mongoBalanceSheetCollection.insertOne(balancesheet);
	}

	/*
	 * This method is used to insert Profit and Loss sheet data to database,
	 * which will be process further for Financial Performance Analysis
	 */
	@Override
	public void addProfitLossNote(ProfitLossNote profitLossNote) {
		mongoProfitLossNoteCollection.insertOne(profitLossNote);

	}

	/*
	 * This method is used to calculate and process profit, working capital
	 * ratio, return on assets, return on equity, debt equity ratio using
	 * balance sheet and profit Loss Note to visualize data in graphs for better
	 * understanding.
	 */
	@Override
	public FinancialResults calculateFinanceResult(String compName) {
		FinancialResults financialResults = new FinancialResults();

		List<Integer> years = new ArrayList<Integer>();
		ProfitLossNote profitLossNote;
		FindIterable<ProfitLossNote> iterable = mongoProfitLossNoteCollection
				.find(Filters.eq(String.valueOf(ComapnyDetails.companyName), compName));
		MongoCursor<ProfitLossNote> mongoCursor = iterable.iterator();
		while (mongoCursor.hasNext()) {
			profitLossNote = (ProfitLossNote) mongoCursor.next();
			financialResults.getProfit().put(profitLossNote.getYear(), calculateProfit(profitLossNote));
			financialResults.setCurrency(profitLossNote.getCurrency());
			financialResults.setCurrencyType(profitLossNote.getCurrencyType());
			years.add(profitLossNote.getYear());
		}

		BalanceSheet balanceSheet;
		FindIterable<BalanceSheet> findIterable = mongoBalanceSheetCollection
				.find(Filters.eq(String.valueOf(ComapnyDetails.companyName), compName));
		MongoCursor<BalanceSheet> cursor = findIterable.iterator();
		while (cursor.hasNext()) {
			balanceSheet = (BalanceSheet) cursor.next();

			ProfitLossNote plNote = (ProfitLossNote) mongoProfitLossNoteCollection
					.find(Filters.eq(AppConstants.YEAR, balanceSheet.getYear()), ProfitLossNote.class).first();
			financialResults.getRoa().put(balanceSheet.getYear(), calculateROA(balanceSheet, plNote));
			financialResults.getRoe().put(balanceSheet.getYear(), calculateROE(balanceSheet, plNote));
			financialResults.getWcRatio().put(balanceSheet.getYear(), calculateWCRatio(balanceSheet));
			financialResults.getDer().put(balanceSheet.getYear(), calculateDER(balanceSheet));
		}

		financialResults.setYear(years);
		
		return financialResults;
	}

	private double calculateDER(BalanceSheet balanceSheet) {

		List<Long> list = new ArrayList<Long>();

		list.add(balanceSheet.getShareCapital());
		list.add(balanceSheet.getReservesnSurplus());

		double shareholderFund = sum(list);

		list.clear();

		list.add(balanceSheet.getTradePayables());
		list.add(balanceSheet.getCurrentLiabilities());
		list.add(balanceSheet.getShortTermProvisions());
		double currentLiabilities = sum(list);

		list.clear();

		list.add(balanceSheet.getDefTaxLiabilities());
		list.add(balanceSheet.getLongTermLiabilities());

		double nonCurrentLiabilities = sum(list);
		double sum = shareholderFund + currentLiabilities + nonCurrentLiabilities;
		double der = sum / shareholderFund;
		return der;
	}

	private double calculateROE(BalanceSheet balanceSheet, ProfitLossNote profitLossNote) {

		List<Long> list = new ArrayList<Long>();
		list.add(balanceSheet.getShareCapital());
		list.add(balanceSheet.getReservesnSurplus());

		double shareholderFund = sum(list);

		double profit = calculateProfit(profitLossNote);

		double roe = profit / shareholderFund;
		return roe;
	}

	private double calculateROA(BalanceSheet balanceSheet, ProfitLossNote profitLossNote) {

		List<Long> list = new ArrayList<Long>();

		list.add(balanceSheet.getTangibleAssets());
		list.add(balanceSheet.getIntangibleAssets());
		list.add(balanceSheet.getCapitalWIP());
		list.add(balanceSheet.getnCurrentInvestments());
		list.add(balanceSheet.getDefTaxAssets());
		list.add(balanceSheet.getLongTermLoansnAdvances());
		list.add(balanceSheet.getNcurrentAssets());

		double nonCurrentAsset = sum(list);

		list.clear();

		list.add(balanceSheet.getCurrentInvestments());
		list.add(balanceSheet.getTradeReceivables());
		list.add(balanceSheet.getCashEqui());
		list.add(balanceSheet.getShortTermLoansnAdvances());

		double currentAssets = sum(list);

		double assets = nonCurrentAsset + currentAssets;

		double profit = calculateProfit(profitLossNote);
		double roa = profit / assets;
		return roa;
	}

	private double calculateWCRatio(BalanceSheet balanceSheet) {

		List<Long> list = new ArrayList<Long>();

		list.add(balanceSheet.getCurrentInvestments());
		list.add(balanceSheet.getTradeReceivables());
		list.add(balanceSheet.getCashEqui());
		list.add(balanceSheet.getShortTermLoansnAdvances());

		double currentAssets = sum(list);

		list.clear();

		list.add(balanceSheet.getTradePayables());
		list.add(balanceSheet.getCurrentLiabilities());
		list.add(balanceSheet.getShortTermProvisions());
		double currentLiabilities = sum(list);

		double wcRatio = currentAssets / currentLiabilities;
		return wcRatio;
	}

	private double calculateProfit(ProfitLossNote profitLossNote) {

		List<Long> list = new ArrayList<Long>();
		list.add(profitLossNote.getSoftServnprodCost());
		list.add(profitLossNote.getOtherIncome());
		double totRevenue = sum(list);

		list.clear();

		list.add(profitLossNote.getEmpBenefitexpenses());
		list.add(profitLossNote.getDefacquisition());
		list.add(profitLossNote.getSubContractorsCost());
		list.add(profitLossNote.getTravelExpenses());
		list.add(profitLossNote.getSoftackagesCosts());
		list.add(profitLossNote.getComExpenses());
		list.add(profitLossNote.getProfCharges());
		list.add(profitLossNote.getDeprecnAmortxpense());
		list.add(profitLossNote.getExpense());

		double totexpense = sum(list);

		double profitBefTax = totRevenue - totexpense;

		double tax = profitLossNote.getCurrentTax() + profitLossNote.getDefTax();

		double profit = profitBefTax - tax;

		return profit;

	}

	public static double sum(List<Long> list) {
		double sum = 0;
		for (Long i : list) {
			sum += i;
		}
		return sum;
	}

}
