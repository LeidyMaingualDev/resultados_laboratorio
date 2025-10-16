package com.laboratorio.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.laboratorio.entities.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secretKey;

    private final int expirationHours = 2;

    public String generateToken(User user){
        Instant now = Instant.now();
        Instant expiration = now.plus(expirationHours, ChronoUnit.HOURS);

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(now)
                .withExpiresAt(expiration)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public DecodedJWT validateToken(String token) {
        return JWT.require(Algorithm.HMAC256(secretKey))
                .build()
                .verify(token);
    }

    public String getEmailFromToken(String token) {
        return validateToken(token).getSubject();
    }
}
