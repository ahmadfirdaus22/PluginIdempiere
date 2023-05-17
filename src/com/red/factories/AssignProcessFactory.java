package com.red.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;
import com.red.processes.AssignProcess;

public class AssignProcessFactory implements IProcessFactory{
	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		
		if(className.equals("com.red.AssignProcess")) {
			return new AssignProcess();
		}
		
		return null;
	}
}