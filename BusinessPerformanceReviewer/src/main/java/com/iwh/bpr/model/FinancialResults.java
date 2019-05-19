package com.iwh.bpr.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class FinancialResults implements Bson {

	public enum FinancialResult {
		year, profit, wcRatio, roa, roe, der, currency, currencyType;
	}

	private ObjectId oId;
	private List<Integer> year;
	private Map<Integer, Double> profit;

	private Map<Integer, Double> wcRatio;
	private Map<Integer, Double> roa;
	private Map<Integer, Double> roe;
	private Map<Integer, Double> der;
	private String currency;
	private String currencyType;

	public FinancialResults() {
		super();
		this.profit = new HashMap<Integer, Double>();
		this.wcRatio = new HashMap<Integer, Double>();
		this.roa = new HashMap<Integer, Double>();
		this.roe = new HashMap<Integer, Double>();
		this.der = new HashMap<Integer, Double>();
	}

	public ObjectId getoId() {
		return oId;
	}

	public void setoId(ObjectId oId) {
		this.oId = oId;
	}



	public List<Integer> getYear() {
		return year;
	}

	public void setYear(List<Integer> year) {
		this.year = year;
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

	

	public Map<Integer, Double> getProfit() {
		return profit;
	}

	public Map<Integer, Double> getWcRatio() {
		return wcRatio;
	}

	public Map<Integer, Double> getRoa() {
		return roa;
	}

	public Map<Integer, Double> getRoe() {
		return roe;
	}

	public Map<Integer, Double> getDer() {
		return der;
	}

	@Override
	public String toString() {
		return "FinancialResults [oId=" + oId + ", year=" + year + ", profit=" + profit + ", wcRatio=" + wcRatio
				+ ", roa=" + roa + ", roe=" + roe + ", der=" + der + ", currency=" + currency + ", currencyType="
				+ currencyType + "]";
	}

	@Override
	public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
		return new BsonDocumentWrapper<FinancialResults>(this, codecRegistry.get(FinancialResults.class));
	}

}
