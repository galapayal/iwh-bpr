package com.iwh.bpr.model;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

public class CompanyInfo implements Bson {

	public enum ComapnyDetails {
		companyName, companyAddress, comapnyMailId, companyContactInfo, employeeCount, username, password, typeOfService;
	}

	private String compName;
	private String compAdd;
	private String compMailId;
	private long compContactNumber;
	private int employeeCount;
	private String username;
	private String password;
	private String message;
	private String typeOfService;

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompAdd() {
		return compAdd;
	}

	public void setCompAdd(String compAdd) {
		this.compAdd = compAdd;
	}

	public String getCompMailId() {
		return compMailId;
	}

	public void setCompMailId(String compMailId) {
		this.compMailId = compMailId;
	}

	public long getCompContactNumber() {
		return compContactNumber;
	}

	public void setCompContactNumber(long compContactNumber) {
		this.compContactNumber = compContactNumber;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CompanyInfo [compName=" + compName + ", compAdd=" + compAdd + ", compMailId=" + compMailId
				+ ", compContactNumber=" + compContactNumber + ", employeeCount=" + employeeCount + ", username="
				+ username + ", password=" + password + ", message=" + message + ", typeOfService=" + typeOfService
				+ "]";
	}

	@Override
	public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
		return new BsonDocumentWrapper<CompanyInfo>(this, codecRegistry.get(CompanyInfo.class));
	}

}
