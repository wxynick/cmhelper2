/**
 * 
 */
package com.wxxr.mobile.callhelper.model;

import com.wxxr.mobile.android.ui.AndroidBindingType;
import com.wxxr.mobile.android.ui.annotation.AndroidBinding;
import com.wxxr.mobile.callhelper.service.IMissCallService;
import com.wxxr.mobile.callhelper.service.IMobileServerService;
import com.wxxr.mobile.callhelper.service.IPhoneSystemService;
import com.wxxr.mobile.core.ui.annotation.Bean;
import com.wxxr.mobile.core.ui.annotation.Bean.BindingType;
import com.wxxr.mobile.core.ui.annotation.Command;
import com.wxxr.mobile.core.ui.annotation.Navigation;
import com.wxxr.mobile.core.ui.annotation.Parameter;
import com.wxxr.mobile.core.ui.annotation.UIItem;
import com.wxxr.mobile.core.ui.annotation.View;
import com.wxxr.mobile.core.ui.api.InputEvent;
import com.wxxr.mobile.core.ui.common.ViewBase;

/**
 * @author fudapeng
 *
 */
@View(name="MissCallGuideView", description="向导", provideSelection = true)
@AndroidBinding(type=AndroidBindingType.FRAGMENT,layoutId="R.layout.main_home_view")
public class MissCallGuideView extends ViewBase {
	@Bean(type=BindingType.Service)
	IMissCallService missCallSerivce;
	
	@Bean(type=BindingType.Service)
	IPhoneSystemService phoneSystemService;
	
	@Bean(type=BindingType.Service)
	IMobileServerService mobileService;
	
	
	
	@Command(navigations={@Navigation(on = "*", message = "",params = {
			@Parameter(name = "title", value = "办理通讯助手"),
			@Parameter(name = "onOK", value = "leftok"),
			@Parameter(name = "onCanceled", value = "取消")})})
	String openImmediately(InputEvent event){
		return "";
	}
	
	
	@Command(uiItems=@UIItem(id="leftok",label="确定",icon=""))
	String onOkClick(InputEvent event){
//		String targetNumber = mobileService.getServicePhoneNumber(IMobileServerService.MobileServerType.LIANTXING);
//		String command = missCallSerivce.getOpenCommand("gd");
//		phoneSystemService.sentMessage(targetNumber,command);
		missCallSerivce.openBusiness();
		return "";
	}
	
	void xx(){
	}
}
