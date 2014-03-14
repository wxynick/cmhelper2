/**
 * 
 */
package com.wxxr.mobile.callhelper.bind;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxxr.mobile.core.ui.api.AttributeKey;
import com.wxxr.mobile.core.ui.api.IAttributeUpdater;
import com.wxxr.mobile.core.ui.api.IUIComponent;

/**
 * @author fudapeng
 *
 */
public class IconAttributeUpdater implements IAttributeUpdater<View> {

	@Override
	public boolean acceptable(Object arg0) {
		return arg0 instanceof ImageView;
	}

	@Override
	public <T> void updateControl(View control, AttributeKey<T> attrType,
			IUIComponent field, Object value) {
		View tv = (View)control;
		if(value instanceof Bitmap){
			tv.setBackgroundDrawable(new BitmapDrawable((Bitmap)value));
		}
	}

	@Override
	public <T> T updateModel(View arg0, AttributeKey<T> arg1,
			IUIComponent arg2) {
		return null;
	}

}
