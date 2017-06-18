package org.apache.zuureka.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
@RequestMapping("/zuureka/services")
public class RegisteredServicesController {
	
	@Autowired
	EurekaClient eurekaClient;

		/**
		 * Returns a JSON with list of service names
		 * @return
		 */
		@RequestMapping(value="/", produces = "application/json")
		
		public @ResponseBody List<Application> getListOfRegisteredServices() {
			System.out.println("Came here in getListOfRegisteredServices");
			return eurekaClient.getApplications().getRegisteredApplications();
		}

}
