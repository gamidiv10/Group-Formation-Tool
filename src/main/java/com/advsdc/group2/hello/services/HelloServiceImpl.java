package com.advsdc.group2.hello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.advsdc.group2.hello.dao.HelloDao;

@Service
public class HelloServiceImpl implements HelloService {
	@Autowired
	HelloDao hd;
	@Override
	public String greeting(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("greeting","hey");
		
		model.addAttribute("hello",hd.hello());
		return null;
	}


}
