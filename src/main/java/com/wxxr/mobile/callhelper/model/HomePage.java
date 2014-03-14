/**
 * 
 */
package com.wxxr.mobile.callhelper.model;

import android.widget.ImageView;

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
			"PersonalCentreView" ,"MissCallGuideView" , "MissCallView"})
	IViewGroup contents;
	
	
	@Bean(type=BindingType.Pojo)
	private boolean hs;
	
	@Bean(type=BindingType.Pojo)
	private boolean ns;
	
	@Bean(type=BindingType.Pojo)
	boolean pd;
	
	@Bean(type=BindingType.Pojo)
	boolean psd;
	
	@Field(valueKey="selected",binding="${hs}")
	private boolean homeSelected;
	
	
	@Field(valueKey="selected",binding="${ns}")
	boolean newSelected;
	
	
	@Field(valueKey="selected",binding="${pd}")
	boolean plazaSelected;
	
	@Field(valueKey="selected",binding="${psd}")
	boolean personalCentreSelected;
	
	
	@Field(valueKey="visible",visibleWhen="${size != 0 ? true : false}",attributes={@Attribute(name="textsize",value="${size}")})
	boolean siminewsText;
	
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
		hs = true;
		psd = pd = ns = false;
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
		ns  = true;
		psd = pd = hs = false;
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
		pd  = true;
		psd = ns = hs = false;
		registerBeans();
		ImageView v = null;
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
		psd = true;
		pd = ns = hs = false;
		registerBeans();
		return "";
	}
	
	private void registerBeans(){
		registerBean("hs", hs);
		registerBean("psd", psd);
		registerBean("pd", pd);
		registerBean("ns", ns);
	}

		
}
