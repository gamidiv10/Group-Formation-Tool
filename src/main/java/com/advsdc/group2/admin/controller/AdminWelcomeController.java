package com.advsdc.group2.admin.controller;

import com.advsdc.group2.admin.services.AdminWelcomeService;
import com.advsdc.group2.admin.services.IAdminWelcome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminWelcomeController {
    private IAdminWelcome adminService = new AdminWelcomeService();
    @GetMapping("/admin")
    public String adminHome(Model model) {
        adminService.getWelcomePage(model);
        return "admin/welcome";
    }
}
