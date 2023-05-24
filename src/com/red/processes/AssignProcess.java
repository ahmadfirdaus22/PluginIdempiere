package com.red.processes;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.sql.Timestamp;

import org.compiere.process.ProcessInfoParameter;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

import com.red.models.MAssetAssignment;
import com.red.models.MAssetAssignmentLine;
import org.compiere.model.MAsset;
import org.compiere.model.MUser;


public class AssignProcess extends SvrProcess{
	private int userId;
	private int assetId;
	private int activityId;
	private int locationId;
	private Timestamp date;
	private String docname;
	 
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
		ProcessInfoParameter[] paras = getParameter();
		for(ProcessInfoParameter para: paras) {
			String paraName = para.getParameterName();
			if(paraName.equalsIgnoreCase("AD_User_ID")) {
				userId = para.getParameterAsInt();
			}else if(paraName.equalsIgnoreCase("A_Asset_ID")) {
				assetId = para.getParameterAsInt();
			}else if(paraName.equalsIgnoreCase("C_Activity_ID")) {
				activityId = para.getParameterAsInt();
			}else if(paraName.equalsIgnoreCase("C_Location_ID")) {
				locationId = para.getParameterAsInt();
			}else if(paraName.equalsIgnoreCase("Name")) {
				docname = para.getParameterAsString();
			}
			else {
				log.log(Level.SEVERE, "Unknown Parameter "+ paraName);
			}
		}
	}
	
	@Override
	protected String doIt() throws Exception{
		// TODO Auto-generated method stub
		MAsset asset = new MAsset(null, assetId, null);
		MUser user = new MUser(null, userId, null);
		MAssetAssignment assignment = new MAssetAssignment(Env.getCtx(),0,null);
		MAssetAssignmentLine line = new MAssetAssignmentLine(Env.getCtx(), 0, null);
		Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		
		addLog("Assign Asset");
		addLog(getProcessInfo().getAD_Process_ID(), 
				date, 
				new BigDecimal(getProcessInfo().getAD_User_ID()), 
				"Assign User : " + asset.getAD_User());
		addLog(getProcessInfo().getAD_Process_ID(), 
				date, 
				new BigDecimal(getProcessInfo().getAD_User_ID()),
				"Asset : " + asset.getName());
		
		
		try {				
			asset.setAD_User_ID(userId);
			asset.saveEx();
			
			assignment.setC_DocType_ID(1000000);
			assignment.setC_DocTypeTarget_ID(1000000);
			assignment.setName(docname);
			assignment.setAssignment_Date(new Timestamp(System.currentTimeMillis()));
			assignment.setisAssigned(true);
			assignment.setIsApproved(true);
			assignment.saveEx();

			line.setA_Asset_ID(assetId);
			line.setC_Activity_ID(activityId);
			line.setC_Location_ID(locationId);
			line.setAD_Org_ID(user.getAD_Org_ID());
			line.setAD_User_ID(userId);
			line.setred_asset_assignment_ID(assignment.get_ID());
			line.saveEx();
			
			assignment.completeIt();
			assignment.saveEx();
			
		}catch(Exception e) {
			// TODO: handle exception
			
			throw new AdempiereException(e);
		}
		
		return "Assign Sucess";
	}
}