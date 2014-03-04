/**
 * 
 */
package com.wxxr.mobile.callhelper.widget;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.wxxr.mobile.core.microkernel.api.KUtils;
import com.wxxr.mobile.core.ui.api.AttributeKey;
import com.wxxr.mobile.core.ui.api.IAppToolbar;
import com.wxxr.mobile.core.ui.api.IDataField;
import com.wxxr.mobile.core.ui.common.AbstractToolbarView;
import com.wxxr.mobile.core.ui.common.UIComponent;

public abstract class CallhelperAppToolbar extends AbstractToolbarView implements IAppToolbar {
	public static final String MESSAGE_FIELD_NAME = "message";
	public static final String TITLE_FIELD_NAME = "title";
	public static final String STATUS_FIELD_NAME = "status";
	
	/* (non-Javadoc)
	 * @see com.wxxr.mobile.stock.client.IStockAppToolbar#showNotification(java.lang.String, java.util.Map)
	 */
	public void showNotification(String message, String status, Map<String, String> parameters) {
		IDataField<String> statusfield = getField(STATUS_FIELD_NAME);
		if(statusfield != null)
			statusfield.setValue(status);
		IDataField<String> field = getField(MESSAGE_FIELD_NAME);
		if(field != null){
			field.setValue(message);
			if(parameters != null){
				for (String key : parameters.keySet()) {
					AttributeKey<?> attrKey = getUIContext().getWorkbenchManager().getFieldAttributeManager().getAttributeKey(key);
					if(attrKey != null){
						attrKey.updateAttributeWithString(field, parameters.get(key));
					}
				}
			}
			if(message != null){
				KUtils.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						UIComponent.disableEvents();
						try {
							IDataField<String> field = getField(MESSAGE_FIELD_NAME);
							if(field != null){
								field.setValue(null);
							}
						}finally{
							UIComponent.enableEvents();
						}
					}
				}, 1, TimeUnit.SECONDS);
			}
		}
	}
	@Override
	public void setTitle(String message, Map<String, String> parameters) {
		IDataField<String> field = getField(TITLE_FIELD_NAME);
		if(field != null){
			field.setValue(message);
			if(parameters != null){
				for (String key : parameters.keySet()) {
					AttributeKey<?> attrKey = getUIContext().getWorkbenchManager().getFieldAttributeManager().getAttributeKey(key);
					if(attrKey != null){
						attrKey.updateAttributeWithString(field, parameters.get(key));
					}
				}
			}
		}
	}
}
