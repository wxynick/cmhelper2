package com.wxxr.mobile.callhelper.app.model;

import com.wxxr.mobile.core.annotation.BindableBean;

/**
 * @author fudapeng
 *
 */
@BindableBean(pkg="com.wxxr.mobile.callhelper.app.bean",className="MissCallsSettingBean")
public class MissCallsSetting {
	/**
	 * 是否开通漏电提醒
	 */
	private boolean isOpenMissCall;
}
