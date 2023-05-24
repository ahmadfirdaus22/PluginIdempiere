package com.red.eventhandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.MAsset;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.osgi.service.event.Event;

import com.red.models.I_RED_Asset_Assignment;
import com.red.models.I_RED_Asset_Assignment_Line;
import com.red.models.MAssetAssignment;
import com.red.models.MAssetAssignmentLine;

public class AssignHandler extends AbstractEventHandler{
	private int assetId;
	private int assignmentID;
	private int userId;
	
	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub
		if(event.getTopic().equals(IEventTopics.DOC_AFTER_COMPLETE)) {
			PO po = getPO(event);
			MAssetAssignment assignment = new MAssetAssignment(null, po.get_ID(), null);
			assignmentID = assignment.get_ID();
			try {
				Connection conn = DB.getConnection(); 
				String sql = "Select * from RED_Asset_Assignment_Line where red_asset_assignment_ID = ? ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, assignmentID);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					assetId = rs.getInt("A_Asset_ID");
					userId = rs.getInt("AD_User_ID");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MAsset asset = new MAsset(null, assetId, null);
			asset.setAD_User_ID(userId);
			asset.saveEx();
		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		registerTableEvent(IEventTopics.DOC_AFTER_COMPLETE,I_RED_Asset_Assignment.Table_Name);
	}
	
}