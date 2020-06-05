package com.advsdc.group2.admin.controller;

import com.advsdc.group2.admin.services.AdminWelcomeService;
import com.advsdc.group2.admin.services.IAdminWelcome;
import com.advsdc.group2.utility.IJwtUtility;
import com.advsdc.group2.utility.JwtUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminWelcomeController {
    private IAdminWelcome adminService = new AdminWelcomeService();

    @GetMapping("/admin/{token}")
    public String adminHome(Model model, String token, @PathVariable("token") String view_token) {
        String tk = "";
        if (token != null) {
            tk = token;
        } else if(view_token != null) {
            tk = view_token;
        }
        JwtUtility jwtUtility = new JwtUtility();
        model.addAttribute("token", tk);
        if(jwtUtility.isTokenExpired(tk)){
            return "login";
        }
        adminService.getWelcomePage(model);
        return "admin/welcome";
    }
}
