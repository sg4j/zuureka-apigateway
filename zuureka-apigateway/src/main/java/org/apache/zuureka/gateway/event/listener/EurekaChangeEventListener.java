package org.apache.zuureka.gateway.event.listener;

import org.apache.zuureka.gateway.dto.EurekaChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class EurekaChangeEventListener {

	@Autowired
	private SimpMessagingTemplate template;
	
	private static final String ADD_EVENT = "add";
	private static final String REMOVE_EVENT = "remove";
	
	@EventListener
	public void handleEurekaInstanceRegisteredEvent(EurekaInstanceRegisteredEvent event){
		
		System.out.println("Came here in EurekaInstanceRegisteredEvent with "+event.getInstanceInfo().getInstanceId());
		
		EurekaChangeEvent changeEvent = new EurekaChangeEvent();
		
		changeEvent.setEventName(ADD_EVENT);
		changeEvent.setApplication(event.getInstanceInfo().getAppName());
		
		this.template.convertAndSend("/topic/eurekaAppChangeEvent", changeEvent);
	}
	
	
	@EventListener
	public void handleEurekaInstanceCancelledEvent(EurekaInstanceCanceledEvent event){

		System.out.println("Came here in EurekaInstanceCancelledEvent with "+event.getAppName());
		
		EurekaChangeEvent changeEvent = new EurekaChangeEvent();
		
		changeEvent.setEventName(REMOVE_EVENT);
		changeEvent.setApplication(event.getAppName());
		
		this.template.convertAndSend("/topic/eurekaAppChangeEvent", changeEvent);
	}
}
