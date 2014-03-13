/**
 * 
 */
package com.wxxr.mobile.callhelper.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wxxr.mobile.callhelper.ICallHeplerAppContext;
import com.wxxr.mobile.callhelper.app.model.ContactPerson;
import com.wxxr.mobile.callhelper.app.model.SMSInfo;
import com.wxxr.mobile.callhelper.app.model.SMSSessionGroup;
import com.wxxr.mobile.callhelper.app.model.SMSStatus;
import com.wxxr.mobile.callhelper.service.IPhoneSystemService;
import com.wxxr.mobile.core.microkernel.api.AbstractModule;

/**
 * @author fudapeng
 *
 */
public class PhoneSystemService extends AbstractModule<ICallHeplerAppContext> implements
		IPhoneSystemService {

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#deleteMessage(java.lang.Integer)
	 */
	@Override
	public void deleteMessage(Integer msgId) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#deleteMessage(com.wxxr.mobile.callhelper.app.model.SMSInfo)
	 */
	@Override
	public void deleteMessage(SMSInfo msg) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#deleteMessageGroup(com.wxxr.mobile.callhelper.app.model.SMSSessionGroup)
	 */
	@Override
	public void deleteMessageGroup(SMSSessionGroup msg) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#deleteMessage(java.lang.String, boolean)
	 */
	@Override
	public void deleteMessage(String number, boolean needfreshcache) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#getAllUnreadSize()
	 */
	@Override
	public int getAllUnreadSize() {
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#getUnreadSizeOfPhoneNumber(java.lang.String)
	 */
	@Override
	public int getUnreadSizeOfPhoneNumber(String num) {
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#setReadMsgOfPhoneNumber(java.lang.String)
	 */
	@Override
	public void setReadMsgOfPhoneNumber(String num) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#setUnReadMsgOfPhoneNumber(java.lang.String)
	 */
	@Override
	public void setUnReadMsgOfPhoneNumber(String num) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.ICommmonService#getShowList()
	 */
	@Override
	public List<SMSSessionGroup> getShowList() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#sentMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean sentMessage(String targetNumber, String content) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#setMessage(com.wxxr.mobile.callhelper.app.model.SMSStatus, java.lang.String, java.lang.String, java.lang.Long, int)
	 */
	@Override
	public boolean setMessage(SMSStatus status, String phoneNumber,
			String content, Long date, int style) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#sentNotification(java.lang.String)
	 */
	@Override
	public void sentNotification(String tickerText) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#sentNotification(java.lang.String, java.util.Map)
	 */
	@Override
	public void sentNotification(String tickerText, Map<String, Object> args) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#getAllContactPerson()
	 */
	@Override
	public List<ContactPerson> getAllContactPerson() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#getContactPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public ContactPerson getContactPersonByPhoneNumber(String phoneNumber) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#callUp()
	 */
	@Override
	public void callUp() {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#takePicture(com.wxxr.mobile.callhelper.service.IPhoneSystemService.PictureCallback, java.util.HashMap)
	 */
	@Override
	public void takePicture(PictureCallback callback,
			HashMap<String, String> Parameters) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#startRecorder(java.lang.String, java.util.HashMap)
	 */
	@Override
	public void startRecorder(String path, HashMap<String, String> parameters) {
		

	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.callhelper.service.IPhoneSystemService#stopRecorder()
	 */
	@Override
	public void stopRecorder() {
		

	}

	@Override
	protected void initServiceDependency() {
		
		
	}

	@Override
	protected void startService() {
		context.registerService(IPhoneSystemService.class, this);
	}

	@Override
	protected void stopService() {
		
		
	}

}
