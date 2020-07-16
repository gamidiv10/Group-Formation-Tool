package CSCI5308.GroupFormationTool.Security;

import CSCI5308.GroupFormationTool.Courses.CourseDB;
import org.springframework.security.crypto.bcrypt.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BCryptPasswordEncryption implements IPasswordEncryption {
    private Logger log = Logger.getLogger(BCryptPasswordEncryption.class.getName());
    private BCryptPasswordEncoder encoder;

    public BCryptPasswordEncryption() {
        encoder = new BCryptPasswordEncoder();
    }

    public String encryptPassword(String rawPassword) {
        log.log(Level.INFO, "Password Encrypted");
        return encoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword, String encryptedPassword) {
        return encoder.matches(rawPassword, encryptedPassword);
    }
}
