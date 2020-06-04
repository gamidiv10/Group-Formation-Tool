package com.advsdc.group2.ta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.forgotpassword.dao.UserDetailsDaoImpl;
import com.advsdc.group2.model.User;
import com.advsdc.group2.ta.services.ITaEnrollmentService;
import com.advsdc.group2.ta.services.ITaEnrollmentServiceImpl;
import com.advsdc.group2.ta.taforms.TAEnrollmentForms;
import com.advsdc.group2.utility.JwtUtility;

@Controller
public class TAEnrollmentController {
	IUserDetailsDao userInfo = new UserDetailsDaoImpl();

	@GetMapping("/taEnrollment/{courseID}/{token}")
	public String initialLanding(@PathVariable("courseID") String courseID, @PathVariable("token") String token,
	 Model model, @ModelAttribute TAEnrollmentForms enrollTA) {
		
		JwtUtility jwtUtility = new JwtUtility();
		if(jwtUtility.isTokenExpired(token)){
			return "login";
		}

		model.addAttribute("enrollTA", enrollTA);
		ITaEnrollmentService ta = new ITaEnrollmentServiceImpl();
		List<User> existingTa = ta.getTAList(courseID, userInfo);
		System.out.println("List in Controller" + existingTa);
		enrollTA.setCourseID(courseID);
		System.out.println("CourseID in ta form model : " + enrollTA.getCourseID());
		if (existingTa.size() > 0) {

			model.addAttribute("TAList", existingTa);
			enrollTA.setTAExist(true);
			model.addAttribute("enrollTA", enrollTA);
			return "ta_enrollment";

		} else {

			model.addAttribute("TAList", existingTa);
			enrollTA.setTAExist(false);
			model.addAttribute("enrollTA", enrollTA);
			return "ta_enrollment";
		}
	}

	@PostMapping("/searchTA")
	public String serachTA(Model model, @ModelAttribute TAEnrollmentForms enrollTA) {

		ITaEnrollmentService ta = new ITaEnrollmentServiceImpl();
		model.addAttribute("enrollTA", enrollTA);

		String bannerID = enrollTA.getbId();
		String courseID = enrollTA.getCourseID();
		System.out.println("CourseID in ta form model search TA controller: " + courseID);
		System.out.println("Banner ID from user : " + bannerID);
		enrollTA.setCourseID(courseID);

		User showUsers = ta.showUsers(courseID, userInfo, bannerID);
		if (showUsers != null) {
			System.out.println("inside showusers : " + showUsers.getUser_id());
			enrollTA.setSearchUser(true);
			enrollTA.setBannerID(showUsers.getUser_id());
			enrollTA.setFirst_name(showUsers.getFirst_name());
			enrollTA.setLast_name(showUsers.getLast_name());
			enrollTA.setEmail(showUsers.getEmail());
			
			enrollTA.setCourseID(courseID);
			return "ta_enrollment";
		} else {
			enrollTA.setCourseID(courseID);
			enrollTA.setSearchUser(false);
			return "ta_enrollment";
		}
		
	}

	@PostMapping("/addTA")
	public String addTA(Model model, @ModelAttribute TAEnrollmentForms enrollTA) {
		
		System.out.println("Add TA controller");
		
		ITaEnrollmentService ta = new ITaEnrollmentServiceImpl();
		model.addAttribute("enrollTA", enrollTA);

		String bannerID = enrollTA.getbId();
		String courseID = enrollTA.getCourseID();
		enrollTA.setCourseID(courseID);
		enrollTA.setBannerID(bannerID);
		System.out.println("CourseID in ta form model add TA controller: " + courseID);
		System.out.println("Banner ID IN add ta controller from form model : " + bannerID);

		int insertedRecord = ta.addTA(courseID, userInfo, bannerID);
		System.out.println("records value " +insertedRecord);

		if (insertedRecord == 1) {
			System.out.println("records inserted : " + insertedRecord);
			enrollTA.setIsaddedTA(true);
			enrollTA.setBannerID("");

			return "ta_enrollment";
		} else {
			enrollTA.setIsaddedTA(false);
			return "ta_enrollment";
		}

	}

}
