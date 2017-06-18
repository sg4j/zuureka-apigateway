package org.apache.zuureka.dashboard.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netflix.discovery.EurekaClient;

@Controller
public class DashboardController {

@Autowired
EurekaClient eurekaClient;

	@RequestMapping("/dashboard")
	public String dashboard() {
		System.out.println("Applications currently registered are "+eurekaClient.getApplications().size());
		return "index";
	}

}