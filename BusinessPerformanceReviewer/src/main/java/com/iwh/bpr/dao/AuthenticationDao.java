package com.iwh.bpr.dao;

import java.util.Iterator;

import com.iwh.bpr.connection.Collections;
import com.iwh.bpr.connection.MongoConnection;
import com.iwh.bpr.model.CompanyInfo;
import com.iwh.bpr.utilities.AppConstants;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class AuthenticationDao {

	MongoCollection<CompanyInfo> userDetailsCollection = MongoConnection.INSTANCE.getMongoDataBase()
			.getCollection(String.valueOf(Collections.companyinfo), CompanyInfo.class);
	
	public CompanyInfo authenticateuser(CompanyInfo companyInfo) {

		
		FindIterable<CompanyInfo> findIterable = userDetailsCollection.find(Filters.and(Filters.eq(AppConstants.USERNAME, companyInfo.getUsername()),Filters.eq(AppConstants.PASSWORD, companyInfo.getPassword())));	
		Iterator<CompanyInfo> iterator = findIterable.iterator();
		if (iterator.hasNext()) {
			 companyInfo = (CompanyInfo) iterator.next();
			 companyInfo.setMessage(AppConstants.LOGGEDIN);
		}else{
			companyInfo.setMessage(AppConstants.INVALIDUSER);
		}
		return companyInfo;
	}

	
	public void logoutUser(String userId) {
		
		
	}
	
	public void addCompanyInfo(CompanyInfo companyInfo) {

		userDetailsCollection.insertOne(companyInfo);
	}

}
