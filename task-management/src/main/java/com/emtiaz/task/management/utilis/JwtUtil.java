package com.emtiaz.task.management.utilis;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component

public class JwtUtil {

    public String extractUserName(String token)
    {
        return extractClaim(token,Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails)
    {
         return generateToken(new HashMap<>(),userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails)
    {
        final String userName = extractUserName(token);

        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private <T> T extractClaim(String token, Function<Claims,T>claimsResolves)
    {
           final Claims claims = extractAllClaims(token);
           return claimsResolves.apply(claims);
    }

    private String generateToken(Map<String,Object>extraClaims, UserDetails userDetails)
    {
         return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*20))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    public boolean isTokenExpired(String token)
    {
          return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token)
    {
        return  extractClaim(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSigningKey()
    {
         byte[] keyBytes = Decoders.BASE64.decode("232hg455g323hgv54546g4324j5456h3424hj545h32h43h");

         return Keys.hmacShaKeyFor(keyBytes);
    }




}
