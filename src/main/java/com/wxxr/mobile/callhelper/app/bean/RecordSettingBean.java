/*
 * Generated code, don't modified !
 */
package com.wxxr.mobile.callhelper.app.bean;

import com.wxxr.mobile.core.bean.api.IBindableBean;
import com.wxxr.mobile.core.bean.api.IPropertyChangeListener;
import com.wxxr.mobile.core.ui.common.BindableBeanSupport;

/**
 * Generated by Bindable Bean generator
 *
 */
public class RecordSettingBean implements IBindableBean {
	
	private final BindableBeanSupport emitter = new BindableBeanSupport(this);
	private boolean isOpen;

	/**
	 * @param listener
	 */
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		emitter.addPropertyChangeListener(listener);
	}

	/**
	 * @param listener
	 */
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		emitter.removePropertyChangeListener(listener);
	}
	
	@Override
	public boolean hasPropertyChangeListener(IPropertyChangeListener listener) {
		return emitter.hasPropertyChangeListener(listener);
	}



	/**
	 * @return the isOpen
	 */
	public boolean getIsOpen() {
		return isOpen;
	}

	/**
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(boolean isOpen) {
		boolean old = this.isOpen;
		this.isOpen = isOpen;
		this.emitter.firePropertyChange("isOpen", old, this.isOpen);
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override   
    public String toString() {
        return "RecordSettingBean ["+
                "isOpen=" + this.isOpen +
        "]";
    }	

}
