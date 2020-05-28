package com.advsdc.group2.login.controller;

import com.advsdc.group2.login.models.UserCredentials;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginControllerTest {
    @Test
    public void loginSubmitTest(){

        LoginController loginController = new LoginController();
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUserId("B00834696");
        userCredentials.setPassword("Pass@1");
        assertNotNull(loginController.loginSubmit(userCredentials));

    }

    @Test
    public void loginFormTest(){
        LoginController loginController = new LoginController();
        Model model = new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return null;
            }

            @Override
            public Model addAttribute(Object attributeValue) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Object getAttribute(String attributeName) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        assertNotNull(loginController.loginForm(model));
    }

}
