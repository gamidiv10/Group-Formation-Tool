package com.advsdc.group2.signup.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.advsdc.group2.security.PasswordEncryption;

public class PasswordEncryptionTest {

    @Test
    public void encodeTest(){
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        assertNotNull(passwordEncryption.encode("passwoord"));
    }
    @Test
    public void matchesTest(){
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        String encodedPassword = passwordEncryption.encode("password");
        assertTrue(passwordEncryption.matches("password", encodedPassword));
    }


}
