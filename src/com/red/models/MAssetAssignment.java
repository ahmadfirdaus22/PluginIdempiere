package com.red.models;

import java.util.List;
import java.util.Properties;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.logging.Level;

import org.compiere.model.I_C_OrderLine;
import org.compiere.model.MOrderLine;
import org.compiere.model.Query;
import org.compiere.process.DocAction;

import com.red.models.X_RED_Asset_Assignment;
import com.red.models.MAssetAssignmentLine;

public class MAssetAssignment extends X_RED_Asset_Assignment implements DocAction {

	private static final long serialVersionUID = -3034966949748143108L;

	public MAssetAssignment(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MAssetAssignment(Properties ctx, int RES_Asset_Assignment_ID, String trxName) {
		super(ctx, RES_Asset_Assignment_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public List<MAssetAssignmentLine> getLines (String whereClause) {
		StringBuilder whereClauseFinal = new StringBuilder(MAssetAssignmentLine.COLUMNNAME_red_asset_assignment_ID+"=? ");
		List<MAssetAssignmentLine> list = new Query(getCtx(), I_RED_Asset_Assignment_Line.Table_Name, whereClauseFinal.toString(), get_TrxName())
											.setParameters(get_ID())
											.list();
	
		return list;
	}
	
	@Override
	public boolean processIt(String action) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlockIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean invalidateIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String prepareIt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String completeIt() {
		// TODO Auto-generated method stub
		setProcessed(true);
		
		setDocAction(DOCACTION_Close);
		setDocStatus(DOCSTATUS_Completed);
		return DocAction.STATUS_Completed;
	}

	@Override
	public boolean voidIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reverseCorrectIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reverseAccrualIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reActivateIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSummary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File createPDF() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProcessMsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDoc_User_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getC_Currency_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		// TODO Auto-generated method stub
		return null;
	}

}
