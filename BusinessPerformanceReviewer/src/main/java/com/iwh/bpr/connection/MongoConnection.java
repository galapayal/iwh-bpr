package com.iwh.bpr.connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.iwh.bpr.codecs.BalanceSheetCodec;
import com.iwh.bpr.codecs.CompanyInfoCodec;
import com.iwh.bpr.codecs.ProfitLossNoteCodec;
import com.iwh.bpr.config.ApplicationConfig;
import com.iwh.bpr.utilities.AppConstants;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public enum MongoConnection {

	INSTANCE;
	private MongoDatabase mongoDataBase;

	public MongoDatabase getMongoDataBase() {
		return mongoDataBase;
	}

private MongoConnection(){
	Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);

	CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
			CodecRegistries.fromCodecs(new CompanyInfoCodec(defaultDocumentCodec), new BalanceSheetCodec(defaultDocumentCodec), new ProfitLossNoteCodec(defaultDocumentCodec)));

	MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry)
			.build();
	setMongoDataBase(options);
}
	private void setMongoDataBase(MongoClientOptions options) {

		List<ServerAddress> seeds = new ArrayList<ServerAddress>();

		ApplicationConfig appConfig = new ApplicationConfig();

		String dbname = appConfig.getDbProperty(AppConstants.DBNAME);

		String username = appConfig.getDbProperty(AppConstants.USERNAME);
		String password = appConfig.getDbProperty(AppConstants.PASSWORD);
		String host = appConfig.getDbProperty(AppConstants.HOST);
		int port = Integer.parseInt(appConfig.getDbProperty(AppConstants.PORT));

		seeds.add(new ServerAddress(host, port));

		List<MongoCredential> credentials = new ArrayList<MongoCredential>();

		MongoCredential cred = MongoCredential.createCredential(username, dbname, password.toCharArray());
		credentials = Arrays.asList(cred);

		if (credentials != null) {
		 mongoDataBase = new MongoClient(seeds, credentials, options).getDatabase(dbname);
		}
		else {
			mongoDataBase = new MongoClient(seeds, options).getDatabase(dbname);
		}

	}

	
}
