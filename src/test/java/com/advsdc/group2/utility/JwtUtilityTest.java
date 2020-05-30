package com.advsdc.group2.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilityTest {

    @Test
    public void getUsernameFromTokenTest() {
        JwtUtility jwtUtility = new JwtUtility();
        String token = jwtUtility.generateToken("B00834696");
        assertNotNull(jwtUtility.getClaimFromToken(token, Claims::getSubject));
    }
    @Test
    public void getExpirationDateFromTokenTest() {
        JwtUtility jwtUtility = new JwtUtility();
        String token = jwtUtility.generateToken("B00834696");
        assertNotNull(jwtUtility.getClaimFromToken(token, Claims::getExpiration));
    }
    @Test
    public void getClaimFromTokenTest() {
        JwtUtility jwtUtility = new JwtUtility();
        String token = jwtUtility.generateToken("B00834696");
        assertNotNull(jwtUtility.getAllClaimsFromToken(token));
    }
    @Test
    public void getAllClaimsFromTokenTest() {
        JwtUtility jwtUtility = new JwtUtility();
        String token = jwtUtility.generateToken("B00834696");
        assertNotNull(Jwts.parser().setSigningKey("Group2").parseClaimsJws(token).getBody());
    }
    @Test
    public void isTokenExpiredTest() {
        JwtUtility jwtUtility = new JwtUtility();
        String token = jwtUtility.generateToken("B00834696");
        Date expiration = jwtUtility.getExpirationDateFromToken(token);
        assertFalse(expiration.before(new Date()));
    }
    @Test
    public void generateTokenTest() {
        JwtUtility jwtUtility = new JwtUtility();
        assertNotNull(jwtUtility.generateToken("B00834696"));
    }
    @Test
    public void validateToken() {
        JwtUtility jwtUtility = new JwtUtility();
        String token = jwtUtility.generateToken("B00834696");
        String username = jwtUtility.getUsernameFromToken(token);
        assertTrue(username.equals("B00834696") && !jwtUtility.isTokenExpired(token));
    }
}
