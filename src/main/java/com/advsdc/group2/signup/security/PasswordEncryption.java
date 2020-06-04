package com.advsdc.group2.signup.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncryption implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        if(rawPassword!=null) {
        	return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt());
        }
		return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
