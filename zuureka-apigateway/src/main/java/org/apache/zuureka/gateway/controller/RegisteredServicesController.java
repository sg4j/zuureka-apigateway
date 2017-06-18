package org.apache.zuureka.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
@RequestMapping("/zuureka/services")
public class RegisteredServicesController {

	@Autowired
	EurekaClient eurekaClient;

	/**
	 * Returns a JSON with list of service names
	 * 
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/", produces = "application/json")

	public @ResponseBody List<Application> getListOfRegisteredServices() {
		return eurekaClient.getApplications().getRegisteredApplications();
	}

	/**
	 * Returns a JSON with list of Instances of a particular service
	 * 
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/{serviceName}", produces = "application/json")
	public @ResponseBody List<InstanceInfo> getServiceInstances(@PathVariable(value="serviceName") String serviceName) {
		return eurekaClient.getApplication(serviceName).getInstances();
	}
	
	/**
	 * Returns a JSON with Instance details of a particular service
	 * 
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/{serviceName}/instance/{instanceId}", produces = "application/json")
	public @ResponseBody InstanceInfo getServiceInstanceDetails(@PathVariable(value="serviceName") String serviceName
															   ,@PathVariable(value="instanceId") String instanceId) {
		return eurekaClient.getApplication(serviceName).getByInstanceId(instanceId);
	}	
}
