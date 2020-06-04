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
        model.addAttribute("form", true);
        model.addAttribute("result", false);
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
	        model.addAttribute("form", true);
	        model.addAttribute("result", false);
			return "register";
		}
		boolean isPasswordMatched = signupServiceImpl.isPasswordMatched(user.getPassword(), user.getMatchingPassword());
		if(isPasswordMatched) {
			signupServiceImpl.createUser(user);
			model.addAttribute("form", false);
	        model.addAttribute("result", true);
			return "register";
			}
	    model.addAttribute("passwordMatchError", true);
	    System.out.println("Password not matched ");
	    model.addAttribute("form", true);
        model.addAttribute("result", false);
		return "register";
		
	}

}
