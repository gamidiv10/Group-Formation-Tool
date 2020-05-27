package com.advsdc.group2.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.advsdc.group2.hello.services.HelloService;

@Controller
public class HelloController {
	@Autowired
	HelloService hs;
	@GetMapping("/greeting")
	  public String hello(Model model) {
	    hs.greeting(model);
	    return "greeting";
	  }
	
	

}
