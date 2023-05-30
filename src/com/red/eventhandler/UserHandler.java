package com.red.eventhandler;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.I_AD_User;
import org.compiere.model.MClient;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.osgi.service.event.Event;





public class UserHandler extends AbstractEventHandler{

	private int userID;
	private String pass;
	
	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub
		
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		if(event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			PO po = getPO(event);
			if(po instanceof MUser) {
				MUser user = (MUser) po;
				userID = user.get_ID();
				pass = po.get_Attribute("Password").toString();
				user.setPassword(pass.substring(1, pass.length()-1 ));
				user.save();
			}
		}
		
		executorService.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MUserRoles role = new MUserRoles(Env.getCtx(), 0, null);
				role.setAD_User_ID(userID);
				role.setAD_Role_ID(102);
				role.saveEx();
			}
		}, 1, TimeUnit.SECONDS);
			
	    executorService.shutdown();
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_AD_User.Table_Name);
		}

	
}
