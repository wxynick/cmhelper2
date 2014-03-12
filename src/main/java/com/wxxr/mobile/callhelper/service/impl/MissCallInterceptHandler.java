package com.wxxr.mobile.callhelper.service.impl;

import com.wxxr.mobile.callhelper.app.model.SMSInfo;
import com.wxxr.mobile.callhelper.service.ISMSInterceptHandler;

/**
 * 拦截电话漏接的短信
 * @author fudapeng
 *
 */
public class MissCallInterceptHandler implements ISMSInterceptHandler {

	@Override
	public boolean handle(SMSInfo smsInfo) {
		return false;
	}

}
