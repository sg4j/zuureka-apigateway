package org.apache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
@EnableEurekaClient
@EnableAdminServer
public class ZuurekaApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(ZuurekaApiGateway.class, args);
	}
}
