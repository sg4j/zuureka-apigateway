package org.apache.zuureka.gateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/api")
public class DashboardController {

	@RequestMapping("/hello")
	public String dashboard() {
		System.out.println("---------------Hello World---------------");
		return "index";
	}

}