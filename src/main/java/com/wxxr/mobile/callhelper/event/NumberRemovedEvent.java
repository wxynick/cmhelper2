/**
 * 
 */
package com.wxxr.mobile.callhelper.event;

/**
 * @author neillin
 *
 */
public class NumberRemovedEvent extends PrivateSMEvent {
	public String getNumber() {
		return (String)getSource();
	}
	
	public void setNumber(String num){
		setSource(num);
	}
}
