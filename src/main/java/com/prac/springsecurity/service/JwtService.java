package com.prac.springsecurity.service;

import com.prac.springsecurity.config.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JwtService {

    public String issue(String username, String password, List<String> roles) {

        byte[] signingKey = JwtConfig.JWT_SECRET.getBytes();

        String token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", JwtConfig.TOKEN_TYPE)
                .setIssuer(JwtConfig.TOKEN_ISSUER)
                .setAudience(JwtConfig.TOKEN_AUDIENCE)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("role", roles)
                .compact();

        return token;
    }
}
