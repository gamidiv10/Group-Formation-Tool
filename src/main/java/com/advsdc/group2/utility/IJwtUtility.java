package com.advsdc.group2.utility;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;
import java.util.function.Function;

public interface IJwtUtility {

    public String getUsernameFromToken(String token);

    public Date getExpirationDateFromToken(String token);

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    public Claims getAllClaimsFromToken(String token);

    public Boolean isTokenExpired(String token);

    public String generateToken(String userId);

    public Boolean validateToken(String token, UserDetails userDetails);
}
