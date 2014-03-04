/**
 * 
 */
package com.wxxr.mobile.callhelper.model;

import java.util.Map;

import com.wxxr.mobile.android.ui.AndroidBindingType;
import com.wxxr.mobile.android.ui.annotation.AndroidBinding;
import com.wxxr.mobile.core.ui.annotation.Bean;
import com.wxxr.mobile.core.ui.annotation.Command;
import com.wxxr.mobile.core.ui.annotation.Field;
import com.wxxr.mobile.core.ui.annotation.UIItem;
import com.wxxr.mobile.core.ui.annotation.View;
import com.wxxr.mobile.core.ui.api.IDialog;
import com.wxxr.mobile.core.ui.api.IModelUpdater;
import com.wxxr.mobile.core.ui.api.IUIComponent;
import com.wxxr.mobile.core.ui.api.InputEvent;
import com.wxxr.mobile.core.ui.common.AttributeKeys;
import com.wxxr.mobile.core.ui.common.DataField;
import com.wxxr.mobile.core.ui.common.UICommand;
import com.wxxr.mobile.core.ui.common.ViewBase;

/**
 * @author neillin
 *
 */
@View(name="progressMonitor",alias="messageBox")
@AndroidBinding(type=AndroidBindingType.VIEW,layoutId="R.layout.message_box_layout")
public abstract class MessageBox extends ViewBase implements IModelUpdater{
	@Field(valueKey="text",visibleWhen="${isTitle}")
	String title;
	@Bean
	boolean isTitle = true;
	@Bean
	boolean isController = false;
	
	@Field(valueKey="visible",visibleWhen="${isTitle}")
	boolean hlines;
	
	@Field(valueKey="visible",visibleWhen="${isController}")
	boolean controller;
	
	DataField<String> titleField;
	
	@Field(valueKey="text")
	String message;
	
	DataField<String> messageField;
	
	@Field
	int progress;
	
	@Field(valueKey="visible")
	boolean progressBarVisible;
	
	DataField<Boolean> progressBarVisibleField;
	
	DataField<Integer> progressField;
	
	@Field
	String icon;
	
	DataField<String> iconField;
	
	UICommand left,right,middle;
	
	@Command(uiItems={
			@UIItem(label="resourceId:message/dummy_ok_label",id="left_button",icon="",visibleWhen="false"),
			@UIItem(label="resourceId:message/dummy_middle_label",id="mid_button",icon="",visibleWhen="false"),
			@UIItem(label="resourceId:message/dummy_canel_label",id="right_button",icon="",visibleWhen="false")
	})
	String dummyClick(InputEvent evt){
		hide();
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.core.ui.api.IModelUpdater#updateModel(java.lang.Object)
	 */
	@Override
	public void updateModel(Object data) {
		if(data instanceof Map){
			Map<String, Object> map = (Map<String, Object>)data;
			Object val = map.get(IDialog.DIALOG_ATTRIBUTE_TITLE);
			if(val instanceof String){
				this.titleField.setValue((String)val);
				this.isTitle = true;
			}else{
				this.isTitle = false;
			}
			registerBean("isTitle", this.isTitle);
			val = map.get(IDialog.DIALOG_ATTRIBUTE_MESSAGE);
			if(val instanceof String){
				this.messageField.setValue((String)val);
			}
			val = map.get(IDialog.DIALOG_ATTRIBUTE_ICON);
			if(val instanceof String){
				this.iconField.setValue((String)val);
			}
			
			val = map.get("progressDialogVisible");
			if(val instanceof String) {
				Boolean pdVisible = Boolean.parseBoolean((String)val);
				this.progressBarVisibleField.setValue(pdVisible);
			}
			val = map.get(IDialog.DIALOG_ATTRIBUTE_LEFT_BUTTON);
			if(val instanceof UICommand){
				removeChild("left_button");
				this.left = (UICommand)val;
				if(containsChild(this.left)){
					remove(left);
				}
				add(left);
				this.left.setAttribute(AttributeKeys.visible, true);
				this.isController = true;
			}else if(val instanceof String){
				super.getChild("left_button").setAttribute(AttributeKeys.visible, true).setAttribute(AttributeKeys.label, (String)val);
				this.isController = true;
			}else{
				super.getChild("left_button").setAttribute(AttributeKeys.visible, false);
				this.isController = false;
			}
			val = map.get(IDialog.DIALOG_ATTRIBUTE_MID_BUTTON);
			if(val instanceof UICommand){
				removeChild("mid_button");
				this.middle = (UICommand)val;
				if(containsChild(this.middle)){
					remove(middle);
				}
				add(middle);
				this.middle.setAttribute(AttributeKeys.visible, true);
				this.isController = true;
			}else if(val instanceof String){
				super.getChild("mid_button").setAttribute(AttributeKeys.visible, true).setAttribute(AttributeKeys.label, (String)val);
			}else{
				super.getChild("mid_button").setAttribute(AttributeKeys.visible, false);
			}
			val = map.get(IDialog.DIALOG_ATTRIBUTE_RIGHT_BUTTON);
			if(val instanceof UICommand){
				removeChild("right_button");
				this.right = (UICommand)val;
				if(containsChild(this.right)){
					remove(right);
				}
				add(right);
				this.right.setAttribute(AttributeKeys.visible, true);
				this.isController = true;
			}else if(val instanceof String){
				super.getChild("right_button").setAttribute(AttributeKeys.visible, true).setAttribute(AttributeKeys.label, (String)val);
				this.isController = true;
			}else{
				this.isController = false;
				super.getChild("right_button").setAttribute(AttributeKeys.visible, false);
			}
			registerBean("isController", this.isController);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.wxxr.mobile.core.ui.common.UIContainer#getChild(java.lang.String)
	 */
	@Override
	public IUIComponent getChild(String name) {
		if(IDialog.DIALOG_ATTRIBUTE_LEFT_BUTTON.equals(name)&&(left != null)){
			return left;
		}else if(IDialog.DIALOG_ATTRIBUTE_MID_BUTTON.equals(name)&&(middle != null)){
			return middle;
		}else if(IDialog.DIALOG_ATTRIBUTE_RIGHT_BUTTON.equals(name)&&(right != null)){
			return right;
		}
		return super.getChild(name);
	}

}
