package com.advsdc.group2.hello.dao;

import org.springframework.stereotype.Service;

@Service
public class HelloDoaImpl implements HelloDao {

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "What's up??";
	}

}
