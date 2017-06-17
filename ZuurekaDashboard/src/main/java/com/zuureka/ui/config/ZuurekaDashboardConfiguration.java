package com.zuureka.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zuureka.ui.ZuurekaDashboard;

@Configuration
public class ZuurekaDashboardConfiguration {

	@Bean
	public ZuurekaDashboard ZuurekaDashboardBean() {
		return new ZuurekaDashboard();
	}
}