package com.red.models;

import java.util.Properties;
import java.sql.ResultSet;

import com.red.models.X_RED_asset_assignment;

public class MAssetAssignment extends X_RED_asset_assignment{

	private static final long serialVersionUID = -3034966949748143108L;

	public MAssetAssignment(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MAssetAssignment(Properties ctx, int RED_asset_assignment_ID, String trxName) {
		super(ctx, RED_asset_assignment_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		// TODO Auto-generated constructor stub
		return super.beforeSave(newRecord);
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		// TODO Auto-generated method stub
		return super.afterSave(newRecord, success);
	}
	
	@Override
	protected boolean beforeDelete() {
		// TODO Auto-generated method stub
		return super.beforeDelete();
	}
	
	@Override
	protected boolean afterDelete(boolean success) {
		// TODO Auto-generated method stub
		return super.afterDelete(success);
	}
	
}
