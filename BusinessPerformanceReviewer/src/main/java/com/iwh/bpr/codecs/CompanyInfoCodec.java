package com.iwh.bpr.codecs;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import com.iwh.bpr.model.CompanyInfo;
import com.iwh.bpr.model.CompanyInfo.ComapnyDetails;

public class CompanyInfoCodec implements CollectibleCodec<CompanyInfo> {

	private Codec<Document> documentCodec;

	public CompanyInfoCodec(Codec<Document> documentCodec) {
		super();
		this.documentCodec = documentCodec;
	}

	@Override
	public void encode(BsonWriter writer, CompanyInfo value, EncoderContext encoderContext) {
		Document document = new Document();
		if (value.getUsername() != null && !value.getUsername().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.username), value.getUsername());
		}
		if (value.getPassword() != null && !value.getPassword().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.password), value.getPassword());
		}
		if (value.getCompAdd() != null && !value.getCompAdd().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.companyAddress), value.getCompAdd());
		}
		if (value.getCompContactNumber() != 0) {
			document.append(String.valueOf(ComapnyDetails.companyContactInfo), value.getCompContactNumber());
		}
		if (value.getCompMailId() != null && !value.getCompMailId().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.comapnyMailId), value.getCompMailId());
		}
		if (value.getCompName() != null && !value.getCompName().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.companyName), value.getCompName());
		}
		if (value.getTypeOfService() != null && !value.getTypeOfService().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.typeOfService), value.getTypeOfService());
		}
		if (value.getEmployeeCount() != 0) {
			document.append(String.valueOf(ComapnyDetails.employeeCount), value.getEmployeeCount());
		}
		documentCodec.encode(writer, document, encoderContext);

	}

	@Override
	public Class<CompanyInfo> getEncoderClass() {
		return CompanyInfo.class;
	}

	@Override
	public CompanyInfo decode(BsonReader reader, DecoderContext decoderContext) {
		CompanyInfo companyInfo = new CompanyInfo();
		Document document = documentCodec.decode(reader, decoderContext);
		companyInfo.setUsername(document.getString(String.valueOf(ComapnyDetails.username)));
		companyInfo.setPassword(document.getString(String.valueOf(ComapnyDetails.password)));
		companyInfo.setCompAdd(document.getString(String.valueOf(ComapnyDetails.companyAddress)));
		companyInfo.setCompContactNumber(document.getLong(String.valueOf(ComapnyDetails.companyContactInfo)));
		companyInfo.setEmployeeCount(document.getInteger(String.valueOf(ComapnyDetails.employeeCount)));
		companyInfo.setCompName(document.getString(String.valueOf(ComapnyDetails.companyName)));
		companyInfo.setTypeOfService(document.getString(String.valueOf(ComapnyDetails.typeOfService)));
		companyInfo.setCompMailId(document.getString(String.valueOf(ComapnyDetails.comapnyMailId)));
		return companyInfo;
	}

	@Override
	public CompanyInfo generateIdIfAbsentFromDocument(CompanyInfo document) {
		return document;
	}

	@Override
	public boolean documentHasId(CompanyInfo document) {
		return document.getUsername() == null;
	}

	@Override
	public BsonValue getDocumentId(CompanyInfo document) {
		return new BsonString(document.getUsername());
	}

}
