package org.apache.zuureka.dashboard.ui;

import org.apache.zuureka.dashboard.ui.config.EnableZuurekaDashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZuurekaDashboard
public class ZuurekaDashboardMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuurekaDashboard.class, args);
	}

}