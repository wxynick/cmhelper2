/**
 * 
 */
package com.wxxr.mobile.callhelper.service.impl;

import java.util.List;

import com.wxxr.mobile.callhelper.ICallHeplerAppContext;
import com.wxxr.mobile.callhelper.app.model.SMSInfo;
import com.wxxr.mobile.callhelper.app.model.SMSSessionGroup;
import com.wxxr.mobile.callhelper.service.IMissCallService;
import com.wxxr.mobile.core.microkernel.api.AbstractModule;

/**
 * @author fudapeng
 *
 */
public class MissCallService extends AbstractModule<ICallHeplerAppContext> implements IMissCallService{

	@Override
	public void deleteMessage(Integer msgId) {
		
	}

	@Override
	public void deleteMessage(SMSInfo msg) {
		
	}

	@Override
	public void deleteMessageGroup(SMSSessionGroup msg) {
		
	}

	@Override
	public void deleteMessage(String number, boolean needfreshcache) {
		
	}

	@Override
	public int getAllUnreadSize() {
		return 0;
	}

	@Override
	public int getUnreadSizeOfPhoneNumber(String num) {
		return 0;
	}

	@Override
	public void setReadMsgOfPhoneNumber(String num) {
		
	}

	@Override
	public void setUnReadMsgOfPhoneNumber(String num) {
		
	}

	@Override
	public List<SMSSessionGroup> getShowList() {
		return null;
	}

	@Override
	public List<SMSSessionGroup> getgetShowListByTime(long start, long end) {
		return null;
	}

	@Override
	public boolean isOpen() {
		return true;
	}

	@Override
	public void switchSet() {
		
	}

	@Override
	public String getOpenCommand(String province) {
		return null;
	}

	@Override
	public void openBusiness() {
	}

	@Override
	protected void initServiceDependency() {
	}

	@Override
	protected void startService() {
		this.context.registerService(IMissCallService.class, this);
	}

	@Override
	protected void stopService() {
	}

}
