package org.apache.zuureka.gateway.event.listener;

import org.apache.zuureka.gateway.dto.EurekaChangeEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class EurekaChangeEventListener {

	private static final String ADD_EVENT = "add";
	private static final String REMOVE_EVENT = "remove";
	
	@EventListener
	@SendTo("/topic/eurekaAppChangeEvent")
	public EurekaChangeEvent handleEurekaInstanceRegisteredEvent(EurekaInstanceRegisteredEvent event){
		
		System.out.println("Came here in EurekaInstanceRegisteredEvent with "+event.getInstanceInfo().getInstanceId());
		
		EurekaChangeEvent changeEvent = new EurekaChangeEvent();
		
		changeEvent.setEventName(ADD_EVENT);
		changeEvent.setApplication(event.getInstanceInfo().getAppName());
		
		return changeEvent;
	}
	
	
	@EventListener
	@SendTo("/topic/eurekaAppChangeEvent")
	public EurekaChangeEvent handleEurekaInstanceCancelledEvent(EurekaInstanceCanceledEvent event){

		System.out.println("Came here in EurekaInstanceCancelledEvent with "+event.getAppName());
		
		EurekaChangeEvent changeEvent = new EurekaChangeEvent();
		
		changeEvent.setEventName(REMOVE_EVENT);
		changeEvent.setApplication(event.getAppName());
		
		return changeEvent;
	}
}
