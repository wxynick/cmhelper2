package com.wxxr.mobile.callhelper.model;

import android.graphics.Bitmap;

import com.wxxr.mobile.android.ui.AndroidBindingType;
import com.wxxr.mobile.android.ui.annotation.AndroidBinding;
import com.wxxr.mobile.callhelper.app.bean.SMSSessionGroupBean;
import com.wxxr.mobile.core.log.api.Trace;
import com.wxxr.mobile.core.ui.annotation.Attribute;
import com.wxxr.mobile.core.ui.annotation.Bean;
import com.wxxr.mobile.core.ui.annotation.Bean.BindingType;
import com.wxxr.mobile.core.ui.annotation.Field;
import com.wxxr.mobile.core.ui.annotation.View;
import com.wxxr.mobile.core.ui.api.IModelUpdater;
import com.wxxr.mobile.core.ui.common.ViewBase;

@View(name = "MissCallListItemView")
@AndroidBinding(type=AndroidBindingType.VIEW,layoutId="R.layout.common_session_list")
public abstract class MissCallListItemView extends ViewBase implements IModelUpdater {

	static Trace log = Trace.getLogger(MissCallListItemView.class);
	
	@Bean(type=BindingType.Pojo,express="${groupBean.getPortrait() != null}")
	boolean protraitIsNull;
	
	@Field(valueKey="text",binding="性")
	String showFristName;
	
	@Field(valueKey="text",binding="${groupBean.getPhoneNumber() == null ? groupBean.getContactName() : groupBean.getPhoneNumber()}")
	String showNameOrNumber;
	
	@Field(valueKey = "icon",binding="${groupBean.getPortrait()}")
	Bitmap portrait;;
	
	@Field(valueKey = "text",binding="${groupBean.getShowSessionContent()}")
	String brief;	
	
	@Field(valueKey="text" ,attributes={
			@Attribute(name = "background", value = "${background!=null?background:null}")
	})
	String backgroundColor;
	
	@Field(valueKey="text", binding="${groupBean.getSize()}")
	String count;
	
	@Field(valueKey="text",binding="groupBean.getDate()")
	String date;
	
	
	@Bean(type=BindingType.Pojo)
	SMSSessionGroupBean groupBean;
	
	
	void xx(){
		groupBean.getDate();
		groupBean.getSize();
		groupBean.getPortrait();
		groupBean.getContactName();
		groupBean.getPhoneNumber();
		groupBean.getShowSessionContent();
		String a = groupBean.getPhoneNumber() == null ? groupBean.getContactName() : groupBean.getPhoneNumber();
	}
	
	@Override
	public void updateModel(Object data) {
		if (data instanceof SMSSessionGroupBean) {
			SMSSessionGroupBean group = (SMSSessionGroupBean) data;
			registerBean("groupBean", group);
		}
	}
}
