package org.apache.zuureka.gateway;

import org.apache.zuureka.dashboard.ui.config.EnableZuurekaDashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
@EnableEurekaClient
@EnableZuurekaDashboard
public class ZuurekaApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(ZuurekaApiGateway.class, args);
	}
}
