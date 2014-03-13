/**
 * 
 */
package com.wxxr.mobile.callhelper.service.impl;

import com.wxxr.mobile.callhelper.ICallHeplerAppContext;
import com.wxxr.mobile.callhelper.app.model.SMSInfo;
import com.wxxr.mobile.callhelper.service.ISMSInterceptHandler;
import com.wxxr.mobile.callhelper.service.ISMSInterceptService;
import com.wxxr.mobile.core.microkernel.api.AbstractModule;

/**
 * @author fudapeng
 *
 */
public class SMSInterceptService extends AbstractModule<ICallHeplerAppContext> implements
		ISMSInterceptService {

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ISMSInterceptService#addInterceptHandle(com.wxxr.mobile.callhelper.service.ISMSInterceptHandler)
	 */
	@Override
	public void addInterceptHandle(ISMSInterceptHandler handler) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ISMSInterceptService#remoteInterceptHandle(com.wxxr.mobile.callhelper.service.ISMSInterceptHandler)
	 */
	@Override
	public void remoteInterceptHandle(ISMSInterceptHandler handler) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ISMSInterceptService#onReceive(com.wxxr.mobile.callhelper.app.model.SMSInfo)
	 */
	@Override
	public void onReceive(SMSInfo smsInfo) {
		

	}

	@Override
	protected void initServiceDependency() {
		
		
	}

	@Override
	protected void startService() {
		context.registerService(ISMSInterceptService.class, this);
		
	}

	@Override
	protected void stopService() {
		
		
	}

}
