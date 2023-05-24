package com.red.models;

import java.util.Properties;
import java.sql.ResultSet;

import com.red.models.X_RED_Asset_Assignment_Line;

public class MAssetAssignmentLine extends X_RED_Asset_Assignment_Line {

	
	private static final long serialVersionUID = -1194831618045580442L;

	public MAssetAssignmentLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MAssetAssignmentLine(Properties ctx, int RES_Asset_Assignment_Line_ID, String trxName) {
		super(ctx, RES_Asset_Assignment_Line_ID, trxName);
		// TODO Auto-generated constructor stub
	}

}
