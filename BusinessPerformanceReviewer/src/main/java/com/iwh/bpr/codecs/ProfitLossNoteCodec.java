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

import com.iwh.bpr.model.ProfitLossNote;
import com.iwh.bpr.model.CompanyInfo.ComapnyDetails;
import com.iwh.bpr.model.ProfitLossNote.ProfitLossNotes;

public class ProfitLossNoteCodec implements CollectibleCodec<ProfitLossNote> {
	public static final String _ID = "_id";

	private Codec<Document> documentCodec;

	public ProfitLossNoteCodec(Codec<Document> documentCodec) {
		super();
		this.documentCodec = documentCodec;
	}
	


	@Override
	public void encode(BsonWriter writer, ProfitLossNote value, EncoderContext encoderContext) {
		Document document = new Document();
		if (value.getoId() != null) {
			document.append(_ID, value.getoId());
		}

		document.append(String.valueOf(ProfitLossNotes.softServnprodCost), value.getSoftServnprodCost());
		document.append(String.valueOf(ProfitLossNotes.otherIncome), value.getOtherIncome());
		document.append(String.valueOf(ProfitLossNotes.empBenefitexpenses), value.getEmpBenefitexpenses());
		document.append(String.valueOf(ProfitLossNotes.defacquisition), value.getDefacquisition());
		document.append(String.valueOf(ProfitLossNotes.subContractorsCost), value.getSubContractorsCost());
		document.append(String.valueOf(ProfitLossNotes.travelExpenses), value.getTravelExpenses());
		document.append(String.valueOf(ProfitLossNotes.softackagesCosts), value.getSoftackagesCosts());
		document.append(String.valueOf(ProfitLossNotes.comExpenses), value.getComExpenses());
		document.append(String.valueOf(ProfitLossNotes.profCharges), value.getProfCharges());
		document.append(String.valueOf(ProfitLossNotes.deprecnAmortxpense), value.getDeprecnAmortxpense());
		document.append(String.valueOf(ProfitLossNotes.expense), value.getExpense());
		document.append(String.valueOf(ProfitLossNotes.currentTax), value.getCurrentTax());
		document.append(String.valueOf(ProfitLossNotes.defTax), value.getDefTax());
		document.append(String.valueOf(ProfitLossNotes.currency), value.getCurrency());
		document.append(String.valueOf(ProfitLossNotes.currencyType), value.getCurrencyType());
		document.append(String.valueOf(ProfitLossNotes.year), value.getYear());
		if (value.getCompName() != null && !value.getCompName().isEmpty()) {
			document.append(String.valueOf(ComapnyDetails.companyName), value.getCompName());
		}


		documentCodec.encode(writer, document, encoderContext);


	}

	@Override
	public Class<ProfitLossNote> getEncoderClass() {
		return ProfitLossNote.class;

	}

	@Override
	public ProfitLossNote decode(BsonReader reader, DecoderContext decoderContext) {
		Document document = documentCodec.decode(reader, decoderContext);
		ProfitLossNote profitLossNote = new ProfitLossNote();
		profitLossNote.setoId(document.getObjectId(_ID));
		
		profitLossNote.setSoftServnprodCost(document.getLong(String.valueOf(ProfitLossNotes.softServnprodCost)));
		profitLossNote.setOtherIncome(document.getLong(String.valueOf(ProfitLossNotes.otherIncome)));
		profitLossNote.setEmpBenefitexpenses(document.getLong(String.valueOf(ProfitLossNotes.empBenefitexpenses)));
		profitLossNote.setDefacquisition(document.getLong(String.valueOf(ProfitLossNotes.defacquisition)));
		profitLossNote.setSubContractorsCost(document.getLong(String.valueOf(ProfitLossNotes.subContractorsCost)));
		profitLossNote.setTravelExpenses(document.getLong(String.valueOf(ProfitLossNotes.travelExpenses)));
		profitLossNote.setSoftackagesCosts(document.getLong(String.valueOf(ProfitLossNotes.softackagesCosts)));
		profitLossNote.setComExpenses(document.getLong(String.valueOf(ProfitLossNotes.comExpenses)));
		profitLossNote.setProfCharges(document.getLong(String.valueOf(ProfitLossNotes.profCharges)));
		profitLossNote.setDeprecnAmortxpense(document.getLong(String.valueOf(ProfitLossNotes.deprecnAmortxpense)));
		profitLossNote.setExpense(document.getLong(String.valueOf(ProfitLossNotes.expense)));
		profitLossNote.setCurrentTax(document.getLong(String.valueOf(ProfitLossNotes.currentTax)));
		profitLossNote.setDefTax(document.getLong(String.valueOf(ProfitLossNotes.defTax)));
		profitLossNote.setCurrency(document.getString(String.valueOf(ProfitLossNotes.currency)));
		profitLossNote.setCurrencyType(document.getString(String.valueOf(ProfitLossNotes.currencyType)));
		profitLossNote.setYear(document.getInteger(String.valueOf(ProfitLossNotes.year)));
		profitLossNote.setCompName(document.getString(String.valueOf(ComapnyDetails.companyName)));

		return profitLossNote;
	}

	@Override
	public ProfitLossNote generateIdIfAbsentFromDocument(ProfitLossNote document) {
		if (!documentHasId(document)) {
			document.setoId(new ObjectId());
		}
		return document;
	}

	@Override
	public boolean documentHasId(ProfitLossNote document) {
		return document.getoId() != null;
	}

	@Override
	public BsonValue getDocumentId(ProfitLossNote document) {
		return new BsonObjectId(document.getoId());

	}

}
