package com.advsdc.group2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Controller
public class Group2Application {
	public String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public static void main(String[] args) {
		SpringApplication.run(Group2Application.class, args);

	}
	//Home page Mapping
	@GetMapping("/")
	public String hello() {

		return "index";
	}

}
