package com.red.processes;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.sql.Timestamp;

import org.compiere.process.ProcessInfoParameter;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import org.compiere.model.MAsset;


public class AssignProcess extends SvrProcess{
	private int userId;
	private int assetId;
	private Timestamp date;
	
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
		}catch(Exception e) {
			// TODO: handle exception
		
			throw new AdempiereException(e);
		}
		
		return "Assign Sucess";
	}
}