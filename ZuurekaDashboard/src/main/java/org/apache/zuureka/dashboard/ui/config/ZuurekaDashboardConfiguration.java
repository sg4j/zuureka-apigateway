package org.apache.zuureka.dashboard.ui.config;

import org.apache.zuureka.dashboard.ui.ZuurekaDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuurekaDashboardConfiguration {

	@Bean
	public ZuurekaDashboard ZuurekaDashboardBean() {
		return new ZuurekaDashboard();
	}
}