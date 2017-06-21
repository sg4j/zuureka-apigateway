package org.apache.zuureka.gateway.event.listener;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaChangeEventListener {

	@EventListener
	public void handleEurekaInstanceRegisteredEvent(EurekaInstanceRegisteredEvent event){
		
		System.out.println("Came here in EurekaInstanceRegisteredEvent with "+event.getInstanceInfo().getInstanceId());
	}
	
	
	@EventListener
	public void handleEurekaInstanceCancelledEvent(EurekaInstanceCanceledEvent event){
		
		System.out.println("Came here in EurekaInstanceCancelledEvent with "+event.getAppName());
	}
}
