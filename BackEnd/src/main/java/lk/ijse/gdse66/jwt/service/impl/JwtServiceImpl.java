package lk.ijse.gdse66.jwt.service.impl;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lk.ijse.gdse66.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${token.key}")
    private String jwtKey;

    @Override
    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());
        Date currentDate = new Date();
        Date expiredDate = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24);
        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(currentDate)
                .setExpiration(expiredDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
        return accessToken;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String subject = extractClaims(token, Claims::getSubject);
        return subject.equals(userDetails.getUsername()) && !isExpired(token);
    }

    private Key getSignKey() {
        byte[] bytes = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(bytes);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .setAllowedClockSkewSeconds(5L)     // Set clock skew allowance
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimResolve) {
        Claims claims = getAllClaims(token);
        return claimResolve.apply(claims);
    }

    private boolean isExpired(String token) {
        Date expiredDate = extractClaims(token, Claims::getExpiration);
        return expiredDate.before(new Date());
    }
}