/*
 * Generated code, don't modified !
 */
package com.wxxr.mobile.callhelper.app.bean;

import java.util.Date;
import com.wxxr.mobile.core.bean.api.IBindableBean;
import com.wxxr.mobile.core.bean.api.IPropertyChangeListener;
import com.wxxr.mobile.core.ui.common.BindableBeanSupport;

/**
 * Generated by Bindable Bean generator
 *
 */
public class HtmlContentBean implements IBindableBean {
	
	private final BindableBeanSupport emitter = new BindableBeanSupport(this);
	private String origUrl;
	private String linkUrl;
	private String image;
	private String url;
	private String pageIndex;
	private String createtime;
	private String abstrct;
	private String title;
	private String source;
	private long serialVersionUID;
	private String listimageUrl;
	private Date createDate;
	private String cheap21cityname;
	private String defaultPage;

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
	 * @return the origUrl
	 */
	public String getOrigUrl() {
		return origUrl;
	}

	/**
	 * @param origUrl the origUrl to set
	 */
	public void setOrigUrl(String origUrl) {
		String old = this.origUrl;
		this.origUrl = origUrl;
		this.emitter.firePropertyChange("origUrl", old, this.origUrl);
	}

	/**
	 * @return the linkUrl
	 */
	public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * @param linkUrl the linkUrl to set
	 */
	public void setLinkUrl(String linkUrl) {
		String old = this.linkUrl;
		this.linkUrl = linkUrl;
		this.emitter.firePropertyChange("linkUrl", old, this.linkUrl);
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		String old = this.image;
		this.image = image;
		this.emitter.firePropertyChange("image", old, this.image);
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		String old = this.url;
		this.url = url;
		this.emitter.firePropertyChange("url", old, this.url);
	}

	/**
	 * @return the pageIndex
	 */
	public String getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(String pageIndex) {
		String old = this.pageIndex;
		this.pageIndex = pageIndex;
		this.emitter.firePropertyChange("pageIndex", old, this.pageIndex);
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		String old = this.createtime;
		this.createtime = createtime;
		this.emitter.firePropertyChange("createtime", old, this.createtime);
	}

	/**
	 * @return the abstrct
	 */
	public String getAbstrct() {
		return abstrct;
	}

	/**
	 * @param abstrct the abstrct to set
	 */
	public void setAbstrct(String abstrct) {
		String old = this.abstrct;
		this.abstrct = abstrct;
		this.emitter.firePropertyChange("abstrct", old, this.abstrct);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		String old = this.title;
		this.title = title;
		this.emitter.firePropertyChange("title", old, this.title);
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		String old = this.source;
		this.source = source;
		this.emitter.firePropertyChange("source", old, this.source);
	}

	/**
	 * @return the serialVersionUID
	 */
	public long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @param serialVersionUID the serialVersionUID to set
	 */
	public void setSerialVersionUID(long serialVersionUID) {
		long old = this.serialVersionUID;
		this.serialVersionUID = serialVersionUID;
		this.emitter.firePropertyChange("serialVersionUID", old, this.serialVersionUID);
	}

	/**
	 * @return the listimageUrl
	 */
	public String getListimageUrl() {
		return listimageUrl;
	}

	/**
	 * @param listimageUrl the listimageUrl to set
	 */
	public void setListimageUrl(String listimageUrl) {
		String old = this.listimageUrl;
		this.listimageUrl = listimageUrl;
		this.emitter.firePropertyChange("listimageUrl", old, this.listimageUrl);
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		Date old = this.createDate;
		this.createDate = createDate;
		this.emitter.firePropertyChange("createDate", old, this.createDate);
	}

	/**
	 * @return the cheap21cityname
	 */
	public String getCheap21cityname() {
		return cheap21cityname;
	}

	/**
	 * @param cheap21cityname the cheap21cityname to set
	 */
	public void setCheap21cityname(String cheap21cityname) {
		String old = this.cheap21cityname;
		this.cheap21cityname = cheap21cityname;
		this.emitter.firePropertyChange("cheap21cityname", old, this.cheap21cityname);
	}

	/**
	 * @return the defaultPage
	 */
	public String getDefaultPage() {
		return defaultPage;
	}

	/**
	 * @param defaultPage the defaultPage to set
	 */
	public void setDefaultPage(String defaultPage) {
		String old = this.defaultPage;
		this.defaultPage = defaultPage;
		this.emitter.firePropertyChange("defaultPage", old, this.defaultPage);
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override   
    public String toString() {
        return "HtmlContentBean ["+
                "origUrl=" + this.origUrl +
                " , linkUrl=" + this.linkUrl +
                " , image=" + this.image +
                " , url=" + this.url +
                " , pageIndex=" + this.pageIndex +
                " , createtime=" + this.createtime +
                " , abstrct=" + this.abstrct +
                " , title=" + this.title +
                " , source=" + this.source +
                " , serialVersionUID=" + this.serialVersionUID +
                " , listimageUrl=" + this.listimageUrl +
                " , createDate=" + this.createDate +
                " , cheap21cityname=" + this.cheap21cityname +
                " , defaultPage=" + this.defaultPage +
        "]";
    }	

}
