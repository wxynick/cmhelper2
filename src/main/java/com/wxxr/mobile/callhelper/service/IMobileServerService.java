/**
 * 
 */
package com.wxxr.mobile.callhelper.service;

/**
 * @author fudapeng
 *
 */
public interface IMobileServerService {
	enum MobileServerType{
		DXHZ,LIANTXING
	}
	String getServicePhoneNumber(MobileServerType type);
}
