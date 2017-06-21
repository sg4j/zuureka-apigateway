package org.apache.zuureka.gateway.dto;

import java.io.Serializable;

public class EurekaChangeEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String eventName;
	private String application;
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getApplication() {
		return application;
	}
	
	public void setApplication(String application) {
		this.application = application;
	}
}
