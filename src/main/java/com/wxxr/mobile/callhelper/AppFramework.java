/**
 * 
 */
package com.wxxr.mobile.callhelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import android.app.Application;

import com.wxxr.mobile.callhelper.module.AppSiteSecurityModule;
import com.wxxr.mobile.callhelper.module.WorkbenchManagerModule;
import com.wxxr.mobile.callhelper.service.TimeService;
import com.wxxr.mobile.android.app.AndroidFramework;
import com.wxxr.mobile.android.app.IAndroidAppContext;
import com.wxxr.mobile.android.app.IAndroidFramework;
import com.wxxr.mobile.android.http.HttpRpcServiceModule;
import com.wxxr.mobile.android.preference.PreferenceManagerModule;
import com.wxxr.mobile.core.command.impl.CommandExecutorModule;
import com.wxxr.mobile.core.microkernel.api.AbstractModule;
import com.wxxr.mobile.core.rpc.rest.RestEasyClientModule;

/**
 * @author fudapeng
 *
 */
public class AppFramework extends AndroidFramework<IAndroidAppContext, AbstractModule<IAndroidAppContext>> {

	private final MobileApplication app;
	
	IAndroidAppContext a;
	private class ComHelperAppContextImpl extends AbstractContext implements IAndroidAppContext {
		private ExecutorService executor = Executors.newSingleThreadExecutor();
		@SuppressWarnings("rawtypes")
		@Override
		public IAndroidFramework getApplication() {
			return AppFramework.this;
		}

		@Override
		public void invokeLater(Runnable arg0) {
			runOnUIThread(arg0,0,null);
		}

	};
	
	private ComHelperAppContextImpl context;
	public AppFramework(MobileApplication demoApplication) {
		this.app = demoApplication;
	}
	

	@Override
	public Application getAndroidApplication() {
		return app;
	}

	@Override
	public String getApplicationName() {
		return "mobile demo";
	}

	@Override
	protected IAndroidAppContext getContext() {
		if(context == null)
			context = new ComHelperAppContextImpl();
		return context;
	}

	@Override
	protected void initModules() {
		registerKernelModule(new PreferenceManagerModule<IAndroidAppContext>());
		
		
		
		RestEasyClientModule<IAndroidAppContext> rest = new RestEasyClientModule<IAndroidAppContext>();
		rest.getClient().register(JacksonJsonProvider.class);
		registerKernelModule(rest);
		
		CommandExecutorModule<IAndroidAppContext> cmdExecutor = new CommandExecutorModule<IAndroidAppContext>();
		registerKernelModule(cmdExecutor);
		
		
		HttpRpcServiceModule<IAndroidAppContext> m = new HttpRpcServiceModule<IAndroidAppContext>();
		m.setEnablegzip(false);
		m.setConnectionPoolSize(30);
		registerKernelModule(m);
		
		registerKernelModule(new AppSiteSecurityModule());
		registerKernelModule(new TimeService());
		registerKernelModule(new WorkbenchManagerModule());
	}

}
