package org.apache.zuureka.dashboard.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ZuurekaDashboardMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuurekaDashboard.class, args);
	}

}