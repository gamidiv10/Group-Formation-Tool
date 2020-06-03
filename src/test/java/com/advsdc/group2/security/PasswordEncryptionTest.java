package com.advsdc.group2.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncryptionTest {

    @Test
    public void encodeTest(){
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        assertNotNull(passwordEncryption.encode("Pass@1"));
    }
    @Test
    public void matchesTest(){
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        String encodedPassword = passwordEncryption.encode("Pass@1");
        assertTrue(passwordEncryption.matches("Pass@1", encodedPassword));
    }


}
