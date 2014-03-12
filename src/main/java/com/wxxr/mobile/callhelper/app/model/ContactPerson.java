package com.wxxr.mobile.callhelper.app.model;

import java.util.List;

import com.wxxr.mobile.core.annotation.BindableBean;

import android.graphics.Bitmap;

/**
 * @author fudapeng
 */
@BindableBean(pkg="com.wxxr.mobile.callhelper.app.bean",className="ContactPersonBean")
public class ContactPerson {
	/**
	 * 名字 
	 */
	private String fristName;
	
	/**
	 * 姓
	 */
	private String lastName;
	
	/**
	 * 头像
	 */
	private Bitmap portrait;
	
	/**
	 * 手机电话号码
	 */
	private String phoneNumber;
}
