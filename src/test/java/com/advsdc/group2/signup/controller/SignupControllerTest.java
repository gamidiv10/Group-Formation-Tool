package com.advsdc.group2.signup.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class SignupControllerTest {
	
	private MockMvc mockMvc;
	
	InternalResourceViewResolver viewResolver;

	@Test
	public void showSignupFormTest() throws Exception {
		
		this.viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(new SignupController()).setViewResolvers(viewResolver).build();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/register"))
        .andExpect(status().isOk())
        .andExpect(view().name("register"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
	
//	@Test
//    public void registerSubmitTest() throws Exception {
//        
//		this.viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/jsp/view/");
//        viewResolver.setSuffix(".jsp");
//		this.mockMvc = MockMvcBuilders.standaloneSetup(new SignupController()).setViewResolvers(viewResolver).build();
//
//		this.mockMvc.perform(MockMvcRequestBuilders.post("/register"))
//        .andExpect(status().isOk())
//        .andExpect(view().name("register"))
//        .andExpect(view().name("signupresult"))
//        .andDo(MockMvcResultHandlers.print())
//        .andReturn();    
//        }

}
