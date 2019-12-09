package com.webonise.weatherapp.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Service;
import com.webonise.weatherapp.exception.JwtTokenExpiredException;
import com.webonise.weatherapp.model.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

  @Value("${jwt.signin.secret.key}")
  private String SECRET_KEY;

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) throws JwtException {
    try {
      return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    } catch (JwtException exception) {
      throw new JwtTokenExpiredException(exception.getMessage());
    }
  }

  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public String generateToken(UserData userData) {
    Map<String, Object> claims = new HashMap<String, Object>();
    return createToken(claims, userData.getUsername());
  }

  private String createToken(Map<String, Object> claims, String subjet) {
    return Jwts.builder().setClaims(claims).setSubject(subjet).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 10))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  public Boolean validateToken(String token, UserDetails userData) {
    final String username = extractUsername(token);
    return (username.equals(userData.getUsername()) && !isTokenExpired(token));
  }
}
