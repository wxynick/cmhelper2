/**
 * 
 */
package com.wxxr.mobile.callhelper.model;

import com.wxxr.mobile.android.ui.AndroidBindingType;
import com.wxxr.mobile.android.ui.annotation.AndroidBinding;
import com.wxxr.mobile.callhelper.service.IPrivateSMService;
import com.wxxr.mobile.core.ui.annotation.Attribute;
import com.wxxr.mobile.core.ui.annotation.Bean;
import com.wxxr.mobile.core.ui.annotation.Bean.BindingType;
import com.wxxr.mobile.core.ui.annotation.Command;
import com.wxxr.mobile.core.ui.annotation.Field;
import com.wxxr.mobile.core.ui.annotation.Navigation;
import com.wxxr.mobile.core.ui.annotation.View;
import com.wxxr.mobile.core.ui.annotation.ViewGroup;
import com.wxxr.mobile.core.ui.api.IViewGroup;
import com.wxxr.mobile.core.ui.api.InputEvent;
import com.wxxr.mobile.core.ui.common.PageBase;




/**
 * @author fudapeng
 *
 */
@View(name = "home", withToolbar = true, description = "通信")
@AndroidBinding(type = AndroidBindingType.FRAGMENT_ACTIVITY, layoutId = "R.layout.home_page_new")
public abstract class HomePage extends PageBase {
	
	private static final String[] VIEWIDs = new String[] { "MainHomeView",
		"MicroMessageView","PlazaHomeView", "PersonalCentreView","MissCallGuideView","MissCallView" };
	
	
	@ViewGroup(viewIds = { "MainHomeView", "MicroMessageView", "PlazaHomeView",
			"PersonalCentreView" })
	IViewGroup contents;
	
	
	@Bean(type=BindingType.Pojo)
	@Field(valueKey="selected",binding="${homeSelected}")
	private boolean homeSelected;
	
	@Bean(type=BindingType.Pojo)
	@Field(valueKey="selected",binding="${newSelected}")
	boolean newSelected;
	
	@Bean(type=BindingType.Pojo)
	@Field(valueKey="selected",binding="${plazaSelected}")
	boolean plazaSelected;
	
	@Bean(type=BindingType.Pojo)
	@Field(valueKey="selected",binding="${personalCentreSelected}")
	boolean personalCentreSelected;
	
	
	@Field(valueKey="visible",visibleWhen="${size != 0 ? true : false}",attributes={@Attribute(name="text",value="${size}")})
	boolean showSiminews;
	
	@Bean(type=BindingType.Pojo,express="${psm.getAllUnreadSize()}")
	int size;
	
	@Bean(type=BindingType.Service)
	IPrivateSMService psm;
	
	/**
	 * 首页点击
	 * 
	 * @param event
	 * @return
	 */
	@Command(navigations = { @Navigation(on = "*", showView = "MainHomeView") })
	String goHome(InputEvent event) {
		homeSelected = true;
		personalCentreSelected = plazaSelected = newSelected = false;
		registerBeans();
		return "";
	}

	/**
	 * 交易微资讯
	 * 
	 * @param event
	 * @return
	 */
	@Command(navigations = { @Navigation(on = "*", showView = "MicroMessageView") })
	String goNews(InputEvent event) {
		newSelected  = true;
		personalCentreSelected = plazaSelected = homeSelected = false;
		registerBeans();
		return "";
	}

	/**
	 * 广场
	 * 
	 * @param event
	 * @return
	 */
	@Command(navigations = { @Navigation(on = "*", showView = "PlazaHomeView") })
	String goPlaza(InputEvent event) {
		plazaSelected  = true;
		personalCentreSelected = newSelected = homeSelected = false;
		registerBeans();
		return "";
	}

	/**
	 * 行情个人中心
	 * 
	 * @param event
	 * @return
	 */
	@Command(navigations = { @Navigation(on = "*", showView = "PersonalCentreView") })
	String goPersonalCentre(InputEvent event) {
		personalCentreSelected = true;
		plazaSelected = newSelected = homeSelected = false;
		registerBeans();
		return "";
	}
	
	private void registerBeans(){
		registerBean("homeSelected", homeSelected);
		registerBean("personalCentreSelected", personalCentreSelected);
		registerBean("plazaSelected", plazaSelected);
		registerBean("newSelected", newSelected);
	}

		
}
