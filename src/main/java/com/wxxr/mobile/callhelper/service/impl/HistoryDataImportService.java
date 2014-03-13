package com.wxxr.mobile.callhelper.service.impl;

import com.wxxr.mobile.callhelper.ICallHeplerAppContext;
import com.wxxr.mobile.callhelper.service.IHistoryDataImportService;
import com.wxxr.mobile.core.microkernel.api.AbstractModule;

/**
 * 
 * @author fudapeng
 *
 */
public class HistoryDataImportService extends AbstractModule<ICallHeplerAppContext> implements
		IHistoryDataImportService {

	@Override
	public boolean importHistroyData() {
		
		return false;
	}

	@Override
	public boolean isNeedImport() {
		
		return false;
	}

	@Override
	public void setNeedImport(boolean value) {
		

	}

	@Override
	protected void initServiceDependency() {
		
		
	}

	@Override
	protected void startService() {
		context.registerService(IHistoryDataImportService.class, this);
		
	}

	@Override
	protected void stopService() {
		
		
	}

}
