package com.fiap.postech.fastfoodsysteminfra.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    public static final long JWT_TOKEN_VALIDITY = 30 * 60 ;
    @Value("${jwt.secret}")
    private String secret ;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

   public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(String texto) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, texto);
    }

  private String doGenerateToken(Map<String, Object> claims, String subject) {

      return Jwts.builder()
              .setSubject(subject)

              .setExpiration(
                      Date.from(
                              LocalDateTime.now().plusMinutes(15L)
                                      .atZone(ZoneId.systemDefault())
                                      .toInstant()))
              .signWith(SignatureAlgorithm.HS256, secret)
              .compact();


    }

   public Boolean validateToken(String token, String texto) {
        final String username = getUsernameFromToken(token);
        return (username.equals(texto) && !isTokenExpired(token));
    }

    public Boolean validateToken(String token) {

        if (token != null ) {
            try {
                String username = getUsernameFromToken(token);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }

        }

        return false;
    }

}