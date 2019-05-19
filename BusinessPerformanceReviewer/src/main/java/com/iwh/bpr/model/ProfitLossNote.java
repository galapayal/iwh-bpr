package com.iwh.bpr.model;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ProfitLossNote implements Bson {

	public enum ProfitLossNotes {
		_id, softServnprodCost, otherIncome, empBenefitexpenses, defacquisition, subContractorsCost, travelExpenses, softackagesCosts, comExpenses, profCharges, deprecnAmortxpense, expense, currentTax, defTax, currency, currencyType, year;
	}

	private ObjectId oId;
	private long softServnprodCost;
	private long otherIncome;
	private long empBenefitexpenses;
	private long defacquisition;
	private long subContractorsCost;
	private long travelExpenses;
	private long softackagesCosts;
	private long comExpenses;
	private long profCharges;
	private long deprecnAmortxpense;
	private long expense;
	private long currentTax;
	private long defTax;
	private String currency;
	private String currencyType;
	private int year;
	private String compName;


	@Override
	public String toString() {
		return "ProfitLossNote [oId=" + oId + ", softServnprodCost=" + softServnprodCost + ", otherIncome="
				+ otherIncome + ", empBenefitexpenses=" + empBenefitexpenses + ", defacquisition=" + defacquisition
				+ ", subContractorsCost=" + subContractorsCost + ", travelExpenses=" + travelExpenses
				+ ", softackagesCosts=" + softackagesCosts + ", comExpenses=" + comExpenses + ", profCharges="
				+ profCharges + ", deprecnAmortxpense=" + deprecnAmortxpense + ", expense=" + expense + ", currentTax="
				+ currentTax + ", defTax=" + defTax + ", currency=" + currency + ", currencyType=" + currencyType
				+ ", year=" + year + ", compName=" + compName + "]";
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public ObjectId getoId() {
		return oId;
	}

	public void setoId(ObjectId oId) {
		this.oId = oId;
	}

	public String getCurrency() {
		return currency;
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

	public long getSoftServnprodCost() {
		return softServnprodCost;
	}

	public void setSoftServnprodCost(long softServnprodCost) {
		this.softServnprodCost = softServnprodCost;
	}

	public long getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(long otherIncome) {
		this.otherIncome = otherIncome;
	}

	public long getEmpBenefitexpenses() {
		return empBenefitexpenses;
	}

	public void setEmpBenefitexpenses(long empBenefitexpenses) {
		this.empBenefitexpenses = empBenefitexpenses;
	}

	public long getDefacquisition() {
		return defacquisition;
	}

	public void setDefacquisition(long defacquisition) {
		this.defacquisition = defacquisition;
	}

	public long getSubContractorsCost() {
		return subContractorsCost;
	}

	public void setSubContractorsCost(long subContractorsCost) {
		this.subContractorsCost = subContractorsCost;
	}

	public long getTravelExpenses() {
		return travelExpenses;
	}

	public void setTravelExpenses(long travelExpenses) {
		this.travelExpenses = travelExpenses;
	}

	public long getSoftackagesCosts() {
		return softackagesCosts;
	}

	public void setSoftackagesCosts(long softackagesCosts) {
		this.softackagesCosts = softackagesCosts;
	}

	public long getComExpenses() {
		return comExpenses;
	}

	public void setComExpenses(long comExpenses) {
		this.comExpenses = comExpenses;
	}

	public long getProfCharges() {
		return profCharges;
	}

	public void setProfCharges(long profCharges) {
		this.profCharges = profCharges;
	}

	public long getDeprecnAmortxpense() {
		return deprecnAmortxpense;
	}

	public void setDeprecnAmortxpense(long deprecnAmortxpense) {
		this.deprecnAmortxpense = deprecnAmortxpense;
	}

	public long getExpense() {
		return expense;
	}

	public void setExpense(long expense) {
		this.expense = expense;
	}

	public long getCurrentTax() {
		return currentTax;
	}

	public void setCurrentTax(long currentTax) {
		this.currentTax = currentTax;
	}

	public long getDefTax() {
		return defTax;
	}

	public void setDefTax(long defTax) {
		this.defTax = defTax;
	}

	@Override
	public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
		return new BsonDocumentWrapper<ProfitLossNote>(this, codecRegistry.get(ProfitLossNote.class));
	}

}
