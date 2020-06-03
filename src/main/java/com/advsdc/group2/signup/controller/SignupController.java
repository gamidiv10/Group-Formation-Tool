package com.advsdc.group2.signup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.advsdc.group2.signup.models.User;
import com.advsdc.group2.signup.services.SignupService;
import com.advsdc.group2.signup.services.SignupServiceImpl;

@Controller
public class SignupController {
	
	private SignupService signupServiceImpl;
	
	@GetMapping("/register")
	public String showSignupForm(WebRequest request, Model model) {
		model.addAttribute("user", new User());
        model.addAttribute("userIdError", false);
        model.addAttribute("passwordMatchError", false);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSubmit( @ModelAttribute User user, Model model) {

		this.signupServiceImpl = new SignupServiceImpl();
		System.out.println(user);
		boolean userAlreadyExists = signupServiceImpl.isUserInDb(user.getUserId());
		if(userAlreadyExists) {
			model.addAttribute("user", new User());
	        model.addAttribute("userIdError", true);
			return "register";
		}
		boolean isPasswordMatched = signupServiceImpl.isPasswordMatched(user.getPassword(), user.getMatchingPassword());
		if(isPasswordMatched) {
			signupServiceImpl.createUser(user);
			return "signupresult";
			}
	    model.addAttribute("passwordMatchError", true);
		return "register";
		
	}

}
