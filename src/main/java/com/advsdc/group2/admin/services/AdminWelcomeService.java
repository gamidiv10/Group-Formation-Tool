package com.advsdc.group2.admin.services;

import org.springframework.ui.Model;

public class AdminWelcomeService implements IAdminWelcome {
    @Override
    public String getWelcomePage(Model model) {
        model.addAttribute("course","Course Management");
        model.addAttribute("user", "Instructor Management");
        model.addAttribute("welcome_message", "Welcome to admin Panel!");
        return null;
    }
}
