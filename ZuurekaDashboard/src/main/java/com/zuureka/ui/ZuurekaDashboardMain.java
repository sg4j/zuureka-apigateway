package com.zuureka.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zuureka.ui.config.EnableZuurekaDashboard;

@SpringBootApplication
@EnableZuurekaDashboard
public class ZuurekaDashboardMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuurekaDashboard.class, args);
	}

}