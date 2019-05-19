package com.iwh.bpr.codecs;

import org.bson.BsonObjectId;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import com.iwh.bpr.model.BalanceSheet;
import com.iwh.bpr.model.BalanceSheet.Balancesheet;
import com.iwh.bpr.model.CompanyInfo.ComapnyDetails;

public class BalanceSheetCodec implements CollectibleCodec<BalanceSheet> {

	public static final String _ID = "_id";

	private Codec<Document> documentCodec;

	public BalanceSheetCodec(Codec<Document> documentCodec) {
		super();
		this.documentCodec = documentCodec;
	}

	@Override
	public void encode(BsonWriter writer, BalanceSheet value, EncoderContext encoderContext) {
		Document document = new Document();
		if (value.getoId() != null) {
			document.append(_ID, value.getoId());
		}
		document.append(String.valueOf(Balancesheet.shareCapital), value.getShareCapital());
		document.append(String.valueOf(Balancesheet.reservesnSurplus), value.getReservesnSurplus());
		document.append(String.valueOf(Balancesheet.DefTaxLiabilities), value.getDefTaxLiabilities());
		document.append(String.valueOf(Balancesheet.longTermLiabilities), value.getLongTermLiabilities());
		document.append(String.valueOf(Balancesheet.tradePayables), value.getTradePayables());
		document.append(String.valueOf(Balancesheet.currentLiabilities), value.getCurrentLiabilities());
		document.append(String.valueOf(Balancesheet.shortTermProvisions), value.getShortTermProvisions());
		document.append(String.valueOf(Balancesheet.tangibleAssets), value.getTangibleAssets());
		document.append(String.valueOf(Balancesheet.intangibleAssets), value.getIntangibleAssets());
		document.append(String.valueOf(Balancesheet.capitalWIP), value.getCapitalWIP());
		document.append(String.valueOf(Balancesheet.nCurrentInvestments), value.getnCurrentInvestments());
		document.append(String.valueOf(Balancesheet.defTaxAssets), value.getDefTaxAssets());
		document.append(String.valueOf(Balancesheet.longTermLoansnAdvances), value.getLongTermLoansnAdvances());
		document.append(String.valueOf(Balancesheet.ncurrentAssets), value.getNcurrentAssets());
		document.append(String.valueOf(Balancesheet.currentInvestments), value.getCurrentInvestments());
		document.append(String.valueOf(Balancesheet.tradeReceivables), value.getTradeReceivables());
		document.append(String.valueOf(Balancesheet.cashEqui), value.getCashEqui());
		document.append(String.valueOf(Balancesheet.shortTermLoansnAdvances), value.getShortTermLoansnAdvances());
		document.append(String.valueOf(Balancesheet.currency), value.getCurrency());
		document.append(String.valueOf(Balancesheet.currencyType), value.getCurrencyType());
		document.append(String.valueOf(Balancesheet.year), value.getYear());
		if (value.getCompName() != null && !value.getCompName().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.companyName), value.getCompName());
		}
		documentCodec.encode(writer, document, encoderContext);

	}

	@Override
	public Class<BalanceSheet> getEncoderClass() {
		return BalanceSheet.class;

	}

	@Override
	public BalanceSheet decode(BsonReader reader, DecoderContext decoderContext) {
		Document document = documentCodec.decode(reader, decoderContext);
		BalanceSheet balanceSheet = new BalanceSheet();
		balanceSheet.setoId(document.getObjectId(_ID));
		balanceSheet.setShareCapital(document.getLong(String.valueOf(Balancesheet.shareCapital)));
		balanceSheet.setDefTaxLiabilities(document.getLong(String.valueOf(Balancesheet.DefTaxLiabilities)));
		balanceSheet.setReservesnSurplus(document.getLong(String.valueOf(Balancesheet.reservesnSurplus)));
		balanceSheet.setLongTermLiabilities(document.getLong(String.valueOf(Balancesheet.longTermLiabilities)));
		balanceSheet.setTradePayables(document.getLong(String.valueOf(Balancesheet.tradePayables)));
		balanceSheet.setCurrentLiabilities(document.getLong(String.valueOf(Balancesheet.currentLiabilities)));
		balanceSheet.setShortTermProvisions(document.getLong(String.valueOf(Balancesheet.shortTermProvisions)));
		balanceSheet.setTangibleAssets(document.getLong(String.valueOf(Balancesheet.tangibleAssets)));
		balanceSheet.setIntangibleAssets(document.getLong(String.valueOf(Balancesheet.intangibleAssets)));
		balanceSheet.setCapitalWIP(document.getLong(String.valueOf(Balancesheet.capitalWIP)));
		balanceSheet.setnCurrentInvestments(document.getLong(String.valueOf(Balancesheet.nCurrentInvestments)));
		balanceSheet.setDefTaxAssets(document.getLong(String.valueOf(Balancesheet.defTaxAssets)));
		balanceSheet.setLongTermLoansnAdvances(document.getLong(String.valueOf(Balancesheet.longTermLoansnAdvances)));
		balanceSheet.setNcurrentAssets(document.getLong(String.valueOf(Balancesheet.ncurrentAssets)));
		balanceSheet.setCurrentInvestments(document.getLong(String.valueOf(Balancesheet.currentInvestments)));
		balanceSheet.setTradeReceivables(document.getLong(String.valueOf(Balancesheet.tradeReceivables)));
		balanceSheet.setCashEqui(document.getLong(String.valueOf(Balancesheet.cashEqui)));
		balanceSheet.setShortTermLoansnAdvances(document.getLong(String.valueOf(Balancesheet.shortTermLoansnAdvances)));
		balanceSheet.setCurrency(document.getString(String.valueOf(Balancesheet.currency)));
		balanceSheet.setCurrencyType(document.getString(String.valueOf(Balancesheet.currencyType)));
		balanceSheet.setYear(document.getInteger(String.valueOf(Balancesheet.year)));
		balanceSheet.setCompName(document.getString(String.valueOf(String.valueOf(ComapnyDetails.companyName))));

		return balanceSheet;
	}

	@Override
	public BalanceSheet generateIdIfAbsentFromDocument(BalanceSheet document) {
		if (!documentHasId(document)) {
			document.setoId(new ObjectId());
		}
		return document;
	}

	@Override
	public boolean documentHasId(BalanceSheet document) {
		return document.getoId() != null;
	}

	@Override
	public BsonValue getDocumentId(BalanceSheet document) {
		return new BsonObjectId(document.getoId());

	}

}
