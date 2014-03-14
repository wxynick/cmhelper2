/*
 * Generated code, don't modified !
 */
package com.wxxr.mobile.callhelper.app.bean;

import com.wxxr.mobile.callhelper.app.model.SMSType;
import com.wxxr.mobile.callhelper.compatibility.bean.BodyBean;
import com.wxxr.mobile.core.bean.api.IBindableBean;
import com.wxxr.mobile.core.bean.api.IPropertyChangeListener;
import com.wxxr.mobile.core.ui.common.BindableBeanSupport;

/**
 * Generated by Bindable Bean generator
 *
 */
public class SMSInfoBean implements IBindableBean {
	
	private final BindableBeanSupport emitter = new BindableBeanSupport(this);
	private Integer id;
	private String content;
	private boolean isStorage;
	private String amonth;
	private String phoneNumber;
	private boolean read;
	private SMSType type;
	private long cdate;
	private Integer mstyle;

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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Integer old = this.id;
		this.id = id;
		this.emitter.firePropertyChange("id", old, this.id);
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		String old = this.content;
		this.content = content;
		this.emitter.firePropertyChange("content", old, this.content);
	}

	/**
	 * @return the isStorage
	 */
	public boolean getIsStorage() {
		return isStorage;
	}

	/**
	 * @param isStorage the isStorage to set
	 */
	public void setIsStorage(boolean isStorage) {
		boolean old = this.isStorage;
		this.isStorage = isStorage;
		this.emitter.firePropertyChange("isStorage", old, this.isStorage);
	}

	/**
	 * @return the amonth
	 */
	public String getAmonth() {
		return amonth;
	}

	/**
	 * @param amonth the amonth to set
	 */
	public void setAmonth(String amonth) {
		String old = this.amonth;
		this.amonth = amonth;
		this.emitter.firePropertyChange("amonth", old, this.amonth);
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		String old = this.phoneNumber;
		this.phoneNumber = phoneNumber;
		this.emitter.firePropertyChange("phoneNumber", old, this.phoneNumber);
	}

	/**
	 * @return the read
	 */
	public boolean getRead() {
		return read;
	}

	/**
	 * @param read the read to set
	 */
	public void setRead(boolean read) {
		boolean old = this.read;
		this.read = read;
		this.emitter.firePropertyChange("read", old, this.read);
	}

	/**
	 * @return the type
	 */
	public SMSType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(SMSType type) {
		SMSType old = this.type;
		this.type = type;
		this.emitter.firePropertyChange("type", old, this.type);
	}

	/**
	 * @return the cdate
	 */
	public long getCdate() {
		return cdate;
	}

	/**
	 * @param cdate the cdate to set
	 */
	public void setCdate(long cdate) {
		long old = this.cdate;
		this.cdate = cdate;
		this.emitter.firePropertyChange("cdate", old, this.cdate);
	}

	/**
	 * @return the mstyle
	 */
	public Integer getMstyle() {
		return mstyle;
	}

	/**
	 * @param mstyle the mstyle to set
	 */
	public void setMstyle(Integer mstyle) {
		Integer old = this.mstyle;
		this.mstyle = mstyle;
		this.emitter.firePropertyChange("mstyle", old, this.mstyle);
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override   
    public String toString() {
        return "SMSInfoBean ["+
                "id=" + this.id +
                " , content=" + this.content +
                " , isStorage=" + this.isStorage +
                " , amonth=" + this.amonth +
                " , phoneNumber=" + this.phoneNumber +
                " , read=" + this.read +
                " , type=" + this.type +
                " , cdate=" + this.cdate +
                " , mstyle=" + this.mstyle +
        "]";
    }
    
    
    public static SMSInfoBean convert(BodyBean value){
    	SMSInfoBean bean = new SMSInfoBean();
    	bean.setAmonth(value.getAmonth());
    	bean.setPhoneNumber(value.getAddress());
    	bean.setCdate(value.getCdate());
    	bean.setMstyle(value.getMstyle());
    	bean.setRead(value.getState() != null && value.getState() == 0);
    	return bean;
    }

}
