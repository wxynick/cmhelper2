/**
 * 
 */
package com.wxxr.mobile.callhelper.service.impl;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import android.text.TextUtils;

import com.wxxr.mobile.android.app.AppUtils;
import com.wxxr.mobile.callhelper.ICallHeplerAppContext;
import com.wxxr.mobile.callhelper.app.bean.SMSInfoBean;
import com.wxxr.mobile.callhelper.app.bean.SMSSessionGroupBean;
import com.wxxr.mobile.callhelper.app.model.SMSInfo;
import com.wxxr.mobile.callhelper.app.model.SMSSessionGroup;
import com.wxxr.mobile.callhelper.compatibility.bean.BodyBean;
import com.wxxr.mobile.callhelper.compatibility.dao.LouHuaDao;
import com.wxxr.mobile.callhelper.constant.TimeFormat;
import com.wxxr.mobile.callhelper.service.IMissCallService;
import com.wxxr.mobile.callhelper.service.IMissCallSmsInterceptRule;
import com.wxxr.mobile.callhelper.service.IUserService;
import com.wxxr.mobile.callhelper.utils.PullParseUtil;
import com.wxxr.mobile.callhelper.utils.XmlDescriptor;
import com.wxxr.mobile.core.log.api.Trace;
import com.wxxr.mobile.core.microkernel.api.AbstractModule;

/**
 * @author fudapeng
 *
 */
public class MissCallService extends AbstractModule<ICallHeplerAppContext> implements IMissCallService{
	private static final Trace log = Trace.register(MissCallService.class);
	
	
	private List<IMissCallSmsInterceptRule> missCallRules = new ArrayList<IMissCallSmsInterceptRule>();
	
	
	
	public List<IMissCallSmsInterceptRule> initMissCallRule() {

		InputStream is = null;
		try {
			is = AppUtils.getFramework().getAndroidApplication().getResources().getAssets()
					.open("ReminderForProvinces.xml");
			PullParseUtil service = new PullParseUtil();
			List<XmlDescriptor> lsrds = service.doParse(is);
			for (XmlDescriptor r : lsrds) {
				MissCallSmsInterceptRule province = new MissCallSmsInterceptRule(
						r.getName(), r.getPatterns());
				missCallRules.add(province);
			}
		} catch (IOException e) {
		}

		return missCallRules;
	}
	
	
	
	
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
	
	
	
	private void processSession(SMSSessionGroupBean group){
		List<SMSInfoBean> sms = group.getSms();
		if(sms != null && !sms.isEmpty()){
			SMSInfoBean last = sms.get(sms.size() - 1);
			String time1 = TimeFormat.format_yue_day.format(new Date());
			String time2 = TimeFormat.format_yue_day.format(last.getCdate());
			if (!TextUtils.isEmpty(time1) && !TextUtils.isEmpty(time2)
					&& time1.equals(time2)) {
				group.setDate(TimeFormat.format_today.format(last.getCdate()));// 时间
			} else {
				group.setDate(TimeFormat.format_time.format(last.getCdate()));// 日期

			}
			
		}
		
	}
	
	@Override
	public List<SMSSessionGroupBean> getShowList() {
		long startime = -1, endtime = -1;
		ArrayList<ArrayList<BodyBean>> bodyss = new ArrayList<ArrayList<BodyBean>>();
		LouHuaDao ldao = LouHuaDao.getInstance(AppUtils.getFramework().getAndroidApplication());
		Date d = new Date();
		d.setTime(startime);
		d.setTime(endtime);
		ArrayList<BodyBean> alast = ldao.queryAllLouHua(startime, endtime);

		Hashtable<String, SMSSessionGroupBean> person = new Hashtable<String, SMSSessionGroupBean>();
		List<SMSSessionGroupBean> groups = new ArrayList<SMSSessionGroupBean>();
		SMSSessionGroupBean group = null;
		for (BodyBean item : alast) {
			String rdate = "";
			String key = item.address;
			group = null;
			if (person.get(key) == null) {
				group = new SMSSessionGroupBean();
				group.setPhoneNumber(key);
				person.put(key, group);
			}else{
				group = person.get(key);
			}
			
			List<SMSInfoBean> list = group.getSms();
			if(list == null){
				list = new ArrayList<SMSInfoBean>();
				group.setSms(list);
			}
			group.getSms().add(SMSInfoBean.convert(item));
		}
		
		Collections.sort(group.getSms(), new SortSMS());
		processSession(group);
		Enumeration<SMSSessionGroupBean> et = person.elements();
		
		while(et.hasMoreElements()){
			groups.add(et.nextElement());
		}
		Collections.sort(groups, new SortSession());
		
		return groups;
	}
	
	class SortSMS implements Comparator<SMSInfoBean> {

		@Override
		public int compare(SMSInfoBean lhs, SMSInfoBean rhs) {
			long p1 = lhs.getCdate(),
				 p2 = rhs.getCdate();
			long compara = p2-p1;
			return (int)compara;
		}
	}
	
	
	class SortSession implements Comparator<SMSSessionGroupBean> {

		@Override
		public int compare(SMSSessionGroupBean lhs, SMSSessionGroupBean rhs) {
			long p1 = Long.parseLong(lhs.getPhoneNumber()),
				 p2 = Long.parseLong(rhs.getPhoneNumber());
			long compara = p1-p2;
			return (int)compara;
		}
	}

	@Override
	public List<SMSSessionGroupBean> getShowListByTime(long start, long end) {
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
		addRequiredService(IUserService.class);
	}

	@Override
	protected void startService() {
		this.context.registerService(IMissCallService.class, this);
		initMissCallRule();
	}

	@Override
	protected void stopService() {
	}
	
	// 是否存在该省份的规则
	protected IMissCallSmsInterceptRule getRule(String provinceCode) {
		if(provinceCode!=null){
		for (IMissCallSmsInterceptRule r : missCallRules) {
			if (provinceCode.equals(r.getName())) {
				return r;
			}
		}
		}
		return null;
	}

	@Override
	public boolean isMatch(String smsContent, String targetnumber) {
		// 获取用户选择的省份代码
		// 判段用户是否选择了省份，如果该省份存在规则，则按照该规则拦截，如果用户没选省份或者省份没有规则则按照所有规则来拦截
		String code = context.getService(IUserService.class).getUserDetail().getProvince();
		IMissCallSmsInterceptRule r1 = getRule(code);
		if (r1 != null) {
			return r1.isMatch(smsContent, targetnumber);
		} else {
			for (IMissCallSmsInterceptRule r : missCallRules) {
				boolean x = r.isMatch(smsContent, targetnumber);
				if (x) {
					return true;
				}
			}
			return false;
		}
	}

}
