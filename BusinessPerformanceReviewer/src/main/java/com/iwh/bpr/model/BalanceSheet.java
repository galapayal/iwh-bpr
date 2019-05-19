package com.iwh.bpr.model;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class BalanceSheet implements Bson {

	public enum Balancesheet {
		_id, shareCapital, reservesnSurplus, DefTaxLiabilities, longTermLiabilities, tradePayables, currentLiabilities, shortTermProvisions, tangibleAssets, intangibleAssets, capitalWIP, nCurrentInvestments, defTaxAssets, longTermLoansnAdvances, ncurrentAssets, currentInvestments, tradeReceivables, cashEqui, shortTermLoansnAdvances, currency, currencyType, year;
	}

	private ObjectId oId;
	private long shareCapital;
	private long reservesnSurplus;
	private long DefTaxLiabilities;
	private long longTermLiabilities;
	private long tradePayables;
	private long currentLiabilities;
	private long shortTermProvisions;
	private long tangibleAssets;
	private long intangibleAssets;
	private long capitalWIP;
	private long nCurrentInvestments;
	private long defTaxAssets;
	private long longTermLoansnAdvances;
	private long ncurrentAssets;
	private long currentInvestments;
	private long tradeReceivables;
	private long cashEqui;
	private long shortTermLoansnAdvances;
	private String currency;
	private String currencyType;
	private int year;
	private String compName;


	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCurrency() {
		return currency;
	}


	public ObjectId getoId() {
		return oId;
	}

	public void setoId(ObjectId oId) {
		this.oId = oId;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getShareCapital() {
		return shareCapital;
	}

	public void setShareCapital(long shareCapital) {
		this.shareCapital = shareCapital;
	}

	public long getReservesnSurplus() {
		return reservesnSurplus;
	}

	public void setReservesnSurplus(long reservesnSurplus) {
		this.reservesnSurplus = reservesnSurplus;
	}

	public long getDefTaxLiabilities() {
		return DefTaxLiabilities;
	}

	public void setDefTaxLiabilities(long defTaxLiabilities) {
		DefTaxLiabilities = defTaxLiabilities;
	}

	public long getLongTermLiabilities() {
		return longTermLiabilities;
	}

	public void setLongTermLiabilities(long longTermLiabilities) {
		this.longTermLiabilities = longTermLiabilities;
	}

	public long getTradePayables() {
		return tradePayables;
	}

	public void setTradePayables(long tradePayables) {
		this.tradePayables = tradePayables;
	}

	public long getCurrentLiabilities() {
		return currentLiabilities;
	}

	public void setCurrentLiabilities(long currentLiabilities) {
		this.currentLiabilities = currentLiabilities;
	}

	public long getShortTermProvisions() {
		return shortTermProvisions;
	}

	public void setShortTermProvisions(long shortTermProvisions) {
		this.shortTermProvisions = shortTermProvisions;
	}

	public long getTangibleAssets() {
		return tangibleAssets;
	}

	public void setTangibleAssets(long tangibleAssets) {
		this.tangibleAssets = tangibleAssets;
	}

	public long getIntangibleAssets() {
		return intangibleAssets;
	}

	public void setIntangibleAssets(long intangibleAssets) {
		this.intangibleAssets = intangibleAssets;
	}

	public long getCapitalWIP() {
		return capitalWIP;
	}

	public void setCapitalWIP(long capitalWIP) {
		this.capitalWIP = capitalWIP;
	}

	public long getnCurrentInvestments() {
		return nCurrentInvestments;
	}

	public void setnCurrentInvestments(long nCurrentInvestments) {
		this.nCurrentInvestments = nCurrentInvestments;
	}

	public long getDefTaxAssets() {
		return defTaxAssets;
	}

	public void setDefTaxAssets(long defTaxAssets) {
		this.defTaxAssets = defTaxAssets;
	}

	public long getLongTermLoansnAdvances() {
		return longTermLoansnAdvances;
	}

	public void setLongTermLoansnAdvances(long longTermLoansnAdvances) {
		this.longTermLoansnAdvances = longTermLoansnAdvances;
	}

	public long getNcurrentAssets() {
		return ncurrentAssets;
	}

	public void setNcurrentAssets(long ncurrentAssets) {
		this.ncurrentAssets = ncurrentAssets;
	}

	public long getCurrentInvestments() {
		return currentInvestments;
	}

	public void setCurrentInvestments(long currentInvestments) {
		this.currentInvestments = currentInvestments;
	}

	public long getTradeReceivables() {
		return tradeReceivables;
	}

	public void setTradeReceivables(long tradeReceivables) {
		this.tradeReceivables = tradeReceivables;
	}

	public long getCashEqui() {
		return cashEqui;
	}

	public void setCashEqui(long cashEqui) {
		this.cashEqui = cashEqui;
	}

	public long getShortTermLoansnAdvances() {
		return shortTermLoansnAdvances;
	}

	public void setShortTermLoansnAdvances(long shortTermLoansnAdvances) {
		this.shortTermLoansnAdvances = shortTermLoansnAdvances;
	}

	@Override
	public String toString() {
		return "BalanceSheet [oId=" + oId + ", shareCapital=" + shareCapital + ", reservesnSurplus=" + reservesnSurplus
				+ ", DefTaxLiabilities=" + DefTaxLiabilities + ", longTermLiabilities=" + longTermLiabilities
				+ ", tradePayables=" + tradePayables + ", currentLiabilities=" + currentLiabilities
				+ ", shortTermProvisions=" + shortTermProvisions + ", tangibleAssets=" + tangibleAssets
				+ ", intangibleAssets=" + intangibleAssets + ", capitalWIP=" + capitalWIP + ", nCurrentInvestments="
				+ nCurrentInvestments + ", defTaxAssets=" + defTaxAssets + ", longTermLoansnAdvances="
				+ longTermLoansnAdvances + ", ncurrentAssets=" + ncurrentAssets + ", currentInvestments="
				+ currentInvestments + ", tradeReceivables=" + tradeReceivables + ", cashEqui=" + cashEqui
				+ ", shortTermLoansnAdvances=" + shortTermLoansnAdvances + ", currency=" + currency + ", currencyType="
				+ currencyType + ", year=" + year + ", compName=" + compName + "]";
	}

	@Override
	public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
		return new BsonDocumentWrapper<BalanceSheet>(this, codecRegistry.get(BalanceSheet.class));
	}

}
